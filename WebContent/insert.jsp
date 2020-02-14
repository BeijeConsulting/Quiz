<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserisci domande</title>
<style>
body {
	font-size: medium;
}

.divInsertQuestion {
	border: 2px solid #000;
	padding: 10px;
	width: 770px;
	border-radius: 6px;
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
}

textarea {
	max-width: 600px;
	width: 100%;
	border-radius: 5px;
	border: 1px solid #000;
	height: 150px;
	padding: 5px;
}

.number {
	width: 50px;
}

.valignTop {
	vertical-align: top;
}

.buttom {
	width: 200px;
	background: DodgerBlue;
	color: #fff;
	border: 0px solid;
}

.risposte {
	width: 200px;
}

.buttom:hover {
	width: 200px;
	background: blue;
	color: #fff;
	border: 0px solid;
	cursor: pointer;
}
</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script>
var c = 2;
function createNewResponse() {
   	$('.risposte').append('<input style="margin-top: 5px;" type="text" name="risposta' + c + '" placeholder="X - testo della risposta" />');
   	c++;
}
</script>
</head>
<body>
<h2>Inserimento domande:</h2>

<div class="divInsertQuestion">
	<form action="../insertDomanda" method="post">
		<table cellspacing="10px">
			<tr>
				<td>Numero domanda:&nbsp;</td><td><input class="number" type="number" placeholder="Es: 3" name="numDomanda" min="1" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Capitolo:&nbsp;<input class="number" type="number" placeholder="Es: 3" name="numDomanda" min="1"/></td>
			</tr>
			<tr>
				<td>Book:&nbsp;</td><td><input type="text" name="bookName" placeholder="nome del libro" /></td>
			</tr>
			<tr>
				<td class="valignTop">Testo:&nbsp;</td><td><textarea name="testoDomanda" placeholder="testo della domanda"></textarea></td>
			</tr>
			<tr>
				<td class="valignTop">Risposte:<br><br><button type="button" onclick="createNewResponse()">+</button>&nbsp;</td><td class="risposte"><input type="text" placeholder="A - testo della risposta" name="risposta1" /></td>
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


