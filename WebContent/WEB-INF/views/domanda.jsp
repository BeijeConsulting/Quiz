<%@page import="it.beije.quiz.model.Risposta"%>
<%@page import="java.time.Duration"%>
<%@page import="java.time.LocalTime"%>
<%@page import="it.beije.quiz.controller.Utils"%>
<%@page import="it.beije.quiz.model.Domanda"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>QUIZ</title>
</head>
<body>

<div id ="timer" style="width: 98%; text-align:right;"></div>

<script type="text/javascript">
var ore = ${ ore };
var minuti = ${ minuti };
var secondi = ${ secondi };

function formattaTimer(hours,minutes,seconds) {
	var t = "0" + hours;
	t = t + ":" + ( minutes < 10 ? "0" : "") + minutes;
	t = t + ":" + ( seconds < 10 ? "0" : "") + seconds;
	return t;
}

function myTimer() {
	document.getElementById("timer").innerHTML = formattaTimer(ore, minuti, secondi--);
  if (secondi < 0) {
	  if(minuti > 0) {
		  secondi = 59;
		  minuti--;
	  }else if (ore > 0) {
		  secondi = 59;
		  minuti = 59;
		  ore--;
	  } else {
    		clearInterval(timer);
    		//document.getElementById("timer").innerHTML = 'TEMPO SCADUTO';
    		location.href = "/quiz/risposta";
	  }
  }
  
}

myTimer();

var timer = setInterval(myTimer, 1000);

</script>

DOMANDA ${ index + 1 } di ${ totDomande }<br>
<br>
${testoDomanda }

<form action = "risposta" method = "POST">
  <input type="hidden" name="index" value="${ index}">
  
  <%-- ciclo sull'array di risposte e inserisco i valori di input type, name e value legati alla domanda --%>
  <%-- for(Risposta r : scelte) { %><input type = "${ answerType}" name="<%=r.getValue() %>" value = "<%=r.getValue() %>"
  <%-- se la risposta utente non è null metto checked le risposte contenute in risposta utente %>
  <%if(d.getRispostaUtente() != null)
	  {if(d.getRispostaUtente().contains(r.getValue())){ %> checked<% }} %> /><%=r.getText() %><br> <% } --%>
  <br><input type="submit" value="Invio">
</form>
<br>
<br>
<%-- if (index > 0) { -%><a href="domanda.jsp?index=<%= index - 1 %>">&lt;&lt;Prec.</a><% } %>
&nbsp;&nbsp;&nbsp;&nbsp;
<% if (index != tot) { %><a href="domanda.jsp?index=<%= index + 1 %>">Succ.&gt;&gt;</a><% } --%>

</body>
</html>