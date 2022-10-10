<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Bookings list</title>
</head>


<body>
<h2>Bookings list</h2>
<table>
    <tr>
        <td>Username</td>
        <td>Car License Plate</td>
        <td>Start Date</td>
        <td>End Date</td>
        <td>Approved</td>
    </tr>
    <c:forEach items="${myBookings}" var="booking">
        <tr>
            <td>${booking.user.username}</td>
            <td>${booking.car.licensePlate}</td>
            <td><fmt:formatDate type="date" value="${booking.startDate}" /></td>
            <td><fmt:formatDate type="date" value="${booking.endDate}" /></td>
            <td>${booking.isApproved}</td>
        </tr>
    </c:forEach>
</table>
<br/>
<form action="homepage.jsp"/>
<input type="submit" value="Go back to homepage" />
</form>
</body>
</html>