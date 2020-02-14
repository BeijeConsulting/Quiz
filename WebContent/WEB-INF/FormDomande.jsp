<%@page import="it.beije.quiz.model.Domanda" import="java.util.Arrays"
import="java.util.List" import="it.beije.quiz.model.Risposta" import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserisci nuova domanda</title>
</head>
<body>
<%  //<jsp:useBean id="domanda" class="it.beije.quiz.model.Domanda" scope="session" /> %>
Inserisci le informazioni della nuova domanda.
	<form action="auth.jsp" method="POST">
	<label for="id">ID domanda:</label> <input type="text" name="id">
	<label for="book">Libro:</label> <input type="text" name="book">
	<label for="chapter">Capitolo: </label><input type="text" name="chapter">
	<label for="question">Numero domanda: </label><input type="text" name="question">
	<label for="testo">Testo:</label> <input type="text" name="testo">
	
	<label for="risposte">Risposte(se più risposte separare con "-"):</label>
	<textarea id="idrisposte" rows="6" cols="50" name="risposte"> </textarea> 
	
	<label for="answerType">Tipo di risposte:</label> <input type="text" name="book">
	<input type="radio" name="answerType" value="radio"><label for="radio">Radio</label>
	<input type="checkbox" name="answerType" value="checkbox"><label for="checkbox">Checkbox</label>
	
	<label for="rispostaEsatta">Risposta corretta:</label> <input type="text" name="rispostaEsatta">
	<label for="spiegazione">Spiegazione:</label> 
	<textarea id="idspiegazione" rows="8" cols="40" name="spiegazione"> </textarea> 
	<input type="submit" value="Salva">
    </form>
<%  
Domanda domanda = (Domanda) request.getSession().getAttribute("domanda");
if (domanda == null) {
	
	String[] risposte= request.getParameter("risposte").split("-");
	List<Risposta> listaRisposte= new ArrayList<>();
	for(int i=0;i<risposte.length;i++)
	{
		Risposta r = new Risposta();		
		r.setText(risposte[i]);
		r.setValue("A"+i);
		listaRisposte.add(r);
	}
	
	
	domanda = new Domanda( Integer.parseInt(request.getParameter("id")), request.getParameter("book"), 
						  Integer.parseInt(request.getParameter("chapter")),
						  Integer.parseInt(request.getParameter("question")), request.getParameter("testo"), 
			              request.getParameter("answerType"), listaRisposte, request.getParameter("rispostaEsatta"),
			              request.getParameter("spiegazione"));
						  request.getSession().setAttribute("domanda", domanda);
}

domanda.toString();
%>





</body>
</html>