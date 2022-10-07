<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Booking Form</title>

</head>

<body>

<h2>Booking Form</h2>

<form:form method="POST" action="${pageContext.request.contextPath}/car/getAvailableCars" modelAttribute="booking">
  <form:input type="hidden" path="id" id="id"/>
  <table>
    <tr>
      <td><label for="startDate">Start Date: </label> </td>
      <td><form:input type="date" path="startDate" id="startDate"/></td>

    </tr>

    <tr>
      <td><label for="endDate">End Date: </label> </td>
      <td><form:input type="date" path="endDate" id="endDate"/></td>

    </tr>
    <tr>
      <input type="submit" value="View all the available cars"/>

    </tr>
  </table>
</form:form>
<br/>
<br/>
Go back to <a href="index.jsp">homepage</a>
</body>
</html>
