<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="<c:url value="/resources/js/domandaAjax.js" />"></script>
<title>Test Java</title>
</head>
<body onload='onPageLoad(${sessionScope.idQuiz})'>
<!-- <body onload="onPageLoad(${request.getSession().getAttribute('idQuiz')})"> -->

<!-- <div>Time</div>
<div>Test - Nome</div>
<div>Domanda n° </div>
<div>Corpo domanda</div>
<div>Risposte</div>
<div>Bottoni</div> -->

<div id="question_title">Question n°<span id="question_number"></span></div>
<div id="question_body">Corpo Domanda</div>
<div id="answers_body">Corpo Domanda</div>
<div id="page_buttons">
	<button id="button_prev" type="button" onclick="onClickPrev()">Prev</button>
	<button id="button_next" type="button" onclick="onClickNext()">Next</button>
</div>
<form id="end_test_form" action="./#" onsubmit="onSubmitForm()">
	<div id="submit_block"><button id="button_submit" type="submit">Finish test</button></div>
</form>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>