<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Bookings list</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/4.1.1/css/bootstrap.min.css" />
</head>


<body>
<h2>Bookings list</h2>
<table class="table table-dark">
    <tr>
        <td>Username</td>
        <td>Car License Plate</td>
        <td>Start Date</td>
        <td>End Date</td>
        <td>Approved</td>
    </tr>
    <c:forEach items="${bookings}" var="booking">
        <tr>
            <td>${booking.user.username}</td>
            <td>${booking.car.licensePlate}</td>
            <td>${booking.startDate}</td>
            <td>${booking.endDate}</td>
            <td>${booking.isApproved}</td>
            <td><select name="approved">
                <option value="false"> False</option>
                <option value="true"> True</option>
            </select></td>
            <td>
                <form action="${pageContext.request.contextPath}/booking/approve"  method="post">
                    <input type="hidden" value="${booking.id}" name="bookingId"/>
                    <input type="submit" value="Update"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="booking/new" />Add new booking</a>
</body>
</html>