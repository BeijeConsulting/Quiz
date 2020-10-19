<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
	.msg {
		color: red;
		font-size: 20pt;
		margin-top: 10px;
	}
</style>

	<meta charset="ISO-8859-1">	
	<title>Sign Up</title>
</head>
<body>

	<h1 style="text-align:center;"><em>Sign up</em></h1>
	<h3>Enter your credentials</h3>
	
	<form action="./signUp" method="POST" onsubmit="return checkUp(this)">
	  <label for="name">Name:</label>
	  <input type="text" name="name" value=""><br>
	  <label for="surname">Surname:</label>
	  <input type="text" name="surname" value=""><br>
	  <label for="email">E-mail:</label>
	  <input type="email" name="email" value=""><br>
	  <label for="password">Password:</label>
	  <input type="password" name="password" value=""><br>
	  <input name="insert" type="submit" value="SIGN UP"/>
	  
	</form>	

</body>

<script>

function checkUp(formEl){
	if (formEl.nickname.value && formEl.password.value) return true;
	else {
		document.getElementById('msgLogin').innerHTML="CREDENZIALI INCOMPLETE";
		return false;	
	}
}

</script>

</html>