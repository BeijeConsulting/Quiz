<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="it.beije.quiz.model.Utente"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Storico Esiti</title>
</head>
<body>
<h3>Storico Esiti di <%=((Utente)(session.getAttribute("utente"))).getNome()%> <%=((Utente)(session.getAttribute("utente"))).getCognome()%></h3>
<c:forEach var="s" items="${storico}">
<%-- inserire tabella o boh per i vari valori dello storico --%>
</c:forEach>
</body>
</html>