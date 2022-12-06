<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>User Registration Form</title>
    <script src="${pageContext.request.contextPath}/webjars/jquery/3.6.0/jquery.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/4.1.1/css/bootstrap.min.css"/>
    <script src="${pageContext.request.contextPath}/webjars/bootstrap/4.1.1/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/popper.js/1.14.1/popper.js"></script>
    <style>
        .error {
            color: red
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Car Rental</a>
</nav>


<form:form method="POST" modelAttribute="user" action="./register">
    <form:input type="hidden" path="id" id="id"/>
    <br/><br/>
    <label for="firstName">First name: </label>
    <form:input path="firstName" id="firstName"/>
    <form:errors path="firstName" cssClass="error"/>
    <br/><br/>
    <label for="lastName">Last name: </label>
    <form:input path="lastName" id="lastName"/>
    <form:errors path="lastName" cssClass="error"/>
    <br/><br/>
    <label for="birthDate">Birth Date: </label>
    <form:input type="date" path="birthDate" id="birthDate"/>
    <form:errors path="birthDate" cssClass="error"/>
    <br/><br/>
    <label for="username">Username: </label>
    <form:input path="username" id="username"/>
    <form:errors path="username" cssClass="error"/>
    <br/><br/>
    <label for="password">Password: </label>
    <form:input path="password" id="password"/>
    <form:errors path="password" cssClass="error"/>
    <br/><br/>
    <input type="submit" value="Register"/>
</form:form>

</body>
</html>
