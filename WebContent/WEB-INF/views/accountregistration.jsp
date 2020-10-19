<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account Registration</title>
</head>
<body>
		<h3>Please fill in the form suggested below</h3>
		<form action="./accountregistration" method="post">
			NAME&nbsp;<input type="text" name="name" value="" placeholder="name"/><br/>
			SURNAME&nbsp;<input type="text" name="surname" value="" placeholder="surname"/><br/>
			EMAIL&nbsp;<input type="email" name="email" value="" placeholder="user@domain.it"/><br/>
 			PASSWORD&nbsp;<input type="password" name="password" value=""/><br>
			<input type="submit" value="SUBMIT"/>
		</form>
		<p>${error}</p>
</body>
</html>