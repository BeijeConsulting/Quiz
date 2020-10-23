// cerca mail e verifica che esista
// se true, verifica la password
// se true, invia

let email = document.getElementById('login_email');
let pw = document.getElementById('login_password');

async function validateLogin(){
    console.log("Validating")
    if (!validateEmail()){
        email.className += "is-invalid";
        event.preventDefault();
        event.stopPropagation();
        return false;
    } else {
        let user = await getUser();
        if (user.length === 0){
            pw.className += "is-invalid";
            this.preventDefault();
            this.stopPropagation();
            return false;
        } else return true;
    }
}

function validateEmail(){
    fetch("/Quiz/rest/login/getUserByEmail/" + email.value)
        .then(r => r.json())
        .then(k => {return k.success})
}

function getUser(){
    fetch("/Quiz/rest/login/getUser/" + email.value + "-" + pw.value)
        .then(r => r.json())
        .then(k => {return k})
}