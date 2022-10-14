<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <title>Car registration Form</title>
    <script src="${pageContext.request.contextPath}/webjars/jquery/3.6.0/jquery.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/4.1.1/css/bootstrap.min.css"/>
    <script src="${pageContext.request.contextPath}/webjars/bootstrap/4.1.1/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/popper.js/1.14.1/popper.js"></script>
</head>

<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand">Car Rental</a>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}/log/adminHomepage?userId=${userId}">Homepage
                    <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    User management area
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/user/getNew?userId=${userId}">Insert
                        new user</a>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/user/list?userId=${userId}">Show
                        all the users</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown2" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    Booking management area
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown2">
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/booking/list?userId=${userId}">Show
                        all the bookings</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown3" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    Car management area
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/car/getNew?userId=${userId}">Insert
                        new car</a>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/car/list?userId=${userId}">Show
                        all the cars</a>
                </div>
            </li>
        </ul>
    </div>
</nav>
<h2>Car registration form</h2>

<form:form method="POST" modelAttribute="car" action="${pageContext.request.contextPath}/car/new">
    <form:input type="hidden" path="id" id="id"/>
    <table>
        <tr>
            <td><label for="licensePlate">License Plate: </label></td>
            <td><form:input path="licensePlate" id="licensePlate"/></td>

        </tr>

        <tr>
            <td><label for="manufacturer">Manufacturer: </label></td>
            <td><form:input path="manufacturer" id="manufacturer"/></td>

        </tr>

        <tr>
            <td><label for="model">Model: </label></td>
            <td><form:input path="model" id="model"/></td>
        </tr>
        <tr>
            <td><label for="year">Year: </label></td>
            <td><form:input path="year" id="year"/></td>
        </tr>
        <tr>
            <td><label for="type">Type: </label></td>
            <td><form:input path="type" id="type"/></td>

        </tr>
        <tr>
            <td><label for="seats">Seats: </label></td>
            <td><form:input path="seats" id="seats"/></td>

        </tr>
    </table>
    <input type="hidden" name="userId" value="${userId}"/>
    <input type="submit" value="Register"/>
</form:form>


<br/>
<br/>
</body>
</html>
