<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Quiz Application</title>

<link rel="stylesheet" href="<c:url value="/assets/css/login.css" />"/>


</head>
<body>

	<div id="main-div">
	
		<div id="login-box">

            <h1>Quiz Application</h1>
            
		 	<form method="POST" action="./login">
		 	
		 	
		 		<label>Email</label><br>
                <input class="input-box" type="email" name="email" required="required"/><br>

                <label>Password</label><br>
                <input class="input-box" type="password" name="password" required="required"/><br>

                <input class="submit-button" type="submit" value="LOGIN" />

            </form>
		
			<p>${error}</p>
		
	    	<a class="link" href="./accountregistration">Create new account</a>
		
		 </div>
	</div>
		
</body>
</html>