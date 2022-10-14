<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Booking Form</title>
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
               href="${pageContext.request.contextPath}/login/homepage">Homepage
                <a class="nav-item nav-link" href="${pageContext.request.contextPath}/booking/new">Make
                    a new
                    reservation</a>
                <a class="nav-item nav-link"
                   href="${pageContext.request.contextPath}/booking/myBookings">Show
                    all my
                    reservations</a>
        </div>
    </div>
</nav>


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
<form action="${pageContext.request.contextPath}/login/homepage" method="get">
    <input type="submit" value="Go back to the homepage"/>
</form>
</body>
</html>
