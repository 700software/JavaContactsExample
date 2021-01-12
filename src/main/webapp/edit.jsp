<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import ="java.util.*" %>
<%@ page import ="com.sample.*" %>
<%@ page import ="static com.sample.Globals.*" %>
<%
    final int id = Integer.parseInt(request.getParameter("id"));
    OurData.Contact r = id == 0 ? new OurData.Contact() : OurData.THE_MAP.get(id);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title><%=id != 0 ? "Edit Contact" : "Add Contact"%></title>
    <link rel="stylesheet" type="text/css" href=",.css" />
</head>
<body>
    <header>
        JavaContactsExample
    </header>
<div class="the-width">
    <h1>
        <%=id != 0 ? "Edit Contact" : "Add Contact"%> • <a href="./">Return</a>
    </h1>
    <form action="javascript:">
        <table>
            <% if (id != 0) { %>
            <tr>
                <td>Contact ID:</td>
                <td><%=id%></td>
            </tr>
            <% } %>
            <tr>
                <td>First Name:</td>
                <td><input name="nameFirst" value="<%=attrE(r.nameFirst)%>"></td>
            </tr>
            <tr>
                <td>Last Name:</td>
                <td><input name="nameLast" value="<%=attrE(r.nameLast)%>"></td>
            </tr>
            <tr>
                <td>Email Address:</td>
                <td><input name="email" value="<%=attrE(r.email)%>"></td>
                <td>
                    <button type="submit">Save Changes</button>
                    <%if (id != 0) {%>
                        -or- <button type="button">Delete</button>
                    <%}%>
                </td>
            </tr>
        </table>
    </form>
    <script src="edit.js"></script>
</div>
</body>
</html>