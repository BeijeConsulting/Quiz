let domandeSelected = document.getElementById('totDomande');
let timerP = document.getElementById('timerP');
let timerSpan = document.getElementById('timer');

// Main functions which will run everytime the user changes his input. It will make a REST API request to
// get the number of questions chosen and will modify the page accordingly.
// NOTE: It just get a count, it won't get the actual questions
function updateQuestions(){
    let selected = document.querySelectorAll('input[type="checkbox"]:checked');
    if (selected.length === 0){
        clean();
    } else {
        let books = [], chapters = [];

        for (let select of selected){
            select = String(select.value).split("-");
            books.push(select[0]);
            chapters.push(select[1]);
        }
        books = books.join()
        chapters = chapters.join()

        let totDomande;
        fetch("/Quiz/rest/countQuestions/" + books + "/" + chapters + "")
            .then(r => r.json())
            .then(j => totDomande = j)
            .then(() => {
                domandeSelected.value = totDomande;
                domandeSelected.max = totDomande;
                updateTime(getTime(totDomande));
            });
        document.getElementById('submitButton').removeAttribute("disabled");
    }
}

// Util method to convert a time in seconds into a time in HH:mm:ss format
Number.prototype.toHHMMSS = function () {
    let sec = this;
    let hours   = Math.floor(sec / 3600);
    let minutes = Math.floor((sec - (hours * 3600)) / 60);
    let  seconds = sec - (hours * 3600) - (minutes * 60);

    if (hours   < 10) {hours   = "0"+hours;}
    if (minutes < 10) {minutes = "0"+minutes;}
    if (seconds < 10) {seconds = "0"+seconds;}
    return hours+':'+minutes+':'+seconds;
}

// Util method to clean various fields
function clean(){
    domandeSelected.value = 0;
    domandeSelected.max = 0;
    timerP.style.display = "none";
    document.getElementById('submitButton').setAttribute("disabled","disabled");
}

// Get the time in seconds depending on the number of questions given
function getTime(numberOfQuestions){
    return numberOfQuestions * 60 * 2
}

// Update the timer on the page
function updateTime(){
    let seconds = getTime(domandeSelected.value);
    if (seconds > 0){
        timerP.style.display = "";
    } else {
        timerP.style.display = "none";
    }
    timerSpan.innerText = seconds.toHHMMSS();
}