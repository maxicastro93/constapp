// PROVEEDOR, LISTADO DE PROVEEDORES A QUIENES LE COMPRAN.
// DEBERA TENER LOS DATOS BASICOS, Y PODER FILTRAR CON LA BASE DE DATOS LAS COMPRAS Y LAS ORDENES DE COMPRA QUE LE ASIGNARON
// A EL PROVEEDOR SEGUN NOMBRE O ID DEL PROVEEDOR

// CLASE GASTO O PAGO, REGISTRARA EL PAGO A PROVEEDORES, O CUALQUIER OTRO TIPO DE GASTO

package constApp.web.models;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "cliente")
@EqualsAndHashCode
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    // se utiliza la anotacion getter y setter para reemplazar los get y set
    //de cada variable
    // la anotacion Column es para indicarle a que columna de la tabla
    //de la base de datos es la que va
    @Id
    @Getter
    @Setter
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter @Column(name = "nombre")
    private String nombre;

    @Getter @Setter @Column(name = "domicilio")
    private String domicilio;

    @Getter @Setter @Column(name = "telefono")
    private String telefono;

    @Getter @Setter @Column(name = "dia_de_pago")
    private String dia_de_pago;

    @Getter @Setter @Column(name = "anticipo")
    private BigDecimal anticipo;

    @Getter @Setter @Column(name = "cant_cuotas")
    private BigDecimal cant_cuotas;

    @Getter @Setter @Column(name = "monto_cuota")
    private BigDecimal monto_cuota;

    @Getter @Setter @Column(name = "refuerzo")
    private BigDecimal refuerzo;

    @Getter @Setter @Column(name = "posesion")
    private BigDecimal posesion;

    @Getter @Column(name = "saldo_pendiente")
    private BigDecimal saldo_pendiente;

    @OneToMany(mappedBy = "cliente_id", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @Getter @Setter
    private List<Ingreso> pagosCliente;

    @Getter @Setter @Column(name = "interes_diario")
    private Double interes_diario;

    @Getter @Setter @Column(name = "obra")
    private String obra;

    @Getter @Setter @Column(name = "empresa_id")
    private String empresa_id;


    public void crearSaldo_pendiente(){
        BigDecimal saldoAux = new BigDecimal(0.0);
        BigDecimal cuotaAux = new BigDecimal(0.0);
        saldoAux = saldoAux.add(this.refuerzo);
        saldoAux = saldoAux.add(this.anticipo);
        saldoAux = saldoAux.add(this.posesion);
        cuotaAux = this.monto_cuota.multiply(this.cant_cuotas);
        saldoAux = saldoAux.add(cuotaAux);
        this.saldo_pendiente = saldoAux;
    }

    public void actualizar_saldoPendiente(){
        crearSaldo_pendiente();
        if(getPagosCliente() != null) {
            List<Ingreso> ingresoList = this.getPagosCliente();
            BigDecimal saldoAux = new BigDecimal(0.0);
            for (Ingreso ing : ingresoList){
                saldoAux = saldoAux.add(ing.getMonto());
            }
            this.saldo_pendiente = this.saldo_pendiente.subtract(saldoAux);
        }
    }
}






