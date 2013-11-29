<!--
        Elmar Aliyev
-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Meaningless app</title>
    </head>
    <body>
        <table cellspacing="5" cellpadding="5" border="1">
            <tr>
                <td>Username</td>
                <td><%=session.getAttribute("username")%></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><%=session.getAttribute("password")%></td>
            </tr>
            <tr>
                <td>Login Time</td>
                <td><%=session.getAttribute("loginTime")%></td>
            </tr>
        </table>
    </body>
</html>
