<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>History</title>
</head>
<body>
	
	<h4>${user.name} ecco lo storico dei quiz che hai completato:</h4>

	<table>
		<tr>
		    <th>ESITO</th>
		    <th>NOME</th>
		    <th>RISULTATO</th>
	 	</tr>
	   	<c:forEach var = "esame" items="${esami}">
	   		<tr>
	   			<th><c:out value = "${esame.nomeQuiz}"/></th>
		   		<th><c:out value = "${esame.passed eq false ? 'Bocciato': 'Promosso'}"/></th>

				<th><a href="quiz_review/${esame.id}">Riguarda risposte</a></th> 
				<br>
		    </tr>
		</c:forEach>
	</table>
	
</body>
</html>