// Call the dataTables jQuery plugin
$(document).ready(function() {

  cargarUsuarios();

  $('#usuarios').DataTable();
  actualizarEmailUsuario();
});

function actualizarEmailUsuario(){
    document.getElementById('txt-email-usuario').outerHTML = localStorage.email;

}


async function cargarUsuarios(){

      const request = await fetch('api/usuarios', {
        method: 'GET',
        headers: getHeaders()
      });
      const listaUsuarios = await request.json();

      let usuariosConcatenados = '';
      console.log(listaUsuarios);
      for (let usuario of listaUsuarios){
      let botonEliminar = '<a href="#" onclick="eliminarUsuario('+usuario.id+')" class="btn btn-danger btn-circle"><i class="fas fa-trash"></i></a>';
      let usuarioHTML = '<tr><td>'+usuario.id+'</td><td>'+usuario.nombre+' '+usuario.apellido+'</td><td>'+usuario.email+'</td><td>'+usuario.telefono+'</td><td>'+usuario.empresa+'</td><td>'+botonEliminar+'</td></tr>';
      usuariosConcatenados += usuarioHTML;
      }
      document.querySelector('#usuarios tbody').outerHTML = usuariosConcatenados ;
}
// funcion para autorizar al usuario a cada accion
function getHeaders(){
    return {
              'Accept': 'application/json',
              'Content-Type': 'application/json',
              'Authorization': localStorage.token
   };
}


async function eliminarUsuario(id){
    if(!confirm('Desea eliminar el usuario?')){
        return;
    }
    const request = await fetch('api/usuarios/'+ id, {
            method: 'DELETE',
            headers: getHeaders()
          });
    location.reload();
}

