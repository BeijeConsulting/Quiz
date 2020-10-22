<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Quiz review</title>
</head>
<body>

	<a href="./history">Torna allo storico dei quiz</a>
	<button onclick="./history">Torna allo storico dei quiz</button>
	
	<!-- PER ORA � IL COPIA INCOLLA DI history.jsp, CI DEVO LAVORARE -->
	<h4>${user.name} ecco lo storico dei quiz che hai completato: <br></h4>

	<table>
		<tr>
		    <th>First name</th>
		    <th>Last Name</th>
		    <th>Age</th>
	 	</tr>
	   	<c:forEach var = "esame" items="${esami}">
	   		<tr>
		   		<th><c:out value = "${esame.passato}"/></th>
		   		<th><c:out value = "${esame.name}"/></th>
		   		<th><c:out value = "${esame.results}"/></th>
				<th><button onclick="./quiz_review/${esame.id}"> Riguarda risposte</button></th>
				<br>
		    </tr>
		</c:forEach>
	</table>



		<script>
		let memory = "";
		let url = 'http://localhost:8080/OortSpring/rest/libri_autore/' 
		//prende i dati da un url
		function libriAutore() {
			//let valore = document.getElementById("myForm").elements[0].value;
			let valore = document.getElementById("myForm").elements.namedItem("select").value;
			fetch(url + valore)
			 .then(response => response.json())
			 .then(json => {
				console.log(json);
				
					memory = json[0].id_autore;
					document.getElementById('id_autore').innerHTML = memory;
		  		})
		  }
		</script>
</body>
</html>