// Call the dataTables jQuery plugin
$(document).ready(function() {

  // on ready
});

async function iniciarSesion(){
      let datosUsuario = {};
      datosUsuario.email = document.getElementById('txtEmail').value;
      datosUsuario.password = document.getElementById('txtPassword').value;

      const request = await fetch('api/login', {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
           body: JSON.stringify(datosUsuario)
      });

      const respuesta = await request.text();
      if(respuesta != "FAIL"){
        localStorage.token = respuesta;
        localStorage.email = datosUsuario.email;
        window.location.href = 'index.html'
      } else{
        alert("Usuario o Contrasena incorrectos, intente nuevamente")
      }


}


