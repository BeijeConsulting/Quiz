<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Homepage</title>
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/media/favicon.ico" />

	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/stats.css" />
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</head>
<body onload="loadStats(${sessionScope.userBean.id})">



<div class="container">
	<div class="row justify-content-around">
		<h1 class="display-4">Bentornato, ${sessionScope.userBean.name}</h1>
	</div>

	<!-- PROGRESS -->
	<div class="row justify-content-around">
		<div class="col-sm-8">
			<div class="bg-white rounded-lg p-5 shadow">
				<h2 class="h6 font-weight-bold text-center mb-4">I Tuoi Progressi</h2>

				<!-- CIRCLE -->
				<div class="progress" id="progress" data-percentage="74">
					<span class="progress-left">
						<span class="progress-bar"></span>
					</span>
					<span class="progress-right">
						<span class="progress-bar"></span>
					</span>
					<div class="progress-value" >
						<div>
							<span id="perc-value" style="font-size: 36px; font-weight: 300"></span><br>
							<span>Successo</span>
						</div>
					</div>
				</div>
				<!-- END CIRCLE -->
				<!-- STATS  -->
				<div class="row text-center mt-4">
					<div class="col-6 border-right">
						<div class="h4 font-weight-bold mb-0" id="esamiPassati"></div><span class=" text-gray">Esami Passati</span>
					</div>
					<div class="col-6">
						<div class="h4 font-weight-bold mb-0" id="esamiFatti"></div><span class=" text-gray">Esami Fatti</span>
					</div>
				</div>
				<!-- END STATS-->
			</div>
		</div>
	</div>
	<!-- END PROGRESS -->

	<div class="row justify-content-center">

			<button type="button" class="btn btn-primary btn-lg">
				<a class="text-decoration-none" style="color: white"
				   href="${pageContext.request.contextPath}/startQuiz">Nuovo Quiz</a>
			</button>
			<button type="button" class="btn btn-info btn-lg">
				<a class="text-decoration-none" style="color: white"
				   href="${pageContext.request.contextPath}/history">Vedi Quiz Passati</a>
			</button>
	</div>
</div>
<script src="${pageContext.request.contextPath}/resources/js/statsAjax.js"></script>
</body>
</html>