<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>User list</title>
</head>


<body>
<h2>List of Users</h2>
<table>
    <tr>
        <td>First Name</td>
        <td>Last Name</td>
        <td>Birth Date</td>
        <td>Username</td>
        <td>Paswword</td>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.birthDate}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="./new" />Add New User</a>
</body>
</html>