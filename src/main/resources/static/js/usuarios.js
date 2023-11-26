// Call the dataTables jQuery plugin
$(document).ready(function() {
  loadUsuer();
  $('#usuarios').DataTable();
});


async function loadUsuer(){
    const requestUsers = await fetch('api/usuarios', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
    });
    const users = await requestUsers.json();
    let listUsers = '';
    for (let user of users) {
    let btnDelete = '<a href="#" onclick="deleteUser(' + user.id + ')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>'
    let templateUser = '<tr><td>' + user.id + '</td><td>' + user.nombre + ' ' +  user.apellido +
        '</td><td>' + user.email + '</td><td>' + (user.telefono == null ? '-' : user.telefono) +
        '</td><td>' + btnDelete + '</td></tr>';
    listUsers += templateUser;
    }

    console.log(users);


    document.querySelector('#usuarios tbody').outerHTML = listUsers
}

async function deleteUser(id) {
    if(!confirm('¿Desea eliminar este usuario?')){
     return
    }
    const requestUsers = await fetch('api/usuarios/' + id, {
      method: 'DELETE',
      headers: {
       'Accept': 'application/json',
       'Content-Type': 'application/json'
      }
    });
    location.reload()
}