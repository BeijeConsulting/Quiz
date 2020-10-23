/**
 * 
 */


function viewCapitoliOCA() {
	document.getElementById("OCA-button").disabled = true;
	document.getElementById('OCA-view').innerHTML += "<label>Book: OCA MANUAL</label><br>";
	document.getElementById('OCA-view').innerHTML += "<label> Assessment Test <input type=" + "checkbox" + " value=1-" + "Assessment_Test" + " name=" + "questions" + "></label><br>" /* value="+"oca_manual\domande_Assessment_Test.xml"+" name="+"questions"+"></label><br>" */
	for (var i = 1; i < 7; i++) {
		document.getElementById('OCA-view').innerHTML += "<label> Chapter " + i + "<input type=" + "checkbox" + " value=1-" + i + " name=" + "questions" + "></label><br>" /* value="+"oca_manual\domande_cap"+i+".xml"+" name="+"questions"+"></label><br>"		 */
	}
}

function viewCapitoliMANNING() {
	document.getElementById("MAN-button").disabled = true;
	document.getElementById('MAN-view').innerHTML += "<label>Book: MANNING</label><br>";
	for (var i = 1; i < 7; i++) {
		document.getElementById('MAN-view').innerHTML += "<label> Chapter " + i + "<input type=" + "checkbox" + " value=2-" + i + " name=" + "questions" + "></label><br>"
	}
} 