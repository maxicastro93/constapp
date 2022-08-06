
//document.getElementById("pesosDolares").style.display = "none";
//document.getElementById("dolaresPesos").style.display = "none";
var valorSelect;

$('select').on('change', function () {
    valorSelect = this.value;

    $('#showPrice').val(thisPrice);

});

$('input').keyup(function(){ // run anytime the value changes
    if (valorSelect === 'Pesos a Dolares')
        getPesosADolares();

    else
        getDolaresAPesos();
});



function getDolaresAPesos(){

        var thirdValue = Number($('#base').val());
        var fourthValue = Number($('#tc').val());

        var resultado2 = thirdValue * fourthValue;
        var redondeado = resultado2.toFixed(2);

        document.getElementById('resultado').value = redondeado;

}

function getPesosADolares(){

        var firstValue = Number($('#base').val()); // get value of field
        var secondValue = Number($('#tc').val()); // convert it to a float
        var resultado1 = firstValue / secondValue;
        var redondeado = resultado1.toFixed(2);

        document.getElementById('resultado').value = redondeado;
}
