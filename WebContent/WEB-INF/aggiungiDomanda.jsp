<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	

		<label for="libro">Libro:</label> 
		<select id="libro" name="param_libro" form="formDomande">
			<option  value="OCA Java Se 8 Programmer I Certification Guide">OCA Java Se 8 Programmer I Certification Guide</option>
			<option value="OCA Oracle Certified Associate Java SE 8 [2014]">OCA Oracle Certified Associate Java SE 8 [2014]</option>
		</select>
		<br>
		 <form action="AggiungiDomandaServlet" method="POST" id="formDomande">
		 Id:  <input type="text" name="param_id"><br><br>
		Capitolo: <input type="text" name="param_capitolo"><br><br>
		Numero domanda:  <input type="text" name="param_nDomanda"><br><br>
		Testo: 
		<textarea name="param_testo" form="formDomande"></textarea><br><br>
		
		Inserisci le risposte divise da , <br>
		 Risposte:<textarea name="param_risposte" form="formDomande"></textarea><br><br>
		 
		 Se sono multiple dividile con , <br>
		 Tipo di risposta:  
		  <input type="radio" id="checkbox" name="param_type" value="checkbox">
 			 <label for="checkbox">Multipla</label>
  		<input type="radio" id="radio" name="param_type" value="radio">
 			 <label for="radio">Singola</label><br><br>
 			 
		 RisposteEsatte:<input type="text" name="param_risposteEsatte"><br><br> 
		 Spiegazione:<input type="text" name="param_spiegazione"><br><br> 
		
		 <input type="submit" value="Salva">
	</form>

</body>
</html>