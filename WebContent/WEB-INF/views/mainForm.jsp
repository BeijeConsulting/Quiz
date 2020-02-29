<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
@charset "ISO-8859-1";

html,body{height:100%; overflow:hidden; margin:0; padding:0;}
body{background: #eee;}

/*-----------------------------
general
-----------------------------*/

input[type=submit] {
    border-radius: 5px;
    border: none;     
    font-family: Tahoma;
    background: #4CAF50;
	color: black;
	padding: 16px 32px;
	text-decoration: none;
	margin: 4px 2px;
	cursor: pointer;
	    
    /* Old browsers */
    background: -moz-linear-gradient(top, #f4f4f4 1%, #ededed 100%);
    /* FF3.6+ */
    background: -webkit-gradient(linear, left top, left bottom, color-stop(1%, #f4f4f4), color-stop(100%, #ededed));
    /* Chrome,Safari4+ */
    background: -webkit-linear-gradient(top, #f4f4f4 1%, #ededed 100%);
    /* Chrome10+,Safari5.1+ */
    background: -o-linear-gradient(top, #f4f4f4 1%, #ededed 100%);
    /* Opera 11.10+ */
    background: -ms-linear-gradient(top, #f4f4f4 1%, #ededed 100%);
    /* IE10+ */
    background: linear-gradient(to bottom, #f4f4f4 1%, #ededed 100%);
    /* W3C */
    filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#f4f4f4', endColorstr='#ededed', GradientType=0);
    /* IE6-9 */
    
}

.animate{
	-webkit-transition: all 0.3s ease-out;
					transition: all 0.3s ease-out;
}

.button{display: inline-block; background: #fff; color:#000;padding: 15px 30px; border-radius:3px; text-decoration: none;}
p{line-height: 22px}
a{color:#16dd94}
a:hover{color: #1af3a4;}

/*------------------------
Header
-------------------------*/
.header{background: #333}
.header__logo{color:#fff; float:left;display: block;padding:21.5pt;text-decoration: none; background-image: url("/Quiz/logo"); background-size: contain;}
.header__menu{float:right;margin:0; padding:0;}
.header__menu__item{display: inline-block;}
.header__menu__item a{color:#fff;display: block;padding:20px;text-decoration: none}
.header__menu__item a:hover{background: #000}
.header__icon-bar{display: block;float: right;padding:20px;display: none;}
.header__icon-bar span{display: block;height:3px; width: 30px;background: #fff; margin-bottom: 5px;}
/*------------------------
Cover
-------------------------*/
.cover{height:70%;
	background-image: url("https://source.unsplash.com/category/buildings");
	background-size: cover;
	-o-background-size: cover;
	-moz-background-size: cover;
	background-position: center center;
	position:relative;
}
.cover__filter{ background: #000; width:100%; height:100%; position: absolute; z-index: 0; opacity: 0.5; }
.cover__caption{ display: table; height: 100%; width:100%; position: relative; z-index:1; padding: 0 20px}
.cover__caption__copy{ display: table-cell; vertical-align: middle; text-align: center; color:#fff; }

.cover--single{height: 50%}
.cover--single h1{font-size: 42px;}



/*-----------------------------
Banner
-----------------------------*/
.banner{background: #fff; height:50%;margin-top:40px}
.banner__image{width:25%; float:left;height:100%;
	background-image: url("ivo.png");
	background-size: cover;
	-o-background-size: cover;
	-moz-background-size: cover;
	background-position: center center;
}
.banner__copy{width:70%; float:left;height:100%;display: table;}
.banner__copy__text{display: table-cell; vertical-align: middle;padding:30px;}

.banner__copy__text h3{font-size: 36px;margin-bottom:0;}
.banner__copy__text h4{font-size: 22px;margin: 5px 0}


/*-----------------------------
Footer
-----------------------------*/

.footer{background: #333; padding:30px;color:#fff; margin-top: 40px}
.footer__bottom{padding-top: 200px}


/*-----------------------------
Single
-----------------------------*/
.panel{}
.panel__copy{max-width: 800px; margin: 0px auto; margin-top: -60px; background: #fff; padding:20px 40px;position: relative; z-index: 1}
.panel__copy__meta{font-weight: bold;font-size: 16px;	}
.panel__copy__title{font-size: 32px;}



/*------------------------
Form
-------------------------*/
.form__insert {padding: 30px; margin-left: 25px;}
.form__aligned {display: block;	text-align:center; margin-left: auto; margin-right: auto; width: 40%;}


.hr__styled {
	display: block;
	text-align:center;
	margin-left: auto;
	margin-right: auto;
	width: 40%;
}


/*-----------------------------
Clearfix
-----------------------------*/

.clearfix:after {
	visibility: hidden;
	display: block;
	font-size: 0;
	content: " ";
	clear: both;
	height: 0;
}

* html .clearfix {
	zoom: 1;
} /* IE6 */
*:first-child+html .clearfix {
	zoom: 1;
} /* IE7 */

*,
*:before,
*:after {
  -webkit-box-sizing: border-box;
     -moz-box-sizing: border-box;
          box-sizing: border-box;
}



</style>
<meta charset="ISO-8859-1">
<title>Menu</title>
</head>
<body>
	<header class="header clearfix">
		<a href="#" class="header__logo"></a> <a href=""
			class="header__icon-bar"> <span></span> <span></span> <span></span>
		</a>
		<ul class="header__menu">
			<li class="header__menu__item"><form action="./aggiungiDomanda" method="POST">
	<input type="submit"  value="Aggiungi Domande"></form></li>
			<li class="header__menu__item"><form action="./aggiungiLibro" method="POST">
	<input type="submit" value="Aggiungi Libro">
	</form></li>
			<li class="header__menu__item"><form action="./visualizzaDomande" method="POST">
	<input type="submit" value="Crea Un Quiz">
	</form></li>
		</ul>
	</header>
	
	<section class="cover">
		<div class="cover__filter"></div>
		<div class="cover__caption">
			<div class="cover__caption__copy">
				<h1>live fast, escape from the Crown</h1>
				<h2>TeamClaRiGa's Project</h2>
			</div>
		</div>
	</section>
	
	<footer class="footer">
		Copyright - 2020 TeamClaRiGa_Design
		
		<form action="nostriContatti.jsp" method="POST" >		
		<input type="submit" value="chi siamo" style="float:right;">
		</form>
	</footer>
	
	
	
	
	
	
	
	
	
</body>
</html>