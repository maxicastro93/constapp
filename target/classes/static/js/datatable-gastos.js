// Call the dataTables jQuery plugin
$(document).ready(function() {

  cargarGastos();

  $('#gastos').DataTable();
  actualizarEmailUsuario();
});

function actualizarEmailUsuario(){
    document.getElementById('txt-email-usuario').outerHTML = localStorage.email;
}


async function cargarGastos(){

      const request = await fetch('api/gastos', {
        method: 'GET',
        headers: getHeaders()
      });
      const listaGastos = await request.json();

      let gastosConcatenados = '';
      console.log(listaGastos);
      for (let gasto of listaGastos){
      let botonEliminar = '<a href="#" onclick="eliminarGasto('+gasto.id+')" class="btn btn-danger btn-circle"><i class="fas fa-trash"></i></a>';
      let gastoHTML = '<tr><td>'+gasto.id+'</td><td>'+gasto.fecha+'</td><td>'+gasto.tipo_gasto+'</td><td>'+gasto.nro_comprobante+'</td><td>'+gasto.caja_origen+'</td><td>'+'$'+gasto.monto+'</td><td>'+botonEliminar+'</td></tr>';
      gastosConcatenados += gastoHTML;
      }
      document.querySelector('#gastos tbody').outerHTML = gastosConcatenados ;
}
// funcion para autorizar al usuario a cada accion
function getHeaders(){
    return {
              'Accept': 'application/json',
              'Content-Type': 'application/json',
              'Authorization': localStorage.token
   };
}


async function eliminarGasto(id){
    if(!confirm('Desea eliminar el movimiento?')){
        return;
    }
    const request = await fetch('api/gastos/'+ id, {
            method: 'DELETE',
            headers: getHeaders()
          });
    location.reload();
}

