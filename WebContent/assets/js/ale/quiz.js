let quiz = null;
let questions = [{id: 0, testo:"Ciao", answerType: "checkbox"}];
let indexQuestions = 0;
let answered = [];

// Get the answers to a given question id
async function getAnswers(idQuestion) {
	let path = getContextPath();
	let answers = await fetch(path + "/rest/risposte/domanda/" + idQuestion)
		.then(response => response.json())
		.then(k => {
			console.log("k" + k)
		return k
		});

	return answers;
}

// Get the questions to a given quiz id
async function getQuestions(idQuiz) {
	let path = getContextPath();
	let questions = await fetch(path + "/rest/domande/quiz/" + idQuiz)
		.then(response => response.json());
		
	return questions;
}

function setQuestionNumber() {
	let number = document.getElementById("question_number");
	number.innerHTML = indexQuestions + 1;
}

// Shows the question
function setQuestionBody(index) {
	let questionBody = document.getElementById("question_body");
	let question = questions[index];
	
	let testo = textToHtml(JSON.stringify(question.testo));
	testo = testo.substring(1, testo.length - 1);
	
	questionBody.innerHTML = testo;
}

// Populate the section of the answers
async function setAnswersBody(index) {
	let answersBody = document.getElementById("answers_body");
	console.log(answersBody);
	console.log(questions[index].id)
	let answers = await getAnswers(questions[index].id);
	console.log(answers)
	// Clean
	while(answersBody.firstChild) {
		answersBody.removeChild(answersBody.lastChild);
	}
	
	// Populate
	for(let i = 0; i < answers.length; i++) {
		console.log(buildAnswer(questions[index], answers[i]))
		answersBody.appendChild(buildAnswer(questions[index], answers[i]));
	}
}

function buildAnswer(question, answer) {
	let answerBlock = document.createElement("div");
	let input = document.createElement("input");
	input.type = question.answer_type;
	if (input.type === "checkbox") {
		input.name = "answer_" + answer.letter;
	} else if (input.type === "radio"){
		input.name = "answer_radio";
	}
	input.id = input.name;
	input.value = answer.letter;
	input.onchange = function () { onInputChange(this) };
	if (answered[indexQuestions] !== undefined && answered[indexQuestions].includes(input.value)) {
		input.checked = true;
	}
	let label = document.createElement("label");
	label.htmlFor = input.id;
	let formattedText = textToHtml(JSON.stringify(answer.text));
	formattedText = formattedText.substring(1, formattedText.length - 1);
	console.log(formattedText);
	label.innerHTML = " " + formattedText;
	
	answerBlock.appendChild(input);
	answerBlock.appendChild(label);
	return answerBlock;
}

function updateAnswered(input) {
	if (answered[indexQuestions] == null) {
		answered[indexQuestions] = [];
	}
	if (input.type === "checkbox") {
		if (input.checked) {
			if (!answered[indexQuestions].includes(input.value)) {
				answered[indexQuestions].push(input.value);
			}
		} else {
			let index = answered[indexQuestions].indexOf(input.value);
			let newAnswered = [];
			for(let i = 0; i < answered[indexQuestions].length; i++) {
				if (i !== index) {
					newAnswered.push(answered[indexQuestions][i]);
				}
			}
			answered[indexQuestions] = newAnswered;
		}
	} else if (input.type === "radio") {
		answered[indexQuestions][0] = input.value;
	}
	
	updateRispostaData(quiz, indexQuestions);
	console.log(answered[indexQuestions]);
}

async function updateRispostaData(idQuiz, indexDomanda) {
	let path = getContextPath();
	let rispostaData = await fetch(path + "/rest/risposta_data/" + idQuiz +"/" + questions[indexDomanda].id).then(response => response.json());
	let arrayAns = answered[indexDomanda];
	let stringAns = "";
	
	for (let i = 0; i < arrayAns.length; i++) {
		stringAns += arrayAns[i];
		if (i + 1 < arrayAns.length) {
			stringAns += ",";
		}
	}
	
	rispostaData.risposta = stringAns;
	
	rispostaData = await fetch(path + "/rest/risposta_data/" + idQuiz +"/" + questions[indexDomanda].id, {
		method: 'PUT',
		body: JSON.stringify(rispostaData),
		headers: {
			'Content-type': 'application/json; charset=UTF-8',
			}
		});
	console.log(rispostaData);
}

function nextQuestion() {
	if (indexQuestions < questions.length - 1) {
		indexQuestions++;
		setQuestionBody(indexQuestions);
		setAnswersBody(indexQuestions);
		setButtonsVisibility();
		setQuestionNumber();
	}
}

function prevQuestion() {
	if (indexQuestions > 0) {
		indexQuestions--;
		setQuestionBody(indexQuestions);
		setAnswersBody(indexQuestions);
		setButtonsVisibility();
		setQuestionNumber();
	}
}

function setButtonsVisibility() {
	nextButtonVisibility();
	prevButtonVisibility();
}

function nextButtonVisibility() {
	let button = document.getElementById("button_next");
	if (indexQuestions < questions.length - 1) {
		button.style.visibility = "visible";
	} else {
		button.style.visibility = "hidden";
	}
}

function prevButtonVisibility() {
	let button = document.getElementById("button_prev");
	if (indexQuestions > 0) {
		button.style.visibility = "visible";
	} else {
		button.style.visibility = "hidden";
	}
}

function endTest() {
	// todo deve fare qualcosa
	console.log(quiz);
}

function getContextPath() {
	   return window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
}

async function onPageLoad(idQuiz) {
	quiz = idQuiz;
	console.log(quiz);
	questions = await getQuestions(idQuiz);
	setQuestionBody(indexQuestions);
	setAnswersBody(indexQuestions);
	setButtonsVisibility();
	setQuestionNumber();
}

function textToHtml(str) {
	str = str.replace(/\\n/g, "<br>");
	str = str.replace(/\\t/g, "&nbsp;");
	str = str.replace(/\\"/g, "\"");
	return str;
}

function onInputChange(input) {
	updateAnswered(input);
}

function onClickNext() {
	nextQuestion();
}

function onClickPrev() {
	prevQuestion();
}

function onSubmitForm() {
	endTest();
}

// todo da modificare con nuovo rest
let prepareTimer = async function (quizID) {
	fetch("rest/quiz/getTimer/" + quizID)
		.then(r => r.text())
		.then(s => {
			return Number.parseInt(s);
		})
		.then(sec => {
			console.log("Seconds: " + sec);
			startTimer(sec);
		});
};

function startTimer(duration) {
	let display = document.getElementById("timerDisplay");

	let timer = duration;
	let minutes, seconds
	setInterval(function () {
		minutes =  Math.floor(timer / 60);
		seconds = timer - minutes * 60;

		minutes = minutes < 10 ? "0" + minutes : minutes;
		seconds = seconds < 10 ? "0" + seconds : seconds;

		display.innerHTML = minutes + ":" + seconds;

		// save to db the timer in millis

		if (--timer < 0) {
			display.innerHTML = "TEMPO SCADUTO";
		}
	}, 1000);
}