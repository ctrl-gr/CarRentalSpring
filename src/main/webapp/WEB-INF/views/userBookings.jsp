<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Bookings list</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/4.1.1/css/bootstrap.min.css" />
</head>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Car Rental</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
            <a class="nav-item nav-link" href="${pageContext.request.contextPath}/login/homepage">Homepage</a>
            <a class="nav-item nav-link" href="${pageContext.request.contextPath}/booking/getNew">Make a new reservation</a>
            <a class="nav-item nav-link" href="${pageContext.request.contextPath}/booking/myBookings">Show all my reservations</a>
            <a class="nav-item nav-link" href="<c:url value="/logout" />"> Log out</a>
        </div>
    </div>
</nav>


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

</body>
</html>