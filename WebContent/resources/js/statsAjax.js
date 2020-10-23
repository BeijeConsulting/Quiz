function loadStats(idUser){
    let passati = document.getElementById('esamiPassati');
    let fatti = document.getElementById('esamiFatti')
    let percentuale = document.getElementById('percentuale')
    console.log("Loading stats for user " + idUser)
    fetch("/Quiz/rest/quiz/getAll/" + idUser)
        .then(r => r.text())
        .then(n => {
            console.log("Esami fatti: " + n)
            fatti = n
            fatti.innerHTML = String(n)
        })
    fetch("/Quiz/rest/quiz/getPassed/" + idUser)
        .then(r => r.text())
        .then(n => {
            console.log("Esami passati: " + n)
            passati = n
            passati.innerHTML = String(n)
        })
        .then(() => {
            percentuale = (passati/fatti)*100
            percentuale.innerHTML = String(percentuale)
        })
}