<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/4.1.1/css/bootstrap.min.css" />
</head>
<body>
${msg}
            <form:form method="post" action="login" modelAttribute="user">
                   Username <form:input type="text" id="username" path="username"/> <br/>
                    Password <form:input type="password" id="password" path="password"/>
                <br/>
                <form:button type="submit">Login</form:button>
            </form:form>

</body>
</html>

