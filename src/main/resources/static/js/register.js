// Call the dataTables jQuery plugin
$(document).ready(function() {
    // on ready
});


async function regUsuer(){
    let data = {};
    data.nombre = document.getElementById('nombre').value;
    data.apellido = document.getElementById('apellido').value;
    data.email = document.getElementById('email').value;
    data.password = document.getElementById('password').value;

    console.log(data.nombre)
    let passwordRepeat = document.getElementById('passwordRepeat').value;

    if(passwordRepeat != data.password) {
        alert('Las contraseñas no son iguales');
        return
    }
    const requestUsers = await fetch('api/usuarios', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
    });

    alert("La cuenta fue creada con exito");
    window.location.href = 'login.html'
}