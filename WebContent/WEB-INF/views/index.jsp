<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inizia il tuo Quiz OnLine</title>
</head>
<body>
<script>

let arrayDomande=[];
let indice=0;
function getDomande() {
	let dirLibro = document.getElementById("dirLibro").value;
	var risp=" ";
	
	let numDom=document.getElementById("numDom").value;

	fetch('http://localhost:8080/Quiz/domande?dirLibro='+dirLibro)
	  .then(response => response.json())
	  .then(domande => {
		arrayDomande=domande;
		console.log(dirLibro);
		  document.getElementById("numDom").innerHTML=domande.length;
		
	  document.getElementById("domandelibro").innerHTML="<h4>"+domande[0].id+'</h4><div id="testo">'+domande[0].testo+'</div><br><input type="button" value="next" onclick="next()">';

	  })
	  .catch(error => console.log('errore'));
	 } 
	 

function back(){
	if(indice !=0)
	indice--;
	
	  document.getElementById("domandelibro").innerHTML="<h4>"+arrayDomande[indice].id+"</h4>"+arrayDomande[indice].testo+'<br><input type="button" value="back" onclick="back()"><input type="button" value="next" onclick="next()">';
}
function next(){
	if(indice<arrayDomande.length)
	indice++;
	  document.getElementById("domandelibro").innerHTML="<h4>"+arrayDomande[indice].id+"</h4>"+arrayDomande[indice].testo+'<br><input type="button" value="back" onclick="back()"><input type="button" value="next" onclick="next()">';	
	
}	 
</script>
	
		LIBRO: <input id="dirLibro" type="text" name="dirLibro"><br>
		<input type="button" value="START QUIZ" onclick="getDomande()">
		<br><br>TOT DOMANDE:<div id="numDom"></div>
		<br>DOMANDE LIBRO: <div id="domandelibro"></div> 
<!-- 	 <input type="submit" value="START QUIZ!">


	</form> 

<br>CAPITOLO <input id="capitolo" type="text" name="capitolo"><br>
<br><input type="button" value="CARICA DOMANDE" onclick="getDomande()">
<br><br>TOT DOMANDE:<div id="numDom"></div>
<br>DOMANDE LIBRO: <div id="domandelibro"></div> -->	
</body>
</html>