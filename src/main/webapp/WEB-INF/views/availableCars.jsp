<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Car list</title>
</head>

<body>
<h2>Available cars</h2>
${username}, here you are the available cars from ${startDate} to ${endDate}
<table>
    <tr>
        <td>License Plate</td>
        <td>Manufacturer</td>
        <td>Model</td>
        <td>Type</td>
        <td>Year</td>
        <td>Seats</td>
    </tr>
    <c:forEach items="${availableCars}" var="car">
        <tr>
            <td>${car.licensePlate}</td>
            <td>${car.manufacturer}</td>
            <td>${car.model}</td>
            <td>${car.type}</td>
            <td>${car.year}</td>
            <td>${car.seats}</td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="car/new" />Add New Car</a>
</body>
</html>
