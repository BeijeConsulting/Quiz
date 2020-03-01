<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
			  pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<link href="<c:url value="/pages/css/team_clariga_stylesheet.css" />"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/4.2.0/normalize.css">

<head>
<meta charset="ISO-8859-1">
<title>Crea libro</title>
</head>
<body>
<header class="header clearfix">
		<a href="./" class="header__logo">Logo</a> <a href=""
			class="header__icon-bar"> <span></span> <span></span> <span></span>
		</a>
		<ul class="header__menu animate">
			<li class="header__menu__item"><a href="">Home</a></li>
			<li class="header__menu__item"><a href="">Single</a></li>
			<li class="header__menu__item"><a href="">Page</a></li>
			<li class="header__menu__item"><a href="">Item</a></li>
			<li class="header__menu__item"><a href="">Item</a></li>
		</ul>
	</header>
	<section class="cover cover--single">
		<div class="cover__filter"></div>
		<div class="cover__caption">
			<div class="cover__caption__copy">
				<h1>Team ClaRiGa</h1>
				<h2>forward-looking team</h2>
			</div>
		</div>
	</section>
	
	
		<article class="panel">
		<div class="panel__copy" style="background-color: #da614e">
			<h2 class="panel__copy__title">Crea nuovo libro</h2>
			
			<form action="./creaLibro" method="post">
			 Directory del libro: <input type="text" name="IDbook"><br><br>
			 Titolo del libro: <input type="text" name="title"><br><br>	
			<input type="submit" value="CONFERMA AGGIUNTA LIBRO">
			</form>
		</div>				
	</article>



<footer class="footer clearfix">
		Copyright - 2020 TeamClaRiGa_Design

		<form action="nostriContatti.jsp" method="POST">
			<input type="submit" value="chi siamo" style="float: right;">
		</form>
	</footer>

</body>
</html>