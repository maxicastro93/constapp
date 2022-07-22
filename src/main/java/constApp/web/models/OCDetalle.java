package constApp.web.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "ocdetalle")
@ToString
@EqualsAndHashCode
@Data
@AllArgsConstructor
//@NoArgsConstructor

public class OCDetalle {

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

    @Getter @Setter @Column(name = "detalle")
    private String detalle;

    @Getter @Setter @Column(name = "fechapago")
    private String fechaPago;

    @Getter @Setter @Column(name = "importe")
    private BigDecimal importe;

    @Getter @Setter @Column(name = "cargoadicional")
    private String cargoAdicional;

    @Getter @Setter @Column(name = "importeadicional")
    private BigDecimal impoteAdicional;

    @Getter @Setter @Column(name = "usuario_id")
    private String usuario_id;

    @Getter @Setter @Column(name = "empresa_id")
    private String empresa_id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "oc_id")
    private OrdenDeCompra oc_id;

    public OCDetalle(){
        this.detalle = "";
    }
}

