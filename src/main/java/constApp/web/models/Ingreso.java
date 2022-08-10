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

    @Getter @Setter @Column(name = "diasAtraso")
    private Integer diasAtraso;

    @Getter @Setter @Column(name = "montoInteres")
    private BigDecimal montoInteres;

    @Getter @Setter @Column(name = "monto")
    private BigDecimal monto;

    @Getter @Setter @Column(name = "obra")
    private String obra;

    @Getter @Setter @Column(name = "observaciones")
    private String observaciones;

    @Getter @Setter @Column(name = "empresa_id")
    private String empresa_id;

    @Getter @Setter @Column(name = "usuario")
    private String usuario;

}
