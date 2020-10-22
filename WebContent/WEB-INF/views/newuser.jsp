<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New User</title>
<link rel="stylesheet" href="<c:url value="/resources/static/reg.css" />">
</head>
<body>

<div align="center"><h1>CREATE ACCOUNT</h1></div>
<div class="main">
	<form action="./newuser" method="POST">
	<table>
	<tr>
	<td>NICKNAME: <input type="text" value="" name="nickname" placeholder="redmario"/><br><br></td>
	<td>EMAIL: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="email" value="" name="email" placeholder="mariorossi@gmail.com"/><br><br></td>
	<td>PASSWORD<input type="password" value="" name="password"/><br><br></td>
	</tr>
	<tr>
	<td><button type="submit"><span>SUBMIT</span></button></td>
	<td><button type="reset"><span>RESET</span></button></td>
	</tr>
	</table>
	</form> <br>
	<div align ="right"><a href="./">Back</a></div>
	</div>
</body>
</html>