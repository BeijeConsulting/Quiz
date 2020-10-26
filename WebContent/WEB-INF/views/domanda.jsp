<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<!--
	Hielo by TEMPLATED
	templated.co @templatedco
	Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
-->
<html>
	<head>
		<title>Quiz | Test</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="<c:url value="/assets/css/main.css" />" />
	</head>
	<body>

		<!-- Header -->
			<header id="header" class="alt">
				<div class="logo">Benvenuto, <%= request.getSession().getAttribute("username") %></div>
				<a href="#menu">Menu</a>
			</header>

		<!-- Nav -->
			<nav id="menu">
				<ul class="links">
					<li><a href="/quiz/">Home</a></li>
					<li><a href="/quiz/storico">Storico</a></li>
					<li><a href="/quiz/logout">Log out</a></li>
				</ul>
			</nav>


			<!-- Two -->
			<section id="two" class="wrapper style3">
				<div class="inner">
					<header class="align-center">
						<p id="timer"></p>
						<% int counter = (int)session.getAttribute("counter"); %>
						<h2>Domanda <%= counter %></h2>
					</header>
				</div>
			</section>

		<!-- One -->
			<section id="one" class="wrapper style2">
				<div class="inner">
					<!-- Preformatted Code -->
					<h3>Domanda</h3>
					<p></p>
					<pre><code>${ domanda.testo }</code></pre>
				<!-- Form -->
				<h3>Risposte</h3>

				<form method="post" action="/quiz/domanda/${ counter }">
					<div class="row uniform">
					<c:if test = "${domanda != null && domanda.type.equals(\"radio\")}">
						<c:forEach var = "risposta" items="${ risposte }">
							<div class="12u$">
								<input type="radio" id="${ risposta.lettera }" name="${ risposta.lettera }" checked>
								<label for="${ risposta.lettera }">${ risposta.lettera }) ${ risposta.risposta }</label>
							</div>
						</c:forEach>
					</c:if>
					<c:if test = "${domanda != null && domanda.type.equals(\"checkbox\")}">
						<c:forEach var = "risposta" items="${ risposte }">
							<div class="12u$">
								<input type="checkbox" id="${ risposta.lettera }" name="${ risposta.lettera }">
								<label for="${ risposta.lettera }">${ risposta.lettera }) ${ risposta.risposta }</label>
						</div>
						</c:forEach>
					</c:if>
						<div class="12u$">
							<ul class="actions">
								<li><input type="submit" value="Next" /></li>
							</ul>
						</div>
					</div>
				</form>
				</div>
			</section>


		<!-- Footer -->
		<footer id="footer">
			<div class="copyright">
				&copy; Beije Consulting. All rights reserved.
			</div>
		</footer>

		<!-- Scripts -->
			<script src="<c:url value="/assets/js/jquery.min.js" />"></script>
			<script src="<c:url value="/assets/js/jquery.scrollex.min.js" />"></script>
			<script src="<c:url value="/assets/js/skel.min.js" />"></script>
			<script src="<c:url value="/assets/js/util.js" />"></script>
			<script src="<c:url value="/assets/js/main.js" />"></script>
			
			<script type="text/javascript">
				var ore = ${ ore };
				var minuti = ${ minuti };
				var secondi = ${ secondi };
				
				function formattaTimer(hours,minutes,seconds) {
					var t = "0" + hours;
					t = t + ":" + ( minutes < 10 ? "0" : "") + minutes;
					t = t + ":" + ( seconds < 10 ? "0" : "") + seconds;
					return t;
				}
				
				function myTimer() {
					document.getElementById("timer").innerHTML = formattaTimer(ore, minuti, secondi--);
				  if (secondi < 0) {
					  if(minuti > 0) {
						  secondi = 59;
						  minuti--;
					  }else if (ore > 0) {
						  secondi = 59;
						  minuti = 59;
						  ore--;
					  } else {
				    		clearInterval(timer);
				    		document.getElementById("timer").innerHTML = 'TEMPO SCADUTO';
				    		//location.href = "/quiz/risposta";
					  }
				  }
				  
				}
				
				myTimer();
				
				var timer = setInterval(myTimer, 1000);				
			</script>
			
			

	</body>
</html>
