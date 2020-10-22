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
    <a href="./index" >CREATE NEW QUIZ</a><br/>
    
	<!-- tabella per storico esami fatti -->
	<h2>History</h2>
<table>
	<tr>
			<!-- <th>User id</th> -->
			<th>Test name</th>
			<th>Start</th>
			<th>Finish</th>
			<th>Questions number</th>
			<th>Score</th>
	</tr>
	<tbody id="myTable">
		</tbody>
</table>	
</body>
<script>
 
	fetch("./history")
	.then(response => response.json())
	.then(json => buildTable(json))
	
	function buildTable(data){
	console.log(data);
		var table = document.getElementById('myTable')
		for(var i = 0; i < data.length; i++){
			let start = data[i].dateTimeBegin.year +"-"+data[i].dateTimeBegin.monthValue+"-"+data[i].dateTimeBegin.dayOfMonth+" "+data[i].dateTimeBegin.hour+":"+data[i].dateTimeBegin.minute
			let finish = data[i].dateTimeEnd.year +"-"+data[i].dateTimeEnd.monthValue+"-"+data[i].dateTimeEnd.dayOfMonth+" "+data[i].dateTimeEnd.hour+":"+data[i].dateTimeEnd.minute
			console.log(start)
			console.log(JSON.stringify(data[i].dateTimeBegin))
			var row = '<tr><td>'+data[i].test_name+'</td><td>'+start+'</td><td>'+finish+'</td><td>'+data[i].questionsNumber+'</td><td>'+data[i].score+'</td></tr>'
			table.innerHTML += row
		}
	}
</script>
</html>