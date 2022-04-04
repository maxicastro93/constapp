// Call the dataTables jQuery plugin
$(document).ready(function() {

  // on ready
});

async function registrarUsuarios(){
      let datosUsuario = {};
      datosUsuario.nombre = document.getElementById('txtNombre').value;
      datosUsuario.apellido = document.getElementById('txtApellido').value;;
      datosUsuario.telefono = document.getElementById('txtTelefono').value;
      datosUsuario.email = document.getElementById('txtEmail').value;
      datosUsuario.empresa = document.getElementById('txtEmpresa').value;
      datosUsuario.password = document.getElementById('txtPassword').value;


      let repetirPassword = document.getElementById('txtRepetirPassword').value;
      if (datosUsuario.password != repetirPassword){
        alert('La contraseña ingresada es diferente');
        return;
      }
      if(datosUsuario.nombre == ""
      ||datosUsuario.apellido== ""
      ||datosUsuario.telefono== ""
      ||datosUsuario.email== ""
      ||datosUsuario.empresa== ""
      ||datosUsuario.password== ""
      ||repetirPassword == ""){
        alert('Faltan completar campos!');
        return;
      }

      const request = await fetch('api/usuarios', {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
           body: JSON.stringify(datosUsuario)
      });

      alert("Cuenta creada con exito");
      window.location.href = 'login.html'

}


