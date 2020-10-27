<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/media/favicon.ico" />

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<script src="<c:url value="/resources/js/old/quiz.js" />"></script>
	<title>Test Java</title>
</head>
<body onload='onPageLoad(${sessionScope.idQuiz}); prepareTimer(${sessionScope.idQuiz})'>

<div class="container">
	<div class="row justify-content-end">
		<p id="timerDisplay"></p>
	</div>

	<div class="container-questions" style="margin-top: 20px;">
		<div class="row justify-content-center">
			<div id="question_title">Question n°<span id="question_number"></span></div>
		</div>
		<div class="row justify-content-center">
			<div id="question_body">Corpo Domanda</div>
		</div>
		<div class="row justify-content-center">
			<div id="answers_body">Corpo Risposta</div>
		</div>

		<div id="page_buttons" class="row justify-content-around" style="margin-top: 20px">
			<button id="button_prev" type="button" class="btn btn-warning" onclick="onClickPrev()">Prev</button>
			<button id="button_next" type="button" class="btn btn-success" onclick="onClickNext()">Next</button>
		</div>
		<form id="end_test_form" action="./svolgiQuiz" onsubmit="onSubmitForm()" method="POST">
			<div class="row justify-content-center">
				<div id="submit_block"><button class="btn btn-primary" id="button_submit" type="submit">Finish test</button></div>
			</div>
		</form>
	</div>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>