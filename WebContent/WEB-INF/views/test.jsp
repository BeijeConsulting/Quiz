<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Start your OnLine Quiz</title>
    <style>
    	#domanda-footer {
    	
    	}
    </style>
</head>
<body>

<h2>Quiz Scelto:</h2>

<br>
<br>
Totale domande caricate : ${ totDomande }
<br>
Tempo disponibile : ${ totDomande * 2 } minuti
<br>
<br>
<%-- Domande quiz --%>
	<div id="domanda-wrapper">
		<div id="testo">
		</div>
		<div id="risposte">
			<div id="risposte-radio">
			</div>
			<div id="risposte-check">
			</div>
		</div>
		<div id="domanda-footer">
			
		</div>
	</div>
	<button id="button-start"> START </button>
</body>
</html>