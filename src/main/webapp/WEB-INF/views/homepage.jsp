<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Homepage</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/4.1.1/css/bootstrap.min.css"/>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Car Rental</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
            aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
            <a class="nav-item nav-link active" href="${pageContext.request.contextPath}/booking/homepage?userId=${userId}">Homepage
                <span class="sr-only">(current)</span></a>
            <a class="nav-item nav-link" href="${pageContext.request.contextPath}/booking/getNew?userId=${userId}">Make a new
                reservation</a>
            <a class="nav-item nav-link" href="${pageContext.request.contextPath}/booking/myBookings?userId=${userId}">Show all my
                reservations</a>
        </div>
    </div>
</nav>
<div class="text-center">
    ${msg}
    <br/><br/>

    <c:choose>
        <c:when test="${adminOk == true}">
            <form action="${pageContext.request.contextPath}/user/new" method="get">
                <input type="submit" value="Insert new user">
            </form>
            <form action="${pageContext.request.contextPath}/user/list" method="get">
                <input type="submit" value="Show all users">
            </form>
            <form action="${pageContext.request.contextPath}/car/new" method="get">
                <input type="submit" value="Insert new car">
            </form>
            <form action="${pageContext.request.contextPath}/car/list" method="get">
                <input type="submit" value="Show all cars">
            </form>
            <form action="${pageContext.request.contextPath}/booking/getNew" method="get">
                <input type="hidden" name="userId" value="${user.id}"/>
                <input type="submit" value="Insert new booking">
            </form>
            <form action="${pageContext.request.contextPath}/booking/list" method="get">
                <input type="submit" value="Show all bookings">
            </form>
        </c:when>
        <c:when test="${userOk == true}">
            Make a choice with the navbar. Enjoy!
        </c:when>
        <c:otherwise>
            Error.
        </c:otherwise>
    </c:choose>
</div>


</body>
</html>
