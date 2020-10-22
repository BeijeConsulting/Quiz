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
		<title>Quiz | Registrazione</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="<c:url value="assets/css/main.css" />" />
	</head>
	<body class="subpage">

        <!-- Header -->
			<header id="header">
				<div class="logo"></div>
			</header>

		<!-- Nav -->
			<nav id="menu">
				<ul class="links">
					<li><a href="index.html">Home</a></li>
					<li><a href="generic.html">Generic</a></li>
					<li><a href="elements.html">Elements</a></li>
				</ul>
			</nav>

		<!-- One -->
			<section id="One" class="wrapper style3">
				<div class="inner">
					<header class="align-center">
                        <p>Java quiz</p>
						<h2>Registrazione</h2>
					</header>
				</div>
			</section>

		<!-- Two -->
            <section id="two" class="wrapper style2"> 
				<div class="inner">
					<div class="box">
						<div class="content">
                            
                            <!-- Form -->

								<form action="./register" method="post" id="form_login">
									<div class="row uniform">
										<div class="12u$">
											<input type="text" name="name" id="name" value="" placeholder="Nome" required/>
                                        </div>
                                        <!-- Break -->
                                        <div class="12u$">
											<input type="text" name="surname" id="surname" value="" placeholder="Cognome" required/>
                                        </div>
                                        <!-- Break -->
										<div class="12u$">
											<input type="email" name="email" id="email" value="" placeholder="Email" required/>
                                        </div>
                                        <!-- Break -->
										<div class="12u$">
											<input type="password" name="password" id="password" value="" placeholder="Password" required/>
										</div>
										<!-- Break -->
										<div class="12u$">
											<ul class="actions">
												<li><input type="submit" value="Registrati" /></li>
												<li>Già registrato? <a href="./login">Log in!</a></li>
											</ul>
										</div>
										<c:if test = "${erroreRegister.length > 0}">
								 			<div class="12u$">
								 				${ erroreRegister }
											</div>
										</c:if>
									</div>
								</form>
						
						</div>
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
