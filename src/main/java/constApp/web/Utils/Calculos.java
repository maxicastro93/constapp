package constApp.web.Utils;

//ESTA CLASE VA A HACER LOS CALCULOS DE LOS SALDOS

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
public class Calculos {

    @Getter @Setter
    private BigDecimal cuentaDolares;

    @Getter @Setter
    private BigDecimal cuentaPesos;


    public String getPeriodoActual() throws ParseException {
        Calendar calendar = Calendar.getInstance();

        switch (calendar.get(Calendar.MONTH)) {
            case 0:
                return ("Enero " + String.valueOf(calendar.get(Calendar.YEAR)));
            case 1:
                return ("Febrero " + String.valueOf(calendar.get(Calendar.YEAR)));
            case 2:
                return ("Marzo " + String.valueOf(calendar.get(Calendar.YEAR)));
            case 3:
                return ("Abril " + String.valueOf(calendar.get(Calendar.YEAR)));
            case 4:
                return ("Mayo " + String.valueOf(calendar.get(Calendar.YEAR)));
            case 5:
                return ("Junio " + String.valueOf(calendar.get(Calendar.YEAR)));
            case 6:
                return ("Julio " + String.valueOf(calendar.get(Calendar.YEAR)));
            case 7:
                return ("Agosto " + String.valueOf(calendar.get(Calendar.YEAR)));
            case 8:
                return ("Septiembre " + String.valueOf(calendar.get(Calendar.YEAR)));
            case 9:
                return ("Octubre " + String.valueOf(calendar.get(Calendar.YEAR)));
            case 10:
                return ("Noviembre " + String.valueOf(calendar.get(Calendar.YEAR)));
            case 11:
                return ("Diciembre " + String.valueOf(calendar.get(Calendar.YEAR)));
        }
        return "";
    }

    public String getPeriodoFromFecha(String fecha) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        switch (calendar.get(Calendar.MONTH)) {
            case 0:
                return ("Enero " + String.valueOf(calendar.get(Calendar.YEAR)));
            case 1:
                return ("Febrero " + String.valueOf(calendar.get(Calendar.YEAR)));
            case 2:
                return ("Marzo " + String.valueOf(calendar.get(Calendar.YEAR)));
            case 3:
                return ("Abril " + String.valueOf(calendar.get(Calendar.YEAR)));
            case 4:
                return ("Mayo " + String.valueOf(calendar.get(Calendar.YEAR)));
            case 5:
                return ("Junio " + String.valueOf(calendar.get(Calendar.YEAR)));
            case 6:
                return ("Julio " + String.valueOf(calendar.get(Calendar.YEAR)));
            case 7:
                return ("Agosto " + String.valueOf(calendar.get(Calendar.YEAR)));
            case 8:
                return ("Septiembre " + String.valueOf(calendar.get(Calendar.YEAR)));
            case 9:
                return ("Octubre " + String.valueOf(calendar.get(Calendar.YEAR)));
            case 10:
                return ("Noviembre " + String.valueOf(calendar.get(Calendar.YEAR)));
            case 11:
                return ("Diciembre " + String.valueOf(calendar.get(Calendar.YEAR)));
        }
        return "";
    }

    public ArrayList<String> get12PeriodosAtras() {
        Calendar calendar = Calendar.getInstance();
        ArrayList<String> listPeriodos = new ArrayList<>();

        listPeriodos.add("Enero " + String.valueOf(calendar.get(Calendar.YEAR)));
        listPeriodos.add("Febrero " + String.valueOf(calendar.get(Calendar.YEAR)));
        listPeriodos.add("Marzo " + String.valueOf(calendar.get(Calendar.YEAR)));
        listPeriodos.add("Abril " + String.valueOf(calendar.get(Calendar.YEAR)));
        listPeriodos.add("Mayo " + String.valueOf(calendar.get(Calendar.YEAR)));
        listPeriodos.add("Junio " + String.valueOf(calendar.get(Calendar.YEAR)));
        listPeriodos.add("Julio " + String.valueOf(calendar.get(Calendar.YEAR)));
        listPeriodos.add("Agosto " + String.valueOf(calendar.get(Calendar.YEAR)));
        listPeriodos.add("Septiembre " + String.valueOf(calendar.get(Calendar.YEAR)));
        listPeriodos.add("Octubre " + String.valueOf(calendar.get(Calendar.YEAR)));
        listPeriodos.add("Noviembre " + String.valueOf(calendar.get(Calendar.YEAR)));
        listPeriodos.add("Diciembre " + String.valueOf(calendar.get(Calendar.YEAR)));

        ArrayList<String> listOrdenada = new ArrayList<>();


        switch (calendar.get(Calendar.MONTH)) {
            case 0:
                listOrdenada.add("Enero " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Diciembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Noviembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Octubre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Septiembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Agosto " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Julio " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Junio " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Mayo " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Abril " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Marzo " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Febrero " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                return listOrdenada;
            case 1:
                listOrdenada.add("Febrero " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Enero " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Diciembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Noviembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Octubre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Septiembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Agosto " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Julio " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Junio " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Mayo " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Abril " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Marzo " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                return listOrdenada;
            case 2:
                listOrdenada.add("Marzo " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Febrero " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Enero " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Diciembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Noviembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Octubre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Septiembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Agosto " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Julio " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Junio " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Mayo " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Abril " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                return listOrdenada;
            case 3:
                listOrdenada.add("Abril " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Marzo " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Febrero " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Enero " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Diciembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Noviembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Octubre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Septiembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Agosto " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Julio " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Junio " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Mayo " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                return listOrdenada;
            case 4:
                listOrdenada.add("Junio " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Mayo " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Abril " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Marzo " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Febrero " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Enero " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Diciembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Noviembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Octubre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Septiembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Agosto " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Julio " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                return listOrdenada;
            case 5:
                listOrdenada.add("Julio " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Junio " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Mayo " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Abril " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Marzo " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Febrero " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Enero " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Diciembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Noviembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Octubre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Septiembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Agosto " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                return listOrdenada;
            case 6:
                listOrdenada.add("Julio " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Junio " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Mayo " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Abril " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Marzo " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Febrero " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Enero " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Diciembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Noviembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Octubre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Septiembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Agosto " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                return listOrdenada;
            case 7:
                listOrdenada.add("Agosto " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Julio " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Junio " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Mayo " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Abril " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Marzo " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Febrero " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Enero " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Diciembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Noviembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Octubre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Septiembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                return listOrdenada;
            case 8:
                listOrdenada.add("Septiembre " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Agosto " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Julio " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Junio " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Mayo " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Abril " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Marzo " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Febrero " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Enero " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Diciembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Noviembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Octubre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                return listOrdenada;
            case 9:
                listOrdenada.add("Octubre " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Septiembre " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Agosto " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Julio " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Junio " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Mayo " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Abril " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Marzo " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Febrero " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Enero " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Diciembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Noviembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                return listOrdenada;
            case 10:
                listOrdenada.add("Noviembre " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Octubre " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Septiembre " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Agosto " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Julio " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Junio " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Mayo " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Abril " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Marzo " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Febrero " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Enero " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Diciembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                return listOrdenada;
            case 11:
                listOrdenada.add("Diciembre " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Noviembre " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Octubre " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Septiembre " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Agosto " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Julio " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Junio " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Mayo " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Abril " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Marzo " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Febrero " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Enero " + String.valueOf(calendar.get(Calendar.YEAR)));
                return listOrdenada;
        }

        return listOrdenada;
    }

    public ArrayList<String> get12PeriodosAtrasFromFecha(String fecha) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        ArrayList<String> listPeriodos = new ArrayList<>();

        listPeriodos.add("Enero " + String.valueOf(calendar.get(Calendar.YEAR)));
        listPeriodos.add("Febrero " + String.valueOf(calendar.get(Calendar.YEAR)));
        listPeriodos.add("Marzo " + String.valueOf(calendar.get(Calendar.YEAR)));
        listPeriodos.add("Abril " + String.valueOf(calendar.get(Calendar.YEAR)));
        listPeriodos.add("Mayo " + String.valueOf(calendar.get(Calendar.YEAR)));
        listPeriodos.add("Junio " + String.valueOf(calendar.get(Calendar.YEAR)));
        listPeriodos.add("Julio " + String.valueOf(calendar.get(Calendar.YEAR)));
        listPeriodos.add("Agosto " + String.valueOf(calendar.get(Calendar.YEAR)));
        listPeriodos.add("Septiembre " + String.valueOf(calendar.get(Calendar.YEAR)));
        listPeriodos.add("Octubre " + String.valueOf(calendar.get(Calendar.YEAR)));
        listPeriodos.add("Noviembre " + String.valueOf(calendar.get(Calendar.YEAR)));
        listPeriodos.add("Diciembre " + String.valueOf(calendar.get(Calendar.YEAR)));

        ArrayList<String> listOrdenada = new ArrayList<>();


        switch (calendar.get(Calendar.MONTH)) {
            case 0:
                listOrdenada.add("Enero " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Diciembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Noviembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Octubre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Septiembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Agosto " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Julio " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Junio " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Mayo " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Abril " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Marzo " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Febrero " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                return listOrdenada;
            case 1:
                listOrdenada.add("Febrero " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Enero " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Diciembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Noviembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Octubre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Septiembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Agosto " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Julio " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Junio " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Mayo " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Abril " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Marzo " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                return listOrdenada;
            case 2:
                listOrdenada.add("Marzo " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Febrero " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Enero " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Diciembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Noviembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Octubre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Septiembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Agosto " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Julio " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Junio " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Mayo " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Abril " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                return listOrdenada;
            case 3:
                listOrdenada.add("Abril " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Marzo " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Febrero " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Enero " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Diciembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Noviembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Octubre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Septiembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Agosto " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Julio " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Junio " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Mayo " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                return listOrdenada;
            case 4:
                listOrdenada.add("Junio " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Mayo " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Abril " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Marzo " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Febrero " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Enero " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Diciembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Noviembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Octubre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Septiembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Agosto " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Julio " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                return listOrdenada;
            case 5:
                listOrdenada.add("Julio " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Junio " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Mayo " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Abril " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Marzo " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Febrero " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Enero " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Diciembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Noviembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Octubre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Septiembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Agosto " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                return listOrdenada;
            case 6:
                listOrdenada.add("Julio " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Junio " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Mayo " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Abril " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Marzo " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Febrero " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Enero " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Diciembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Noviembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Octubre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Septiembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Agosto " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                return listOrdenada;
            case 7:
                listOrdenada.add("Agosto " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Julio " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Junio " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Mayo " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Abril " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Marzo " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Febrero " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Enero " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Diciembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Noviembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Octubre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Septiembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                return listOrdenada;
            case 8:
                listOrdenada.add("Septiembre " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Agosto " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Julio " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Junio " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Mayo " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Abril " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Marzo " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Febrero " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Enero " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Diciembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Noviembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Octubre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                return listOrdenada;
            case 9:
                listOrdenada.add("Octubre " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Septiembre " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Agosto " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Julio " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Junio " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Mayo " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Abril " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Marzo " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Febrero " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Enero " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Diciembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                listOrdenada.add("Noviembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                return listOrdenada;
            case 10:
                listOrdenada.add("Noviembre " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Octubre " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Septiembre " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Agosto " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Julio " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Junio " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Mayo " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Abril " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Marzo " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Febrero " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Enero " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Diciembre " + String.valueOf(calendar.get(Calendar.YEAR)-1));
                return listOrdenada;
            case 11:
                listOrdenada.add("Diciembre " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Noviembre " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Octubre " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Septiembre " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Agosto " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Julio " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Junio " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Mayo " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Abril " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Marzo " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Febrero " + String.valueOf(calendar.get(Calendar.YEAR)));
                listOrdenada.add("Enero " + String.valueOf(calendar.get(Calendar.YEAR)));
                return listOrdenada;
        }
        return listOrdenada;
    }

}
