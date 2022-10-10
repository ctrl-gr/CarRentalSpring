<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User list</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/4.1.1/css/bootstrap.min.css" />
</head>


<body>
<h2>List of Users</h2>
<table class="table table-dark">
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