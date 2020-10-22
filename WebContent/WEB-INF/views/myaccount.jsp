<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Account</title>
</head>
<style>

   	table {
	  font-family: "arial black", sans-serif;
	  border-collapse: collapse;
	  width: 100%;
	}
	
	td, th {
	  border: 1px solid #dddddd;
	  text-align: left;
	  padding: 8px;
	}
	
	tr:nth-child(even) {
	  background-color: #dddddd;
	}
	
</style>
<body>
    <p>Welcome ${name} ${surname}</p>
    
    <!-- create new exam -->
    <a href="./index" role="button">CREATE NEW QUIZ</a><br/>
    
	<!-- tabella per storico esami fatti -->
	<h2>History</h2>
<table>
	<tr>
			<!-- <th>User id</th> -->
			<th>Test name</th>
			<th>date_time_begin</th>
			<th>date_time_end</th>
			<th>score</th>
			<th>Questions number</th>
	</tr>
</table>	
</body>
</html>