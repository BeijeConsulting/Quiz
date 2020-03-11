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

function getDomande() {
	let dirLibro = document.getElementById("dirLibro").value;
	let capitolo=document.getElementById("capitolo").value;
	var txt="";
	var risp=" ";
	let numDom=document.getElementById("numDom").value;

	fetch('http://localhost:8080/Quiz/domande/'+dirLibro+"/"+capitolo)
	  .then(response => response.json())
	  .then(domande => {
		console.log(domande);
		numDom=domande.length;
		console.log(dirLibro);
		for(i=0; i<domande.length;i++){
			var element = domande[i];
			console.log(element);
			txt+="<h4>"+element.id+"</h4>"+element.testo;
			risp= element.risposte;
			for(j=0;j<risp.length;j++)
			
				txt+="<br><br>"+risp[j].value + " "+ risp[j].text+"<br>";
			
		}
	  document.getElementById("domandelibro").innerHTML=txt;
	  document.getElementById("numDom").innerHTML=numDom;
	  })
	  .catch(error => console.log('errore'));
	 } 
	 
</script>
	  <form action="/domande/{dirLibro}/{capitolo}" method="get"> 
		<c:forEach items="${listaLibri}" var="libro">
			<input type="checkbox" id="book" name="dirs" value="${libro.idBook}">
			<label for="book">${libro.title}</label>
			<br><br>
		</c:forEach>
		

	</form> 
LIBRO: <input id="dirLibro" type="text" name="dirLibro"><br>
<br>CAPITOLO <input id="capitolo" type="text" name="capitolo"><br>
<br><input type="button" value="CARICA DOMANDE" onclick="getDomande()">
<br><br>TOT DOMANDE:<div id="numDom"></div>
<br>DOMANDE LIBRO: <div id="domandelibro"></div>
</body>
</html>