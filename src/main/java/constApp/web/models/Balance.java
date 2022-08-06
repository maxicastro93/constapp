package constApp.web.models;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "balance")
@EqualsAndHashCode
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@NonNull
public class Balance {
    @Id
    @Getter
    @Setter
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter @Column(name = "fecha")
    private String fecha;

    @Getter @Setter @Column(name = "periodo")
    private String periodo;

    @Getter @Setter @Column(name = "tipo_movimiento")
    private String tipoMovimiento;

    @Getter @Setter @Column(name = "movimiento_id")
    private Long movimientoId;

    @Getter @Setter @Column(name = "motivo")
    private String motivo;

    @Getter @Setter @Column(name = "moneda_movimiento")
    private String moneda_movimiento;

    @Getter @Setter @Column(name = "importe_movimiento")
    private BigDecimal importe_movimiento;

    @Getter @Setter @Column(name = "importe_recibido")
    private BigDecimal importe_recibido; // solo utilizado para Cambio de divisas

    @Getter @Setter @Column(name = "tipo_cambio")
    private BigDecimal tipo_cambio; // solo utilizado para Cambio de divisas

    @Getter @Setter @Column(name = "cliente_nombre")
    private String cliente_nombre;

    @Getter @Setter @Column(name = "proveedor_nombre")
    private String proveedor_nombre;

    @Getter @Setter @Column(name = "proyecto")
    private String proyecto;

    @Getter @Setter @Column(name = "obs")
    private String obs;

    public void setBalanceNull(){
        this.fecha= "";
        this.periodo = "";
        this.tipoMovimiento = "";
        this.motivo= "";
        this.movimientoId= Long.valueOf(0);
        this.moneda_movimiento= "";
        this.importe_recibido= BigDecimal.valueOf(0.0);
        this.importe_movimiento= BigDecimal.valueOf(0.0);
        this.tipo_cambio= BigDecimal.valueOf(0.0);
        this.cliente_nombre= "";
        this.proveedor_nombre= "";
        this.proyecto= "";
        this.obs = "Eliminado";

    }
//    @Getter @Setter @Column(name = "saldo_pesos")
//    private BigDecimal saldo_pesos;
//
//    @Getter @Setter @Column(name = "saldo_dolares")
//    private BigDecimal saldo_dolares;
//
//
//    public void ingreso_saldoDolares(BigDecimal movimientoDolares){
//        this.saldo_dolares.add(movimientoDolares);
//    }
//    public void ingreso_saldoPesos(BigDecimal movimientoPesos){
//        this.saldo_pesos.add(movimientoPesos);
//    }
//    public void gasto_saldoDolares(BigDecimal movimientoDolares){
//        this.saldo_dolares.subtract(movimientoDolares);
//    }
//    public void gasto_saldoPesos(BigDecimal movimientoPesos){
//        this.saldo_pesos.subtract(movimientoPesos);
//    }

}
