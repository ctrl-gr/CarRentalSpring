<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Homepage</title>
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
                <a class="nav-link" href="${pageContext.request.contextPath}/login/homepage">Homepage <span
                        class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    User management area
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/user/new">Insert new user</a>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/user/list">Show all the users</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown2" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    Booking management area
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown2">
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/booking/list">Show all the
                        bookings</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown3" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    Car management area
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/car/new">Insert new car</a>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/car/list">Show all the cars</a>
                </div>
            </li>
            <a class="nav-item nav-link" href="<c:url value="/logout" />"> Log out</a>
        </ul>
    </div>
</nav>

<div class="text-center">
    Hi
    <br/><br/>
</div>


</body>
</html>
