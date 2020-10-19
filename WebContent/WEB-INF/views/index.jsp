<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Inizia il tuo Quiz OnLine</title>
</head>
<body>
	Questa è la pagina di ingresso al tuo Quiz Online

	<%-- SEZIONE SELEZIONE DOMANDE --%>

	<form method="post" action="./load">
		<label for="nomeQuiz">Nome quiz:</label>
		<input type="text" name="nomeQuiz" id="nomeQuiz">
		<h3>Seleziona le sezioni che desideri fare:</h3>
		<b>OCA MANUAL</b>
		<br>
		<label> Capitolo 1
			<input type="checkbox" value="oca_manual\domande_cap1.xml" name="questions">
		</label>
		<br>
		<label> Capitolo 2
			<input type="checkbox" value="oca_manual\domande_cap2.xml" name="questions">
		</label>
		<br>
		<label> Capitolo 3
			<input type="checkbox" value="oca_manual\domande_cap3.xml" name="questions">
		</label>
		<br>
		<label> Capitolo 4
			<input type="checkbox" value="oca_manual\domande_cap4.xml" name="questions">
		</label>
		<br>
		<label> Capitolo 5
			<input type="checkbox" value="oca_manual\domande_cap5.xml" name="questions">
		</label>
		<br>
		<label> Capitolo 6
			<input type="checkbox" value="oca_manual\domande_cap6.xml" name="questions">
		</label>
		<br>
		<label> Assessment Test
			<input type="checkbox" value="oca_manual\domande_Assessment_Test.xml" name="questions">
		</label>
		<br>
		<b>MANNING</b>
		<br>
		<label> Capitolo 1
			<input type="checkbox" value="oca_certification_guide_manning\domande_cap1.xml" name="questions">
		</label>
		<br>
		<label> Capitolo 2
			<input type="checkbox" value="oca_certification_guide_manning\domande_cap2.xml" name="questions">
		</label>
		<br>
		<label> Capitolo 3
			<input type="checkbox" value="oca_certification_guide_manning\domande_cap3.xml" name="questions">
		</label>
		<br>
		<label> Capitolo 4
			<input type="checkbox" value="oca_certification_guide_manning\domande_cap4.xml" name="questions">
		</label>
		<br>
		<label> Capitolo 5
			<input type="checkbox" value="oca_certification_guide_manning\domande_cap5.xml" name="questions">
		</label>
		<br>
		<label> Capitolo 6
			<input type="checkbox" value="oca_certification_guide_manning\domande_cap6.xml" name="questions">
		</label>
		<br>
		<label> Capitolo 7
			<input type="checkbox" value="oca_certification_guide_manning\domande_cap7.xml" name="questions">
		</label>
		<br>
		<input type="submit" value="PREPARA QUIZ">
	</form>
</body>
</html>