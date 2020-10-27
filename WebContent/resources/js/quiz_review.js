let quiz = null;
let questions = [{id: 0, testo:"Ciao", answerType: "checkbox"}];
let indexQuestions = 0;
let answered = [];

// Get the answers to a given question id
async function getAnswers(idQuestion) {
	let path = getContextPath();
	return await fetch(path + "/rest/risposte/domanda/" + idQuestion)
		.then(response => response.json());
}

// Get the questions to a given quiz id
async function getQuestions(idQuiz) {
	let path = getContextPath();
	return await fetch(path + "/rest/domande/quiz/" + idQuiz)
		.then(response => response.json());
}

function setQuestionNumber() {
	let number = document.getElementById("question_number");
	number.innerHTML = String(indexQuestions + 1);
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
	let label = document.createElement("label");
	let formattedText = textToHtml(JSON.stringify(answer.text));
	formattedText = formattedText.substring(1, formattedText.length - 1);
    formattedText = answer.letter + "&nbsp;" + formattedText 
	label.innerHTML = formattedText;
	
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
		setCorrectAnswer(indexQuestions);
		setGivenAnswer(quiz, indexQuestions);
		setExplanation(indexQuestions);
	}
}

function prevQuestion() {
	if (indexQuestions > 0) {
		indexQuestions--;
		setQuestionBody(indexQuestions);
		setAnswersBody(indexQuestions);
		setButtonsVisibility();
		setQuestionNumber();
		
			setCorrectAnswer(indexQuestions);
	setGivenAnswer(quiz, indexQuestions);
	setExplanation(indexQuestions);
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
	console.log("Questions: " + questions)
	setQuestionBody(indexQuestions);
	setAnswersBody(indexQuestions);

//-------------------	
	setCorrectAnswer(indexQuestions);
	setGivenAnswer(quiz, indexQuestions);
	setExplanation(indexQuestions);
//-------------------

	setButtonsVisibility();
	setQuestionNumber();
}

//----------------
async function getGivenAnswer(idQuiz,indexDomanda) {
	let path = getContextPath();
	let rispostaData = await fetch(path + "/rest/risposta_data/" + idQuiz +"/" + questions[indexDomanda].id).then(response => response.json());
	return rispostaData;
}

async function setGivenAnswer(idQuiz, indexDomanda) {
	let rispostaData = await getGivenAnswer(idQuiz, indexDomanda);
	let given = document.getElementById("given_answer");
	
	let testo = textToHtml(JSON.stringify(rispostaData.risposta));
	testo = testo.substring(1, testo.length - 1);
	
	given.innerHTML = "Risposta data: " + testo;
}

function setExplanation(index) {
	let explanationBody = document.getElementById("explanation_body");
	let question = questions[index];
	
	let explanation = textToHtml(JSON.stringify(question.spiegazione));
	explanation = explanation.substring(1, explanation.length - 1);
	
	explanationBody.innerHTML = explanation;
}

// Shows the question correct answer -------------------
function setCorrectAnswer(index) {
	let questionBody = document.getElementById("correct_answer");
	let question = questions[index];
	
	console.log(question.risposta_esatta);
	let testo = textToHtml(JSON.stringify(question.risposta_esatta));
	testo = testo.substring(1, testo.length - 1);
	
	questionBody.innerHTML = "Risposta corretta: " +  testo;
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