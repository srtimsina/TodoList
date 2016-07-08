<%--
  Created by IntelliJ IDEA.
  User: Suryaraj Timsina
  Date: 6/28/16
  Time: 9:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Todolist</title>
  <link rel= "stylesheet" href= "Output.css">
</head>

<body>
<div id ="container">

  <div id = "header">
    <h1>
      TO DO LIST
      <a href="/login" style="margin-left: 67%"><button>Logout</button></a>
    </h1>
  </div>

  <div>

      <a href="index.jsp"><button>Add New</button></a>
    <table>
      <tr>
        <th>Id</th>
        <th>Task</th>
        <th>Status</th>
        <th>Startdate</th>
        <th>Enddate</th>
          <th>Actions</th>
      </tr>
      <c:forEach items="${taskList}" var="items">

        <tr>
          <td>${items.id}</td>
          <td>${items.task}</td>
          <td>${items.status}</td>
          <td>${items.startdate}</td>
          <td>${items.enddate}</td>
            <td>
                <a href="/edit?id=${items.id}"><button type="button">Edit</button></a>
                <a href="/delete?id=${items.id}"><button type="button">Delete</button></a>
            </td>
        </tr>
      </c:forEach>
    </table>
  </div>

  <div>
    <div id="footer">
      &copy 2016, Suryaraj Timsina, All rights reserved.
    </div>
  </div>
</div>

</body>
</html>

