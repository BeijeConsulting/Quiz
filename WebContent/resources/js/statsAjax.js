function loadStats(idUser){
    let passati, fatti, percentuale
    console.log("Loading stats for user " + idUser)
    fetch("/Quiz/rest/quiz/getAll/" + idUser)
        .then(r => r.text())
        .then(n => {
            console.log("Esami fatti: " + n)
            fatti = n
            document.getElementById('esamiFatti').innerHTML += String(n)
        })
    fetch("/Quiz/rest/quiz/getPassed/" + idUser)
        .then(r => r.text())
        .then(n => {
            console.log("Esami passati: " + n)
            passati = n
            document.getElementById('esamiPassati').innerHTML += String(n)
        })
        .then(() => {
            percentuale = (passati/fatti)*100
            console.log(percentuale)
            document.getElementById('percentuale').innerHTML += String(percentuale) + "%"
        })
}