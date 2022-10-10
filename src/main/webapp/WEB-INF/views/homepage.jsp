<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Homepage</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.1.1/css/bootstrap.css" />
</head>
<body>
<nav class="nav">
    <a class="nav-link active" aria-current="page" href="#">Active</a>
    <a class="nav-link" href="#">Link</a>
    <a class="nav-link" href="#">Link</a>
    <a class="nav-link disabled">Disabled</a>
</nav>
${msg}
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
        <form action="${pageContext.request.contextPath}/booking/new" method="get">
            <input type="hidden" name="userId" value="${user.id}" />
            <input type="submit" value="Insert new booking">
        </form>
        <form action="${pageContext.request.contextPath}/booking/list" method="get">
            <input type="submit" value="Show all bookings">
        </form>
    </c:when>
    <c:when test="${userOk == true}">
        <form action="${pageContext.request.contextPath}/booking/new" method="get">
            <input type="hidden" name="userId" value="${user.id}" />
            <input type="submit" value="Make a new reservation" />
        </form>
        <form action="${pageContext.request.contextPath}/booking/myBookings" method="get">
            <input type="hidden" name="userId" value="${user.id}" />
            <input type="submit" value="Show all your bookings" />
        </form>
    </c:when>
    <c:otherwise>
        Error.
    </c:otherwise>
</c:choose>


</body>
</html>
