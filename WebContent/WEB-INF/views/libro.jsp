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
		<title>Quiz | Libro</title>
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
					<li><a href="/quiz/">Home</a></li>
					<li><a href="/quiz/storico">Storico</a></li>
					<li><a href="/quiz/logout">Log out</a></li>
				</ul>
			</nav>


			<!-- Two -->
			<section id="two" class="wrapper style3">
				<div class="inner">
					<header class="align-center">
						<p>Java quiz</p>
						<h2>${ libro }</h2>
					</header>
				</div>
			</section>

		<!-- One -->
			<section id="one" class="wrapper style2">
				<div class="inner">
					<h3>Seleziona capitoli</h3>
					<!-- Form -->
                    <form method="get" action="./domanda" onsubmit="return submitCheck()">
                        <div class="row uniform">
                        <c:forEach var = "capitolo" items="${ capitoli }">
                            <div class="6u 12u$(small)">
                                <input type="checkbox" value="${ capitolo }" id="capitolo${ capitolo }" name="capitolo">
                                <label for="capitolo${ capitolo }">Capitolo ${ capitolo }</label>
                            </div>
                        </c:forEach>
                            <div class="6u 12u$(small)">
                                <h3>Random?</h3>
                                <input type="checkbox" id="random" name="random">
                                <label for="random">random</label>
                            </div>
                            <!-- Break -->
                            <div class="12u$">
                                <h3>Quiz name:</h3>
                                <input type="text" name="quizName" id="quizName" value="" placeholder="Quiz name" />
                            </div>
                            <!-- Break -->
                            <div class="12u$">
                            	<input type="hidden" name="libro" id="" value="${ libro }" placeholder="" required/>
                                <ul class="actions">
                                    <li><input type="submit" value="Start test" /></li>
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

		<script>
			var counter = 0;
			
			function checkCheckBox() {
				var checks = document.getElementsByName("capitolo");
				for(var i = 0; i < checks.length; i++) {
					if(checks[i].checked) {
						counter++;
					}
				}
			}
			
			function submitCheck() {
				checkCheckBox();
				if(counter === 0) {
					return false;
				}
				else {
					return true;
				}
			}
		
		</script>
		


		<!-- Scripts -->
			<script src="<c:url value="assets/js/jquery.min.js" />"></script>
			<script src="<c:url value="assets/js/jquery.scrollex.min.js" />"></script>
			<script src="<c:url value="assets/js/skel.min.js" />"></script>
			<script src="<c:url value="assets/js/util.js" />"></script>
			<script src="<c:url value="assets/js/main.js" />"></script>

	</body>
</html>
