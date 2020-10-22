<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Quiz Home Page</title>
<link rel="stylesheet" href="<c:url value="/resources/static/view.css" />">
</head>
<body>
<div align="center"><h1>WELCOME</h1></div>
<div class="here">
<form action="./log">
<button type="submit" ><span>LOGIN</span></button><br>
</form><br>
New User? <a href="./newuser">Register here</a><br><br>
</div>

</body>
</html>