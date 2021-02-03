<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2/2/2021
  Time: 9:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>

<h2>PRODUCT STORE</h2>

<table>
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>QUANTITY</th>
        <th>IS ACTIVE</th>
        <th>INSERT DATE</th>
    </tr>
    <c:forEach items="${storeList}" var="s">
        <tr>
            <td>${s.id}</td>
            <td>${s.name}</td>
            <td>${s.quantity}</td>
            <td>${s.isActive}</td>
            <td>${s.insertDate}</td>
        </tr>
    </c:forEach>


</table>

</body>
</html>