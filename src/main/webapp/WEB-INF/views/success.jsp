<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Login successful</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/4.1.1/css/bootstrap.min.css"/>
    <script src="${pageContext.request.contextPath}/webjars/jquery/3.6.0/jquery.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/4.1.1/css/bootstrap.min.css"/>
    <script src="${pageContext.request.contextPath}/webjars/bootstrap/4.1.1/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/popper.js/1.14.1/popper.js"></script>
</head>

<body>
<c:choose>
    <c:when test="${adminOk == true || carOk == true}">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand">Car Rental</a>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="${pageContext.request.contextPath}/log/adminHomepage?userId=${userId}">Homepage
                            <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            User management area
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item"
                               href="${pageContext.request.contextPath}/user/getNew?userId=${userId}">Insert new
                                user</a>
                            <a class="dropdown-item"
                               href="${pageContext.request.contextPath}/user/list?userId=${userId}">Show all the
                                users</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown2" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Booking management area
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown2">
                            <a class="dropdown-item"
                               href="${pageContext.request.contextPath}/booking/getNew?userId=${userId}">Make a new
                                reservation</a>
                            <a class="dropdown-item"
                               href="${pageContext.request.contextPath}/booking/list?userId=${userId}">Show all the
                                bookings</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown3" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Car management area
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item"
                               href="${pageContext.request.contextPath}/car/getNew?userId=${userId}">Insert new car</a>
                            <a class="dropdown-item"
                               href="${pageContext.request.contextPath}/car/list?userId=${userId}">Show all the cars</a>
                        </div>
                    </li>
                </ul>
            </div>
        </nav>
        <br/> <br/>
        ${success}
        <br/>
        <br/>
        Perform some actions with the navbar.
    </c:when>
    <c:when test="${userOk == true}">
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
                    <a class="nav-item nav-link"
                       href="${pageContext.request.contextPath}/booking/getNew?userId=${userId}">Make
                        a new
                        reservation</a>
                    <a class="nav-item nav-link"
                       href="${pageContext.request.contextPath}/booking/myBookings?userId=${userId}">Show
                        all my
                        reservations</a>
                </div>
            </div>
        </nav>
        <br/> <br/>
        ${success}
        <br/>
        <br/>
        Perform some actions with the navbar.
    </c:when>
    <c:otherwise>
        <br/> <br/>
        ${success} <a href="${pageContext.request.contextPath}/log/getLogin">Login</a>.
        <br/>
        <br/>

    </c:otherwise>
</c:choose>


</body>

</html>
