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
public class Balance {
    @Id
    @Getter
    @Setter
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter @Column(name = "fecha")
    private String fecha;

    @Getter @Setter @Column(name = "tipo_movimiento")
    private String tipo_movimiento;

    @Getter @Setter @Column(name = "id_movimiento")
    private Long id_movimiento;

    @Getter @Setter @Column(name = "motivo")
    private String motivo;

    @Getter @Setter @Column(name = "importe_movimiento")
    private BigDecimal importe_movimiento;

    @Getter @Setter @Column(name = "saldo_pesos")
    private BigDecimal saldo_pesos;

    @Getter @Setter @Column(name = "saldo_dolares")
    private BigDecimal saldo_dolares;



}
