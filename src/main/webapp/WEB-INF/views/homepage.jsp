<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Homepage</title>
</head>
<body>
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
            <input type="submit" value="Insert new booking">
        </form>
        <form action="${pageContext.request.contextPath}/booking/list" method="get">
            <input type="submit" value="Show all bookings">
        </form>
    </c:when>
    <c:when test="${userOk == true}">
        <form action="${pageContext.request.contextPath}/booking/new" method="get">
            <input type="submit" value="Make a new reservation">
        </form>
        <form action="${pageContext.request.contextPath}/booking/myBookings" method="get">
            <input type="submit" value="Show all your bookings">
        </form>
    </c:when>
    <c:otherwise>
        Error.
    </c:otherwise>
</c:choose>


</body>
</html>
