
$('input').keyup(function(){ // run anytime the value changes
        calculaMontoTotal();
});



document.getElementById("detalle9").style.display = "none";
document.getElementById("detalle10").style.display = "none";
document.getElementById("detalle11").style.display = "none";
document.getElementById("detalle12").style.display = "none";
document.getElementById("detalle13").style.display = "none";
document.getElementById("detalle14").style.display = "none";

function createNewElement(){

            document.getElementById("detalle9").style.display = "flex";
            document.getElementById("detalle10").style.display = "flex";
            document.getElementById("detalle11").style.display = "flex";
            document.getElementById("detalle12").style.display = "flex";
            document.getElementById("detalle13").style.display = "flex";
            document.getElementById("detalle14").style.display = "flex";
}


//var listMontoDetalle = [];

//$('select').on('change', function () {
//    valorSelect = this.value;
//
//    $('#showPrice').val(thisPrice);
//
//});



function calculaMontoTotal(){

        var valor0 = Number($('#detalleMonto0').val());
        var valor1 = Number($('#detalleMonto1').val());
        var valor2 = Number($('#detalleMonto2').val());
        var valor3 = Number($('#detalleMonto3').val());
        var valor4 = Number($('#detalleMonto4').val());
        var valor5 = Number($('#detalleMonto5').val());
        var valor6 = Number($('#detalleMonto6').val());
        var valor7 = Number($('#detalleMonto7').val());
        var valor8 = Number($('#detalleMonto8').val());
        var valor9 = Number($('#detalleMonto9').val());
        var valor10 = Number($('#detalleMonto10').val());
        var valor11 = Number($('#detalleMonto11').val());
        var valor12 = Number($('#detalleMonto12').val());
        var valor13 = Number($('#detalleMonto13').val());
        var valor14 = Number($('#detalleMonto14').val());
        var descuento = Number($('#descuento').val());

        var resultado = (valor0 +valor1+ valor3+ valor4+ valor5 + valor6 + valor7+ valor8+ valor9+ valor10+ valor11+ valor12+ valor13)-descuento;
        var redondeado = resultado.toFixed(2);

        document.getElementById('montoTotal').value = redondeado;

}
