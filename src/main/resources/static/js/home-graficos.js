
function primerGraficoDashboard(listado){

    // Load the Visualization API and the corechart package.
    google.charts.load('current', {'packages':['corechart']});

    // Set a callback to run when the Google Visualization API is loaded.
    google.charts.setOnLoadCallback(drawChartUno(listado));


}

function segundoGraficoDashboard(listado){
        // Load the Visualization API and the corechart package.
        google.charts.load('current', {'packages':['corechart']});

        // Set a callback to run when the Google Visualization API is loaded.
        google.charts.setOnLoadCallback(drawChartDos(listado));

}

function drawChartUno(listGraficoGastosPesosDolares) {

        // Create the data table.
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Periodos');
        data.addColumn('number', 'Gastos en Pesos');
        data.addColumn('number', 'Gastos en Dolares');

        data.addRows([[listGraficoGastosPesosDolares]]);

        // Set chart options
        var options = {
          title: 'Gastos',
          width: '100%',
          height: 400
        };

        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.ColumnChart(document.getElementById('grafico_columnas_gastos'));
        chart.draw(data, options);
    }


// Callback that creates and populates a data table,
// instantiates the pie chart, passes in the data and
// draws it.
function drawChartDos(listGraficoIngresosPesosDolares) {

    // Create the data table.
    var data = new google.visualization.DataTable();
    data.addColumn('string', 'Periodos');
    data.addColumn('number', 'Ingresos en Pesos');
    data.addColumn('number', 'Ingresos en Dolares');

    data.addRows([[listGraficoIngresosPesosDolares]]);


    // Set chart options

    var options = {
      title: 'Ingresos',
      width: '100%',
      height: 400
    };

    // Instantiate and draw our chart, passing in some options.
    var chart = new google.visualization.ColumnChart(document.getElementById('grafico_columnas_ingresos'));
    chart.draw(data, options);
}
