package constApp.web.models;

import lombok.*;

import javax.persistence.Column;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


@Entity
@Table(name = "ingreso")
@EqualsAndHashCode
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingreso {

    @Id
    @Getter
    @Setter
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter @Column(name = "fecha")
    private String fecha;

    @Column(name = "periodo")
    private String periodo;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "cliente_id")
    private Cliente cliente_id;

    @Getter @Setter @Column(name = "tipoIngreso")
    private String tipoIngreso; // cuota, anticipo, refuerzo, posesion

    @Getter @Setter @Column(name = "moneda")
    private String moneda;

    @Getter @Setter @Column(name = "monto")
    private BigDecimal monto;

    @Getter @Setter @Column(name = "observaciones")
    private String observaciones;

    @Getter @Setter @Column(name = "empresa_id")
    private String empresa_id;

    public void setPeriodo(String fecha) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        switch (calendar.get(Calendar.MONTH)){
            case 0:
                this.periodo = ("Enero "+ String.valueOf(calendar.get(Calendar.YEAR)));
                break;
            case 1:
                this.periodo = ("Febrero "+ String.valueOf(calendar.get(Calendar.YEAR)));
                break;
            case 2:
                this.periodo = ("Marzo "+ String.valueOf(calendar.get(Calendar.YEAR)));
                break;
            case 3:
                this.periodo = ("Abril "+ String.valueOf(calendar.get(Calendar.YEAR)));
                break;
            case 4:
                this.periodo = ("Mayo "+ String.valueOf(calendar.get(Calendar.YEAR)));
                break;
            case 5:
                this.periodo = ("Junio "+ String.valueOf(calendar.get(Calendar.YEAR)));
                break;
            case 6:
                this.periodo = ("Julio "+ String.valueOf(calendar.get(Calendar.YEAR)));
                break;
            case 7:
                this.periodo = ("Agosto "+ String.valueOf(calendar.get(Calendar.YEAR)));
                break;
            case 8:
                this.periodo = ("Septiembre "+ String.valueOf(calendar.get(Calendar.YEAR)));
                break;
            case 9:
                this.periodo = ("Octubre "+ String.valueOf(calendar.get(Calendar.YEAR)));
                break;
            case 10:
                this.periodo = ("Noviembre "+ String.valueOf(calendar.get(Calendar.YEAR)));
                break;
            case 11:
                this.periodo = ("Diciembre "+ String.valueOf(calendar.get(Calendar.YEAR)));
                break;
        }
    }


    public String getPeriodo(){
        return periodo;
    }

}
