let questions = [{id: 524, testo:"Ciao", answerType: "checkbox"}, {id: 525, testo:"Arrivederci", answerType: "radio"}]
let indexQuestions = 0;
let answered = [];

async function getAnswers(idQuestion) {
	let path = getContextPath();
	let answers = await fetch(path + "/rest/risposte/domanda/" + idQuestion)
		.then(response => response.json());
		
	return answers;
}

async function getQuestions(idQuiz) {
	let path = getContextPath();
	let questions = await fetch(path + "/rest/domande/quiz/" + idQuiz)
		.then(response => response.json());
		
	return questions;
}

function setQuestionBody(index) {
	let questionBody = document.getElementById("question_body");
	let question = questions[index];
	
	questionBody.innerHTML = question.testo;
}

async function setAnswersBody(idQuestion) {
	let answersBody = document.getElementById("answers_body");
	let answers = await getAnswers(idQuestion);
	buildAnswersBody(answers);
}

function buildAnswersBody(answers) {
	for(let i = 0; i < answers.length; i++) {
		answersBody.appendChild(buildAnswer(questions[0], answers[i]));
	}
}

function buildAnswer(question, answer) {
	let answerBlock = document.createElement("div");
	let input = document.createElement("input");
	input.type = question.answerType;
	input.name = "answer_" + answer.letter;
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

function addAnswer() {
	
}

function getContextPath() {
	   return window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
}

function onPageLoad() {
	setQuestionBody(0);
	setAnswersBody(524);
}

function onInputChange(input) {
	
}