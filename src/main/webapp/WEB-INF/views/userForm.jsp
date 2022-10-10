<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <title>User Registration Form</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/4.1.1/css/bootstrap.min.css" />

</head>

<body>

<h2>Registration Form</h2>

<form:form method="POST" modelAttribute="user" action="./new">
    <form:input type="hidden" path="id" id="id"/>
    <table class="table table-dark">
        <tr>
            <td><label for="firstName">First name: </label> </td>
            <td><form:input path="firstName" id="firstName"/></td>

        </tr>

        <tr>
            <td><label for="lastName">Last name: </label> </td>
            <td><form:input path="lastName" id="lastName"/></td>

        </tr>

        <tr>
            <td><label for="birthDate">Birth Date: </label> </td>
            <td><form:input type="date" path="birthDate" id="birthDate"/></td>
        </tr>

        <tr>
            <td><label for="username">Username: </label> </td>
            <td><form:input path="username" id="username"/></td>

        </tr>
        <tr>
            <td><label for="password">Password: </label> </td>
            <td><form:input path="password" id="password"/></td>

        </tr>


        <tr>
            <input type="submit" value="Register"/>

        </tr>
    </table>
</form:form>
<br/>
<br/>
Go back to <a href="./list">List of Users</a>
</body>
</html>