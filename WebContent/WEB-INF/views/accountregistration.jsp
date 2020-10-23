<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Quiz Application</title>

<link rel="stylesheet" href="<c:url value="/assets/css/accountregistration.css" />"/>

</head>
<body>
		<div id="main-div">

        	<div id="reg-box">

           		<h1>Create account</h1>

            	<form method="POST" action="./accountregistration">

                	<label>Name</label><br>
                	<input class="input-box" type="text" name="name" required="required"/><br>

                	<label>Surname</label><br>
                	<input class="input-box" type="text" name="surname" required="required"/><br>

                	<label>Email</label><br>
                	<input class="input-box" type="text" name="email" required="required"/><br>

                	<label>Password</label><br>
                	<input class="input-box" type="password" name="password" required="required"/><br>

                	<input class="submit-button" type="submit" value="REGISTER" />

            	</form>

            	<p>${error}</p>

            	<a class="link" href="./login">Back</a>
            	
        </div>

    </div>
    
</body>
</html>