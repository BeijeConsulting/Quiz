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
		<title>Quiz | Home</title>
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
						<p>Java quiz</p>
						<h2>Seleziona un libro</h2>
					</header>
				</div>
			</section>

		<!-- One -->
			<section id="one" class="wrapper style2">
				<div class="inner">
					<div class="grid-style">

					<c:if test = "${libri != null && libri.size() > 0}">
						<c:forEach var = "libro" items="${ libri }">
						<div>
							<div class="box">
								<div class="image fit">
									<img src="images/${ libro.toLowerCase() }.jpg" alt="" />
								</div>
								<div class="content">
									<header class="align-center">
										<p>Titolo libro</p>
										<h2>${ libro }</h2>
									</header>
									<footer class="align-center">
										<a href="#" class="button alt">Seleziona</a>
									</footer>
								</div>
							</div>
						</div>
						</c:forEach>
					</c:if>

					</div>
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

	</body>
</html>
