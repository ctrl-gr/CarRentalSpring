<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>User Registration Form</title>

</head>

<body>

<h2>Registration Form</h2>

<form:form method="POST" modelAttribute="car" action="new">
  <form:input type="hidden" path="id" id="id"/>
  <table>
    <tr>
      <td><label for="licensePlate">License Plate: </label> </td>
      <td><form:input path="licensePlate" id="licensePlate"/></td>

    </tr>

    <tr>
      <td><label for="manufacturer">Manufacturer: </label> </td>
      <td><form:input path="manufacturer" id="manufacturer"/></td>

    </tr>

    <tr>
      <td><label for="model">Model: </label> </td>
      <td><form:input path="model" id="model"/></td>
    </tr>

    <tr>
      <td><label for="type">Type: </label> </td>
      <td><form:input path="type" id="type"/></td>

    </tr>
    <tr>
      <td><label for="seats">Seats: </label> </td>
      <td><form:input path="seats" id="seats"/></td>

    </tr>


    <tr>
      <input type="submit" value="Register"/>

    </tr>
  </table>
</form:form>
<br/>
<br/>
Go back to <a href="booking/list">List of All Bookings</a>
</body>
</html>
