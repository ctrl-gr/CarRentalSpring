<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
  <title>User Registration Form</title>
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
         href="${pageContext.request.contextPath}/booking/homepage?userId=${userId}">Homepage
        <span class="sr-only">(current)</span></a>
      <a class="nav-item nav-link" href="${pageContext.request.contextPath}/booking/getNew?userId=${userId}">Make
        a new
        reservation</a>
      <a class="nav-item nav-link" href="${pageContext.request.contextPath}/booking/myBookings?userId=${userId}">Show
        all my
        reservations</a>
    </div>
  </div>
</nav>


<form:form method="POST" modelAttribute="user" action="./new">
  <form:input type="hidden" path="id" id="id"/>
  <table class="table table-dark">
    <tr>
      <td><label for="firstName">First name: </label> </td>
      <td><form:input path="firstName" id="firstName"/></td>

    </tr>

    <tr>
      <td><label for="lastName">Last name: </label> </td>
      <td><form:input path="lastName" id="lastName"/></td>

    </tr>

    <tr>
      <td><label for="birthDate">Birth Date: </label> </td>
      <td><form:input type="date" path="birthDate" id="birthDate"/></td>
    </tr>

    <tr>
      <td><label for="username">Username: </label> </td>
      <td><form:input path="username" id="username"/></td>

    </tr>
    <tr>
      <td><label for="password">Password: </label> </td>
      <td><form:input path="password" id="password"/></td>

    </tr>


    <tr>


    </tr>
  </table>
</form:form>
<input type="submit" value="Register"/>
<br/>
<br/>
</body>
</html>
