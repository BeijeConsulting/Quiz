<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<link href="<c:url value="/pages/css/team_clariga_stylesheet.css" />"
	rel="stylesheet">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/4.2.0/normalize.css">
<head>
<title>TeamClaRiGa Quiz Project</title>
</head>
<body>
	<header class="header clearfix">
		<a href="./" class="header__logo">Logo</a>
		<a href="" class="header__icon-bar">
			<span></span>
			<span></span>
			<span></span>
		</a>
		<ul class="header__menu animate">
			<li class="header__menu__item"><a href="">Home</a></li>
			<li class="header__menu__item"><a href="">Single</a></li>
			<li class="header__menu__item"><a href="">Page</a></li>
			<li class="header__menu__item"><a href="">Item</a></li>
			<li class="header__menu__item"><a href="">Item</a></li>
		</ul>
	</header>

	<section class="cover">
		<div class="cover__filter"></div>
		<div class="cover__caption">
			<div class="cover__caption__copy">
				<h1>live fast escape from the Crown</h1>
				<h2>TeamClaRiGa's Project</h2>

			</div>
		</div>
	</section>
	
	<section class="banner clearfix">
		<div class="banner__image"
			style='background-image: url("pages/banner1.png");'></div>
		<div class="banner__copy">
			<div class="banner__copy__text">
				<h3>Crea contenuti aggiuntivi</h3>
				<h4>aggiungi nuova domanda</h4>
				<p>questa sezione è dedicata all'aggiunta di ulteriori contenuti
					a dei quiz già esistenti. In particolare, sarà possibile
					aggiungiere nuove domande di libri già creati. Clicca il pulsante
					"Aggiungi Domanda" per spostarti nel form in questione.</p>

				<div class="cover__caption__copy">
					<ul class="cover__list">
						<li class="cover__list__item"><form
								action="./aggiungiDomanda" method="POST">
								<input type="submit" value="Aggiungi Domanda">
							</form></li>
					</ul>
				</div>
			</div>
		</div>
	</section>
	<section class="banner clearfix">
		<div class="banner__image"
			style='background-image: url("pages/banner2.png");'></div>
		<div class="banner__copy">
			<div class="banner__copy__text">
				<h3>Crea contenuti aggiuntivi</h3>
				<h4>aggiungi nuovo libro</h4>
				<p>questa sezione è dedicata all'aggiunta di ulteriori
					contenuti. In particolare, sarà possibile aggiungiere nuovi libri.
					Clicca il pulsante "Aggiungi Libro" per spostarti nel form in
					questione.</p>
				<div class="cover__caption__copy">
					<ul class="cover__list">
						<li class="cover__list__item"><form action="./aggiungiLibro"
								method="POST">
								<input type="submit" value="Aggiungi Libro">
							</form></li>
					</ul>
				</div>
			</div>
		</div>
	</section>
	<section class="banner clearfix">
		<div class="banner__image"
			style='background-image: url("pages/banner3.png");'></div>
		<div class="banner__copy">
			<div class="banner__copy__text">
				<h3>Svogli un Quiz</h3>
				<h4>svolgere un quiz come vuoi tu!</h4>
				<p>questa sezione è dedicata allo svolgimento di un quiz in base
					ai contenuti precedentemente inseriti. In particolare, sarà
					possibile scegliere a quale/quali libro/i riferirsi per lo
					svolgimento del testo. Una volta scelto, partirà il corrispetivo
					quiz. Clicca il pulsante "Crea Un Quiz" per spostarti nella sezione
					in questione.</p>
				<div class="cover__caption__copy">
					<ul class="cover__list">
						<li class="cover__list__item"><form
								action="./visualizzaDomande" method="POST">
								<input type="submit" value="Crea Un Quiz">
							</form></li>
					</ul>
				</div>
			</div>
		</div>
	</section>






	<footer class="footer clearfix">
		Copyright - 2020 TeamClaRiGa_Design

		<form action="nostriContatti.jsp" method="POST">
			<input type="submit" value="chi siamo" style="float: right;">
		</form>
	</footer>

	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
	






</body>
</html>