
$('input').keyup(function(){ // run anytime the value changes
        calculaMontoTotal();
});


function calculaMontoTotal(){


        var subtotal = Number($('#subtotal').val());
        var interes = Number($('#interes').val());

        var resultado = subtotal+interes;
        var redondeado = resultado.toFixed(2);

        document.getElementById('total').value = redondeado;

}
