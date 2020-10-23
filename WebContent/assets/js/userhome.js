fetch("./history")
	.then(response => response.json())
	.then(json => buildTable(json))


function buildTable(data) {
	console.log(data);
	var table = document.getElementById('myTable')
	for (var i = 0; i < data.length; i++) {
/*		let start = data[i].dateTimeBegin.year + "-" + data[i].dateTimeBegin.monthValue + "-" + data[i].dateTimeBegin.dayOfMonth + " " + data[i].dateTimeBegin.hour + ":" + data[i].dateTimeBegin.minute
		let finish = data[i].dateTimeEnd.year + "-" + data[i].dateTimeEnd.monthValue + "-" + data[i].dateTimeEnd.dayOfMonth + " " + data[i].dateTimeEnd.hour + ":" + data[i].dateTimeEnd.minute
*/		
		console.log("start: ",data[i].dateTimeBegin)
		console.log("end:",data[i].dateTimeEnd)
		var row = '<tr><td>' + data[i].test_name + '</td><td>' + data[i].dateTimeBegin + '</td><td>' + data[i].dateTimeEnd + '</td><td>' + data[i].questionsNumber + '</td><td>' + data[i].score + '</td></tr>'
		table.innerHTML += row
	}
} 