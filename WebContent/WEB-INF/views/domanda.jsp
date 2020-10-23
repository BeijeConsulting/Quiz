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
		<link rel="stylesheet" href="<c:url value="assets/css/main.css" />" />
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
					<li><a href="./">Home</a></li>
					<li><a href="./storico">Storico</a></li>
					<li><a href="./logout">Log out</a></li>
				</ul>
			</nav>


			<!-- Two -->
			<section id="two" class="wrapper style3">
				<div class="inner">
					<header class="align-center">
						<p id="timer"></p>
						<h2>Domanda X</h2>
					</header>
				</div>
			</section>

		<!-- One -->
			<section id="one" class="wrapper style2">
				<div class="inner">
					<!-- Preformatted Code -->
					<h3>Domanda</h3>
					<p>Lorem ipsum dolor sit amet nullam id egestas urna aliquam rem ipsum dolor sit amet nullam id egestas urna aliquam 
						rem ipsum dolor sit amet nullam id egestas urna aliquam rem ipsum dolor sit amet nullam id egestas urna aliquam</p>
					<pre><code>i = 0;

while (!deck.isInOrder()) {
	print 'Iteration ' + i;
	deck.shuffle();
	i++;
}

print 'It took ' + i + ' iterations to sort the deck.';
</code></pre>
				<!-- Form -->
				<h3>Risposte</h3>

				<form method="post" action="#">
					<div class="row uniform">
						<div class="12u$">
							<input type="radio" id="priority-low" name="priority" checked>
							<label for="priority-low">Low Priority</label>
						</div>
						<div class="12u$">
							<input type="radio" id="priority-normal" name="priority">
							<label for="priority-normal">Normal Priority</label>
						</div>
						<div class="12u$">
							<input type="radio" id="priority-high" name="priority">
							<label for="priority-high">High Priority</label>
						</div>
						<!-- Break -->
						<div class="12u$">
							<input type="checkbox" id="copy" name="copy">
							<label for="copy">Email me a copy of this message</label>
						</div>
						<div class="12u$">
							<input type="checkbox" id="human" name="human" checked>
							<label for="human">I am a human and not a robot</label>
						</div>
						<!-- Break -->
						<div class="12u$">
							<ul class="actions">
								<li><input type="submit" value="Next" /></li>
								<li><input type="reset" value="Reset" class="alt" /></li>
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
			<script src="<c:url value="assets/js/jquery.min.js" />"></script>
			<script src="<c:url value="assets/js/jquery.scrollex.min.js" />"></script>
			<script src="<c:url value="assets/js/skel.min.js" />"></script>
			<script src="<c:url value="assets/js/util.js" />"></script>
			<script src="<c:url value="assets/js/main.js" />"></script>
			
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
