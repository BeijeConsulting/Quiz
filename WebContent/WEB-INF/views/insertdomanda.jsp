<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.beije.quiz.Utils" %>
<%@ page import="it.beije.quiz.model.Libro" %>
<%@ page import="java.util.List" %>
 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserisci domande</title>
<style>
body {
}

.divInsertQuestion {
	border: 2px solid #000;
	padding: 10px;
	max-width: 770px;
	width: 90%;
	border-radius: 6px;
	margin: auto;
	background: #ccc;
	box-shadow: 5px 5px 10px #888;
}

label {
	width: 200px;
}

input {
	width: 600px;
	border-radius: 5px;
	border: 1px solid #000;
	height: 30px;
	padding: 5px;
	border: 1px solid #000;
}

textarea {
	max-width: 600px;
	width: 100%;
	border-radius: 5px;
	border: 1px solid #000;
	height: 100px;
	padding: 5px;
	border: 1px solid #000;
}

.number {
	width: 50px;
}

.valignTop {
	vertical-align: top;
}

.buttom {
	width: 200px;
	background: grey;
	color: #fff;
	border: 0px solid;
}

.risposte {
	width: 200px;
}

.buttom:hover {
	width: 200px;
	background: DodgerBlue;
	color: #fff;
	border: 0px solid;
	cursor: pointer;
}

h2 {
	text-align:center;
}

</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script>
var c = 2;
function createNewResponse() {
   	$('.risposte').append('<div style="margin-top: 5px;"><div style="float: left;"><input type="text" maxlength="5" name="valueRisposta' + c + '" class="number" placeholder="A" /></div><div><input style="width: 538px;" type="text" placeholder="testo della risposta" name="risposta' + c + '" /></div></div>');
   	c++;
}
</script>
</head>
<body>

<% List<Libro> listaLibri = Utils.getLibri(); %>

<div class="divInsertQuestion">
<h2>INSERIMENTO DOMANDE</h2>
	<form action="CreateDomanda" method="post">
		<table >
			<tr>
				<td>Numero domanda:&nbsp;</td><td><input class="number" type="number" placeholder="Es: 3" name="numDomanda" min="1" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Capitolo:&nbsp;<input type="text" placeholder="Es: 3" name="numCapitolo" min="1"/></td>
			</tr>
			<tr>
				<td>Book:&nbsp;</td><td><select name="bookName" style="border-radius: 6px; padding: 5px; width: 600px; padding: 5px; border: 1px solid #000;">
										 <% for(Libro l : listaLibri){
											 out.print("<option value=\"" + l.getTitle() + "\">" + l.getTitle() + "</option>"); 
										 }
										 %>
										 
										  
										</select></td>
			</tr>
			<tr>
				<td class="valignTop">Testo:&nbsp;</td><td><textarea name="testoDomanda" placeholder="testo della domanda"></textarea></td>
			</tr>
			<tr>
				<td>Tipo domanda:</td><td><label style="width: 20px; position: relative; top: -10px;" for="check">Multiple choice</label><input style="width: 20px;" type="radio" name="typeQuestion" value="checkbox" style="height: 20px;" checked="checked" />&nbsp;&nbsp;&nbsp;<label style="width: 50px; position: relative; top: -10px;" for="radio">Single choice</label><input style="width: 20px;" type="radio" name="typeQuestion" value="radio" style="height: 20px;" /></td>
			</tr>
			<tr>
				<td class="valignTop">Risposte:&nbsp;<button type="button" onclick="createNewResponse()">+</button>&nbsp;</td><td class="risposte"><div style="float: left;"><input type="text" maxlength="5" class="number" name="valueRisposta1" placeholder="A" /></div><div><input style="width: 538px;" type="text" placeholder="testo della risposta" name="risposta1" /></div></td>
			</tr>
			<tr>
				<td>Risposte corrette:&nbsp;</td><td><input type="text" name="risposteEsatte" placeholder="ABE" /></td>
			</tr>
			<tr>
				<td class="valignTop">Spiegazione:&nbsp;</td><td><textarea name="spiegazione" placeholder="testo della spiegazione"></textarea>
			</tr>
		</table>
		<div style="margin: auto; text-align: center;">
			<input class="buttom" type="submit" name="submitDomanda" value="Invia Domanda" />
			<input class="buttom" type="reset" name="reset" value="Reset campi domanda" />
		</div>
	</form>
</div>
<br><br>
</body>
</html>


