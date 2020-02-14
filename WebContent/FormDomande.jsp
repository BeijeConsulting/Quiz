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

	Inserisci le informazioni della nuova domanda.<br><br>
	<form action="FormDomandeServ" method="POST">
		<label for="id">ID domanda:</label> <input type="number" min=0 name="id"><br><br>
		<label for="book">Libro:</label> <input type="text" name="book"><br><br>
		<label for="chapter">Capitolo: </label><input type="number" min=1 name="chapter"><br><br>
		<label for="question">Numero domanda: </label><input type="number" min=1 name="question"><br><br>
		<label for="testo">Testo:</label>
		<textarea id="idtesto" rows="6" cols="50" name="testo"> </textarea> <br><br>
		
		<label for="risposte">Risposte(se più risposte separare con "-"):</label><br><br>
		<textarea id="idrisposte" rows="6" cols="50" name="risposte"> </textarea> <br><br>
		
		<label for="answerType">Tipo di risposte: </label> 
		<input type="radio" name="answerType" value="radio"><label for="radio">Radio</label>
		<input type="checkbox" name="answerType" value="checkbox"><label for="checkbox">Checkbox</label><br>
		
		<label for="rispostaEsatta">Risposta corretta:</label> <input type="text" name="rispostaEsatta"><br><br>
		<label for="spiegazione">Spiegazione:</label> <br><br>
		<textarea id="idspiegazione" rows="8" cols="40" name="spiegazione"> </textarea> <br>
		<input type="submit" value="Salva">
    </form>
    
 <%  
	/** Domanda domanda = (Domanda) request.getSession().getAttribute("domanda");
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
	
	domanda.toString(); **/
 %>





</body>
</html>