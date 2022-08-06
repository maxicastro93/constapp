package constApp.web.models;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cambioDivisa")
@EqualsAndHashCode
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CambioDivisa {

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

    @Getter @Setter @Column(name = "movimiento")
    private String movimiento; // "Pesos a Dolares" o "Dolares a Pesos"

    @Getter @Setter @Column(name = "importe_pesos")
    private BigDecimal importe_pesos;

    @Getter @Setter @Column(name = "importe_dolares")
    private BigDecimal importe_dolares;

    @Getter @Setter @Column(name = "tipo_de_cambio")
    private BigDecimal tipo_de_cambio; // a que valor de dolar se hizo el cambio

    private Long gasto_id;
    private Long ingreso_id;

}



