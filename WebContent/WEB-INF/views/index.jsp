<%@page import="java.time.Duration"%>
<%@page import="it.beije.quiz.utils.Utils"%>
<%@page import="it.beije.quiz.model.Domanda"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inizia il tuo Quiz OnLine</title>
</head>
<%
List<Domanda> domande = Utils.readFileDomande("C:\\temp\\domande.xml");
session.putValue("elencoDomande", domande);

int tot = domande.size();
Duration duration = Duration.ofMinutes(tot * 2);
session.putValue("duration", duration);

%>
<body>
Questa è la pagina di ingresso al tuo Quiz Online<br>
<br>
Totale domande caricate : <%= tot %><br>
Tempo disponibile : <%= tot * 2 %> minuti<br>
<br>
<input type="button" value="START" onclick="location.href='./StartQuiz'">

</body>
</html>