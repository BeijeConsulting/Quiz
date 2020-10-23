// cerca mail e verifica che esista
// se true, verifica la password
// se true, invia

let email = document.getElementById('login_email');
let pw = document.getElementById('login_password');
let user;

async function validateEmail(){
    event.preventDefault();
    fetch("/Quiz/rest/login/getUserByEmail/" + email.value + "/ok")
        .then(r => r.text())
        .then(k => {
            if (String(k) === ""){
                console.log("No user")
                email.classList.remove("is-valid");
                email.classList.add("is-invalid");
                return false;
            } else {
                console.log("User trovato")
                email.classList.remove("is-invalid");
                email.classList.add("is-valid");
                return true;
            }
        })
}