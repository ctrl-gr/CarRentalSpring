<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Car list</title>
</head>

<body>
<h2>Available cars</h2>
<!--${username},--> here you are the available cars from ${startDate} to ${endDate}
<table>
    <tr>
        <td>License Plate</td>
        <td>Manufacturer</td>
        <td>Model</td>
        <td>Type</td>
        <td>Year</td>
        <td>Seats</td>
        <td>Book</td>
    </tr>
    <c:forEach items="${availableCars}" var="car">
        <tr>
            <td><c:out value="${car.licensePlate}"/></td>
            <td><c:out value="${car.manufacturer}"/></td>
            <td><c:out value="${car.model}"/></td>
            <td><c:out value="${car.type}"/></td>
            <td><c:out value="${car.year}"/></td>
            <td><c:out value="${car.seats}"/></td>
            <td><form action="${pageContext.request.contextPath}/booking/new" method="post">
                <input type="submit" value="Book">
            </form></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="car/new" />Add New Car</a>
</body>
</html>
