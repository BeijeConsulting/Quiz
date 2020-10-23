let questions = [{id: 524, text:"Ciao", answerType: "checkbox"}, {id: 525, text:"Arrivederci", answerType: "radio"}];
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

// Shows the question
function setQuestionBody(index) {
	let questionBody = document.getElementById("question_body");
	let question = questions[index];
	
	questionBody.innerHTML = question.text;
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
	let label = document.createElement("label");
	label.htmlFor = input.id;
	label.innerHTML = answer.text;
	
	answerBlock.appendChild(input);
	answerBlock.appendChild(label);
	return answerBlock;
}

function updateAnswered(input) {
	if (input.type == "checkbox") {
		if (input.checked) {
			if (!answered.includes(input.value)) {
				answered.push(input.value);
			}
		} else {
			let index = answered.indexOf(input.value);
			let newAnswered = [];
			for(let i = 0; i < answered.length; i++) {
				if (i != index) {
					newAnswered.push(answered[i]);
				}
			}
			answered = newAnswered;
		}
	} else if (input.type == "radio") {
		answered[0] = input.value;
	}
}

function nextQuestion() {
	if (indexQuestions < questions.length - 1) {
		indexQuestions++;
		setQuestionBody(indexQuestions);
		setAnswersBody(indexQuestions);
		setButtonsVisibility();
	}
}

function prevQuestion() {
	if (indexQuestions > 0) {
		indexQuestions--;
		setQuestionBody(indexQuestions);
		setAnswersBody(indexQuestions);
		setButtonsVisibility();
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

function getContextPath() {
	   return window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
}

function onPageLoad() {
	setQuestionBody(indexQuestions);
	setAnswersBody(indexQuestions);
	setButtonsVisibility();
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