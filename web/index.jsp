<!--
        Elmar Aliyev
-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Meaningless app</title>
    </head>
    <body>
        <%
            if(session.getAttribute("error_mes")!=null){
        %><b><%=session.getAttribute("error_mes")%></b><br/>
        <%
            }
        %>
        <form action="LoginServlet" method="post">
            <table cellpadding="5" cellspacing="5">
                <tr>
                    <td>Username</td>
                    <td><input type="text" name="username" size="20" tabindex="1"></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name ="password" size="20" tabindex="2"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="button" value="Log in" tabindex="3" onclick="validate(this.form)"></td>
                </tr>
            </table>
        </form>
        
        <script language="JavaScript">
            function validate(form){
                if (form.username.value == ""){
                    alert("Please, fill in your username");
                    form.username.focus();
                }
                else if (form.password.value == ""){
                    alert("Please, fill in your password");
                    form.password.focus();
                }
                else{
                    form.submit();
                }
            }
        </script>
        
        <%
            if(session.getAttribute("error_mes")!=null){
                session.invalidate();
            }
        %>
    </body>
</html>
