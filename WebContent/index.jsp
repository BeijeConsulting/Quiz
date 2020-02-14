<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
		<title>Domande e risposte</title>
	</head>
	<body>
		<!-- METTI IN WebContent LE TUE JSP (ignora le cose in /WEB-INF/views per il momento) -->
		<jsp:useBean id="domandeBean" class="it.beije.quiz.Utils" scope="session" />
		<form action="risposte.jsp" method="POST"> <!--  Dove per domande si intende Domande.java, una classe che conterrà il servlet che utilizzerà i metodi di Utils per estrapolare i dati da comunicare alla pagina risposte.jsp -->
		<p>Domanda</p>
		ID:<input type="text" name="param_Id"><br>
		Book:<input type="text" name="param_Book"><br>
		Chapter:<input type="text" name="param_Chapter"><br>
		Question:<input type="text" name="param_Question"><br>
		Testo:<input type="text" name="param_Testo"><br>
		Type (answer):<input type="text" name="param_Type"><br>
		Risposte:<input type="text" name="param_Risposte"><br>
		Risposta esatta:<input type="text" name="param_Rispostaesatta"><br>
		Spiegazione:<input type="text" name="param_Spiegazione"><br>
		
		</form>
	</body>
</html>