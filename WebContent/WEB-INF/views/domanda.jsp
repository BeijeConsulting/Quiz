<%@page import="it.beije.quiz.utils.Utils"%>
<%@page import="it.beije.quiz.model.Domanda"%>
<%@page import="java.time.Duration"%>
<%@page import="java.time.LocalTime"%>
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
	<%
		List<Domanda> domande = (List) session.getValue("elencoDomande");
		String i = (String) request.getParameter("index");
		int index = 0;
		if (i != null) {
			index = Integer.parseInt(i);
		}

		LocalTime time = (LocalTime) session.getValue("time");
		LocalTime now = LocalTime.now();
		Duration diff = Duration.between(time, now);
		int tot = domande.size();
		int secondi = tot * 2 * 60;
		long hours = (secondi - diff.getSeconds()) / 3600;
		long minutes = (secondi - diff.getSeconds()) / 60 - hours * 60;
		long seconds = (secondi - diff.getSeconds()) - hours * 3600 - minutes * 60;
	%>

	<div id="timer" style="width: 98%; text-align: right;"></div>

	<script type="text/javascript">
		var ore =
	<%=hours%>
		;
		var minuti =
	<%=minutes%>
		;
		var secondi =
	<%=seconds%>
		;

		function formattaTimer(hours, minutes, seconds) {
			var t = "0" + hours;
			t = t + ":" + (minutes < 10 ? "0" : "") + minutes;
			t = t + ":" + (seconds < 10 ? "0" : "") + seconds;
			return t;
		}

		function myTimer() {
			document.getElementById("timer").innerHTML = formattaTimer(ore,
					minuti, secondi--);
			if (secondi < 0) {
				if (minuti > 0) {
					secondi = 59;
					minuti--;
				} else if (ore > 0) {
					secondi = 59;
					minuti = 59;
					ore--;
				} else {
					clearInterval(timer);
					document.getElementById("timer").innerHTML = 'TEMPO SCADUTO';
				}
			}

		}

		myTimer();

		var timer = setInterval(myTimer, 1000);
	</script>

	<%
		if (index < tot) {
			Domanda d = domande.get(index);
			String risposta = d.getRispostaUtente();
			if (risposta == null)
				risposta = "";
	%>

	<%--= "Book " + d.getBook() + "Chapter " + d.getChapter() + " domanda " + d.getQuestion() --%>
	DOMANDA
	<%=index + 1%>
	di
	<%=tot%><br>
	<br>
	<p>
		<%=Utils.formattaTesto(d.getTesto())%>
	</p>
	<form action="risposta" method="POST">
		Risposta: <input type="text" name="rispostaUtente"
			value="<%=risposta%>"> <input type="hidden" name="index"
			value="<%=index%>"> &nbsp;&nbsp; <input type="submit"
			value="Submit" />
	</form>

	<%
		} else {
	%>
	DOMANDE TERMINATE
	<br>
	<br>
	<a href="risposta">VEDI LE RISPOSTE</a>
	<%
		}
	%>
	<br>
	<br>
	<%
		if (index > 0) {
	%><a href="domanda.jsp?index=<%=index - 1%>">&lt;&lt;Prec.</a>
	<%
		}
	%>
	&nbsp;&nbsp;&nbsp;&nbsp;
	<%
		if (index != tot) {
	%><a href="domanda.jsp?index=<%=index + 1%>">Succ.&gt;&gt;</a>
	<% } %>

</body>
</html>