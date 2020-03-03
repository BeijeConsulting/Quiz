<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.beije.quiz.Utils" %>
<%@ page import="it.beije.quiz.model.Libro" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<style>
body {
	background-color: #b8adad;
}

.container {
	display: block;
	position: relative;
	padding-left: 35px;
	margin-bottom: 12px;
	cursor: pointer;
	font-size: 22px;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

.container input {
	position: absolute;
	opacity: 0;
	cursor: pointer;
	height: 0;
	width: 0;
}

.checkmark {
	position: absolute;
	top: 0;
	left: 0;
	height: 25px;
	width: 25px;
	background-color: #eee;
}

.container:hover input ~ .checkmark {
	background-color: #ccc;
}

.container input:checked ~ .checkmark {
	background-color: #2196F3;
}

.checkmark:after {
	content: "";
	position: absolute;
	display: none;
}

.container input:checked ~ .checkmark:after {
	display: block;
}

.container .checkmark:after {
	left: 9px;
	top: 5px;
	width: 5px;
	height: 10px;
	border: solid white;
	border-width: 0 3px 3px 0;
	-webkit-transform: rotate(45deg);
	-ms-transform: rotate(45deg);
	transform: rotate(45deg);
}
</style>
<body>
	<div style="padding: 10px;">
	Questa è la pagina di ingresso al tuo Quiz Online
	<br>
	<br> Seleziona da quale libro prendere le domande:
	<br>
	<br>
	<form action="./confermaselezione" method="POST">
		<%
		List<Libro> libri = Utils.getLibri();
		int i = 1;
		for(Libro l : libri) {
			out.println("<label class=\"container\"><input type=\"checkbox\" name=\"libro" + i +
					"\" value=\"" + l.getDir() + "\">" + l.getTitle() + "<span class=\"checkmark\"></span></label>");
			i++;
		}
		%>
		
		
		
		 Totale domande caricate : ${ totDomande }<br> Tempo disponibile
		: ${ totDomande * 2 } minuti<br> <br>


		<button type="submit" class="btn btn-info">CONFERMA</button>
	</form>
	</div>

</body>
</html>