// CLASE GASTO O PAGO, REGISTRARA EL PAGO A PROVEEDORES, O CUALQUIER OTRO TIPO DE GASTO

package constApp.web.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "gastos")
@EqualsAndHashCode
@ToString
@NonNull
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gasto {

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

    @Getter @Setter @Column(name = "fecha")
    private String fecha;

    @Getter @Setter @Column(name = "periodo")
    private String periodo;

    @Getter @Setter @Column(name = "tipo_gasto")
    private String tipo_gasto;

    @Getter @Setter @Column(name = "nro_comprobante")
    private String nro_comprobante;

    @Getter @Setter @Column(name = "moneda")
    private String moneda;

    @Getter @Setter @Column(name = "monto")
    private BigDecimal monto;

    @Getter @Setter @Column(name = "estado")
    private String estado;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "gasto_OC")
    private OrdenDeCompra gasto_OC;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "proveedor_id")
    private Proveedor proveedor_id;

    @Getter @Setter @Column(name = "rubro")
    private String rubro;

    @Getter @Setter @Column(name = "tipo_cambio")
    private String tipo_cambio_gasto;

    @Getter @Setter @Column(name = "cuenta")
    private String cuenta;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "obra_gasto")
    private Proyecto obra_gasto;

    @Getter @Setter @Column(name = "observaciones")
    private String observaciones;

    @Getter @Setter @Column(name = "usuario_id")
    private String usuario_id;

    @Getter @Setter @Column(name = "empresa_id")
    private String empresa_id;


}

