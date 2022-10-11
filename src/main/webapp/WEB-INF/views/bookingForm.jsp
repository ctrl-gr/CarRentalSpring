<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <title>Booking Form</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/4.1.1/css/bootstrap.min.css"/>
</head>

<body>

<h2>Booking Form</h2>

<form:form method="POST" action="${pageContext.request.contextPath}/car/getAvailableCars" modelAttribute="booking">

    <table class="table table-dark">
        <tr>
            <td><label for="startDate">Start Date: </label></td>
            <td><form:input type="date" path="startDate" id="startDate"/></td>

        </tr>

        <tr>
            <td><label for="endDate">End Date: </label></td>
            <td><form:input type="date" path="endDate" id="endDate"/></td>

        </tr>
        <tr>

        </tr>
    </table>
    <input type="hidden" name="userId" value="${userId}"/>
    <input type="submit" value="View all the available cars"/>
</form:form>
<br/>
<br/>
Go back to <a href="${pageContext.request.contextPath}/booking/homepage/${userId}">homepage</a>
</body>
</html>
