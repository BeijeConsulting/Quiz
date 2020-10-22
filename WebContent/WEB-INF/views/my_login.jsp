<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGIN</title>
</head>
	<body>
		<h2><em>OCA test website</em></h2>
	 	
	 	<h4 style="color:rgb(0, 255, 0);"> ${registrato} </h4>
		<h4 style="color:rgb(255, 0, 0);"> ${errore} </h4>
	 
		<br><h3>Inserisci le tue credenziali</h3>
		<form action="./passaggio" method="post">
			EMAIL&nbsp;<input type="email" name="email" value="" placeholder="user@domain.it"/><br/>
 			PASSWORD&nbsp;<input type="password" name="password" value=""/><br>
			<input type="submit" value="INVIO"/>
		</form>
		<br>
		<h3>Non sei ancora dei nostri? <a href="./register">Registrati!</a><br></h3>
	</body>
</html>