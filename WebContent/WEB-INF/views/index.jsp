<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Homepage</title>

	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</head>
<body onload="loadStats(${sessionScope.userBean.id})">
<div class="container">
	<h3>Bentornato ${sessionScope.userBean.name}</h3>

	<h5>Ecco le tue statistiche</h5>
	<p id="esamiPassati">Esami Passati: </p>
	<p id="esamiFatti">Esami Fatti: </p>
	<p id="percentuale">Percentuale esami passati: </p>

	<button>
		<a href="${pageContext.request.contextPath}/startQuiz">Nuovo Quiz</a>
	</button>
	<button>
		<a href="#">Vedi Quiz Passati</a>
	</button>
</div>
<script src="${pageContext.request.contextPath}/resources/js/statsAjax.js"></script>
</body>
</html>