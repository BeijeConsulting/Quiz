let passati = document.getElementById('esamiPassati').value;
let fatti = document.getElementById('esamiFatti').value
let percentuale = document.getElementById('percentuale').value

function loadStats(idUser){
    fetch("/Quiz/rest/quiz/getAll/" + idUser)
        .then(r => r.text())
        .then(n => fatti = n)
    fetch("/Quiz/rest/quiz/getPassed/" + idUser)
        .then(r => r.text())
        .then(n => passati = n)
        .then(() => percentuale = (passati/fatti)*100)
        .then(() => {})
}