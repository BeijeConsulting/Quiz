<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form Contatto</title>
</head>
<body>



	<form action="verifica.jsp" method="POST">
		NOME: <input type="text" name="nome"><br> <br>
		COGNOME: <input type="text" name="cognome"><br> <br>
		TELEFONO: <input type="text" name="telefono"><br> <br>
		EMAIL: <input type="text" name="email"><br> <br> <input
			type="submit" value="INVIA">
	</form>

</body>
</html>