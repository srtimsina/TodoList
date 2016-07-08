<%--
  Created by IntelliJ IDEA.
  User: Suryaraj Timsina
  Date: 6/28/16
  Time: 9:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
  <html>
  <head>
    <title>Todolist</title>
    <link rel= "stylesheet" href= "main.css">
  </head>
  <body>
  <div id ="container">
    <div id = "header">
      <h1 align="center">
        TO DO LIST
      </h1>
    </div>
    <div id="content">
      <form action = "/index" method = "post">
        Task: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="task"><br><br>
        Status:&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" name="status"><br><br>
        Start date:<input type="date" name="sdate"><br><br>
        End date: &nbsp;<input type="date" name="edate"><br><br>

        <input type="submit" value="Submit">
      </form>
        <a href="/index"><button type="button">View todo List</button></a>
    </div>
    <div id="footer">
      &copy 2016, Suryaraj Timsina, All rights reserved.
    </div>
  </div>

  </body>
  </html>

