package constApp.web.Utils;

//ESTA CLASE VA A HACER LOS CALCULOS DE LOS SALDOS

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

}
