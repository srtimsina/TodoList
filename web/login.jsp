<%--
  Created by IntelliJ IDEA.
  User: Suryaraj Timsina
  Date: 7/8/16
  Time: 9:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todolist</title>
    <link rel= "stylesheet" href= "main.css">
</head>
<body>
<div id ="container">
    <div id = "header">
        <h1 align="center">
            TO DO LIST Login Page
        </h1>
    </div>
    <div id="content">

        <%

            if (request.getAttribute("message")!=null){%>

                <p style="color: red;color: red;margin-left: 37%;background-color: white;width: 27%;">Either username or password is incorrect</p>
        <%
            }
        %>
        <form action = "/login" method = "post">
            <table>
                <tr>
                    <td>
                        <label>User Name</label>
                    </td>
                    <td>
                        <input type="text" name="username">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Password</label>
                    </td>
                    <td>
                        <input type="password" name="pwd">
                    </td>
                </tr>
            </table>
            <input type="submit" value="Submit">
        </form>
    </div>
    <div id="footer">
        &copy 2016, Suryaraj Timsina, All rights reserved.
    </div>
</div>

</body>
</html>

