$(document).ready(function() {
    // on ready
});


async function initSesion(){
    let data = {};
    data.email = document.getElementById('email').value;
    data.password = document.getElementById('password').value;


    const requestUsers = await fetch('api/login', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
    });

    const response = await requestUsers.text();

    if(response != 'FAIL'){
        localStorage.token = response;
        localStorage.email = data.email;
        window.location.href = 'usuarios.html'
    } else {
        alert("Las credenciales no son correctas, Intente de nuevo");
    }
}