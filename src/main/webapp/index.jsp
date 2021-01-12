<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import ="java.util.*" %>
<%@ page import ="com.sample.*" %>
<%@ page import ="static com.sample.Globals.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>List Contacts</title>
    <link rel="stylesheet" type="text/css" href=",.css" />
</head>
<body>
    <header>
        JavaContactsExample
    </header>
<div class="the-width">
    <h1>
        A list of the Contacts • <a href="edit.jsp?id=0">Add Contact</a>
    </h1>
    <table class="fancy">
        <thead>
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email Address</th>
                <th></th>
            </tr>
        </thead>
        <tbody><%
            for (OurData.Contact r : OurData.THE_MAP.values()) {%>
                <tr<%if (String.valueOf(r.id).equals(request.getParameter("highlight"))) {%> class="highlight"<%}%>>
                    <td><%=r.id%></td>
                    <td><%=htmlE(r.nameFirst)%></td>
                    <td><%=htmlE(r.nameLast)%></td>
                    <td><%=htmlE(r.email)%></td>
                    <td><a href="edit.jsp?id=<%=r.id%>">View/Edit</a></td>
                </tr><%
            }%>
        </tbody>
    </table>
</div>
</body>
</html>