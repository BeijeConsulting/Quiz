<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>REGISTRATI</title>
</head>
	<body>
		<h2><em>OCA test website</em></h2>

	 	<h4>Entra a far parte del sito e allenati con le nostre domande!</h4>
	 	
	 	<h4 style="color:rgb(255, 0, 0);"> ${errore} </h4>
	 	
		<h3>Riempi il seguente form:</h3>
		<form action="./register" method="post" name="invio" >
			NICKNAME:&nbsp;<input type="text" name="nickname" placeholder="nickame" required/><br/>
			EMAIL&nbsp;<input type="email" name="email" value="" placeholder="user@domain.it"
								required/><br/>
			PASSWORD&nbsp;<input type="password" name="password" value="" required/><br>
			CONFERMA PASSWORD&nbsp;<input type="password" name="password2" value="" 
										required onchange="verificaPassword()"/><br>
			<div id="passNo" style="color:rgb(255, 0, 0);"></div>
			<div id="passOk" style="color:rgb(0, 255, 0);"></div>
			
 			<input type="submit" value="INVIO" />
		</form>

		<script type="text/javascript">
			function verificaPassword() {
				// document.nome_del_form.nome_campo.value;
				document.getElementById('passOk').innerHTML="";
				document.getElementById('passNo').innerHTML="";
				let pass1 = document.invio.password.value;
				let pass2 = document.invio.password2.value;
				if (pass1 === pass2)
					document.getElementById('passOk').innerHTML="Le password sono uguali";
				else
					document.getElementById('passNo').innerHTML="ALERT: password incoerenti";
			}
		
		</script>
	</body>
</html>