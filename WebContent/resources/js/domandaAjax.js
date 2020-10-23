let quiz = null;
let questions = [{id: 0, testo:"Ciao", answerType: "checkbox"}];
let indexQuestions = 0;
let answered = [];

// Get the answers to a given question id
async function getAnswers(idQuestion) {
	let path = getContextPath();
	let answers = await fetch(path + "/rest/risposte/domanda/" + idQuestion)
		.then(response => response.json());

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
	
	console.log(question.testo);
	let testo = textToHtml(JSON.stringify(question.testo));
	testo = testo.substring(1, testo.length - 1);
	
	questionBody.innerHTML = testo;
}

// Populate the section of the answers
async function setAnswersBody(index) {
	let answersBody = document.getElementById("answers_body");
	let answers = await getAnswers(questions[index].id);
	
	// Clean
	while(answersBody.firstChild) {
		answersBody.removeChild(answersBody.lastChild);
	}
	
	// Populate
	for(let i = 0; i < answers.length; i++) {
		answersBody.appendChild(buildAnswer(questions[index], answers[i]));
	}
}

function buildAnswer(question, answer) {
	let answerBlock = document.createElement("div");
	let input = document.createElement("input");
	input.type = question.answerType;
	if (input.type == "checkbox") {
		input.name = "answer_" + answer.letter;
	} else if (input.type == "radio"){
		input.name = "answer_radio";
	}
	input.id = input.name;
	input.value = answer.id;
	input.onchange = function () { onInputChange(this) };
	if (answered[indexQuestions] != undefined && answered[indexQuestions].includes(input.value)) {
		input.checked = true;
	}
	let label = document.createElement("label");
	label.htmlFor = input.id;
	label.innerHTML = answer.text;
	
	answerBlock.appendChild(input);
	answerBlock.appendChild(label);
	return answerBlock;
}

function updateAnswered(input) {
	if (answered[indexQuestions] == null) {
		answered[indexQuestions] = [];
	}
	if (input.type == "checkbox") {
		if (input.checked) {
			if (!answered[indexQuestions].includes(input.value)) {
				answered[indexQuestions].push(input.value);
			}
		} else {
			let index = answered[indexQuestions].indexOf(input.value);
			let newAnswered = [];
			for(let i = 0; i < answered[indexQuestions].length; i++) {
				if (i != index) {
					newAnswered.push(answered[indexQuestions][i]);
				}
			}
			answered[indexQuestions] = newAnswered;
		}
	} else if (input.type == "radio") {
		answered[indexQuestions][0] = input.value;
	}
	
	console.log(answered[indexQuestions]);
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
	console.log(quiz);
}

function getContextPath() {
	   return window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
}

async function onPageLoad(idQuiz) {
	quiz = idQuiz;
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


window.onload = async function () {
	let sec = fetch("Quiz/rest/quiz/getTimer/{quizId}")
		.then(r => r.text())
		.then(s => {
			return Number.parseInt(s);
		});
	let display = document.getElementById("timerDisplay");
	startTimer(sec, display);
};

function startTimer(duration, display) {
	let timer = duration*60;
	let minutes, seconds
	setInterval(function () {
		minutes = parseInt(timer / 60, 10);
		seconds = parseInt(timer % 60, 10);

		minutes = minutes < 10 ? "0" + minutes : minutes;
		seconds = seconds < 10 ? "0" + seconds : seconds;

		display.textContent = minutes + ":" + seconds;

		if (--timer < 0) {
			display.textContent = "TEMPO SCADUTO";
		}
	}, 1000);
}

