
var form = document.forms[0]
var button = document.querySelector('button[type=submit]')
var deleteButton = document.querySelector('button[type=button]')

form.onsubmit = function () {
  if (button.getAttribute('data-state'))
    return false
  button.setAttribute('data-state', 'hold')
  ajaxWave({
    url: 'save-contact' + location.search,
    postdata: formData(form),
    callback: function (wave, request) {
      if (request.status == 200 && wave.json) {
        button.setAttribute('data-state', 'thanks')
        location = wave.json.go
      } else {
        button.setAttribute('data-state', 'whoops')
        alert(wave.text || wave.whoops)
        button.removeAttribute('data-state')
      }
    },
  })
}

function formData(form) {
  var data = ''
  for (var i = 0; i < form.elements.length; i++) {
    var e = form.elements[i]
    if (e.tagName != 'BUTTON' && !e.disabled && e.name && (e.tagName != 'INPUT' || e.type != 'radio' && e.type != 'checkbox' || e.checked))
      if (e.tagName == 'select') {
        for (var j = 0; j < e.options.length; j++)
          if (e.options[j].selected)
            data += '&' + encodeURIComponent(e.name) + '=' + encodeURIComponent(e.options[j].value)
      } else
        data += '&' + encodeURIComponent(e.name) + '=' + encodeURIComponent(e.value)
  }
  return data.substring(1)
}

function ajaxWave(o) {

  if (!o.timeout) o.timeout = 1000 * 20

  var request = new XMLHttpRequest()

  var wave = {}

  request.onreadystatechange = function () {
    if (request.readyState != 4) return
    clearTimeout(timer)

    if (!wave.whoops) // check timeout reached
      if (request.status && request.status < 12000) {

        wave.ctype = request.getResponseHeader('Content-Type')
        if (wave.ctype) wave.ctype = wave.ctype.replace(/\s*;[\s\S]*/, '')

        wave.whoops = 'HTTP ' + request.status + ' error'

        if (wave.ctype == 'application/json') {
          try {
            wave.json = JSON.parse(request.responseText)
          } catch (e) {
            wave.whoops = 'JSON parse error'
          }
        } else if (wave.ctype == 'text/plain')
          wave.text = request.responseText
        else if (wave.ctype == 'text/html')
          wave.html = request.responseText

      } else
        wave.whoops = 'Internet Connection Failure'

    if (o.callback)
      o.callback(wave, request)

  }

  request.open(o.postdata != null ? 'POST' : 'GET', o.url, true)
  if (typeof o.postdata == 'string')
    request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded; charset=UTF-8')
  if (o.beforeSend)
    o.beforeSend(request)
  request.send(o.postdata)

  var timer = setTimeout(function () {
    wave.whoops = 'Timeout of ' + (o.timeout / 1000) + ' seconds.'
    request.abort()
  }, o.timeout)

  return request

}
