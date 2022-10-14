<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Car list</title>
    <script src="${pageContext.request.contextPath}/webjars/jquery/3.6.0/jquery.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/4.1.1/css/bootstrap.min.css"/>
    <script src="${pageContext.request.contextPath}/webjars/bootstrap/4.1.1/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/popper.js/1.14.1/popper.js"></script>
</head>

<body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">Car Rental</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <div class="navbar-nav">
                    <a class="nav-item nav-link active"
                       href="${pageContext.request.contextPath}/log/userHomepage?userId=${userId}">Homepage
                        <span class="sr-only">(current)</span></a>
                    <a class="nav-item nav-link" href="${pageContext.request.contextPath}/booking/getNew?userId=${userId}">Make
                        a new
                        reservation</a>
                    <a class="nav-item nav-link" href="${pageContext.request.contextPath}/booking/myBookings?userId=${userId}">Show
                        all my
                        reservations</a>
                </div>
            </div>
        </nav>

<h2>Available cars</h2>
Hey ${username}, here you are the available cars from <fmt:formatDate type="date" value="${startDate}" /> to <fmt:formatDate type="date" value="${endDate}" />.
        <br/> <br/>
<table class="table table-dark">
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
            <td><form:form action="${pageContext.request.contextPath}/booking/new" method="post" modelAttribute="booking">
                <form:input type="hidden" path="startDate" id="startDate" />
                <form:input type="hidden" path="endDate" id="endDate" />
                <input type="hidden" name="userId" value="${booking.user.id}" />
                <form:input type="hidden" path="isApproved" id="isApproved" />
                <input type="hidden" name="carId" value="${car.id}" />
                <input type="submit" value="Book">
            </form:form></td>
        </tr>
    </c:forEach>
</table>
<br/>
</body>
</html>