<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Car list</title>
    <script src="${pageContext.request.contextPath}/webjars/jquery/3.6.0/jquery.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/4.1.1/css/bootstrap.min.css"/>
    <script src="${pageContext.request.contextPath}/webjars/bootstrap/4.1.1/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/popper.js/1.14.1/popper.js"></script>
</head>

<body>
<c:choose>
    <c:when test="${adminOk == true}">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand">Car Rental</a>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="${pageContext.request.contextPath}/booking/homepage?userId=${userId}">Homepage <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            User management area
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/user/getNew">Insert new user</a>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/user/list">Show all the users</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown2" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Booking management area
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown2">
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/booking/getNew?userId=${userId}">Make a new reservation</a>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/booking/list">Show all the bookings</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown3" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Car management area
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/car/getNew">Insert new car</a>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/car/list">Show all the cars</a>
                        </div>
                    </li>
                </ul>
            </div>
        </nav>
    </c:when>
    <c:when test="${userOk== true}">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">Car Rental</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <div class="navbar-nav">
                    <a class="nav-item nav-link active"
                       href="${pageContext.request.contextPath}/booking/homepage?userId=${userId}">Homepage
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
    </c:when>
</c:choose>
<h2>Available cars</h2>
${username}, here you are the available cars from ${startDate} to ${endDate}
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
<a href="car/new" />Add New Car</a>
</body>
</html>
