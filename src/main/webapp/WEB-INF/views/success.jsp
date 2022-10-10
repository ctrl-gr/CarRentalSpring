    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Login successful</title>
</head>
<body>
${success}
<br/>
<br/>
Perform some actions. <a href="./list">Make a new reservation</a> or
<form action="${pageContext.request.contextPath}/booking/myBookings" method="get" >
    <input type="hidden" name="userId" value="${user.id}" />
    <input type="submit" value="Show all your bookings">
</form>

</body>

</html>
