<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
	
* {
  box-sizing: border-box;
}

input[type=email], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  resize: vertical;
}

input[type=password], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  resize: vertical;
}

label {
  padding: 12px 12px 12px 0;
  display: inline-block;
}

input[type=submit] {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  float: right;
}

input[type=submit]:hover {
  background-color: #45a049;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
  display: table;
  width: 100%;
}

.col-25 {
  float: left;
  width: 25%;
  margin-top: 6px;
}

.col-75 {
  float: left;
  width: 75%;
  margin-top: 6px;
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}

/* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 600px) {
  .col-25, .col-75, input[type=submit] {
    width: 100%;
    margin-top: 0;
  }
}

#form_login {
   display: table-cell;
   text-align: center;
   vertical-align: middle;
}
</style>
<meta charset="ISO-8859-1">
<title>Quiz | Login</title>
</head>
<body>

	<h3>Login</h3>
	<div class="container">
		<form action="./login" method="post" id="form_login">
 			<div class="row">
	   			<div class="col-25">
	     				<label for="fname">Email</label>
	   			</div>
	   			<div class="col-75">
	     				<input type="email" id="email" name="email" placeholder="Email" required>
  		 		</div>
 			</div>
 			<div class="row">
	   			<div class="col-25">
	     			<label for="lname">Password</label>
	  	 		</div>
	   			<div class="col-75">
	     			<input type="password" id="password" name="password" placeholder="Password" required>
	   			</div>
 			</div>
 			<div class="row">
   				<input type="submit" value="Login">
 			</div>
 			<div class="row">
				Nuovo utente? <a href="./register">Registrati!</a>
			</div>
		</form>
	</div>

</body>
</html>