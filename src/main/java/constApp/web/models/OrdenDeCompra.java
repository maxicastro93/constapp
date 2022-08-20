// ORDEN DE COMPRA, SIRVE INTERNAMENTE PARA REQUERIR UN GASTO. CUALQUIERA PODRA CARGAR UNA OC, DEBERA FIGURAR
// QUIEN LA INGRESO Y LA FECHA EN QUE SE INGRESO

package constApp.web.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Entity
@Table(name = "oc")
@ToString
@EqualsAndHashCode
@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrdenDeCompra {

    // se utiliza la anotacion getter y setter para reemplazar los get y set
    //de cada variable
    // la anotacion Column es para indicarle a que columna de la tabla
    //de la base de datos es la que va
    @Id
    @Getter
    @Setter
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // nro orden de compra

    @Getter @Setter @Column(name = "fecha")
    private String fecha;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "obra_oc")
    private Proyecto obra_oc;

    @Getter @Setter @Column(name = "moneda")
    private String moneda;

    @Getter @Setter @Column(name = "montototal")
    private BigDecimal montototal;

    @Getter @Setter @Column(name = "descuento")
    private BigDecimal descuento;

    @Getter @Setter @Column(name = "proveedor_id")
    private String proveedor_id;

    @Getter @Setter @Column(name = "observaciones")
    private String observaciones;

//    @ManyToOne
    @Getter @Setter @Column(name = "usuario_id")
//    @JoinColumn(name="usuarioId")
    private String usuario_id;

    @Getter @Setter @Column(name = "empresa_id")
    private String empresa_id;


    @OneToMany(mappedBy = "gasto_OC", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @Getter @Setter
    private List<Gasto> gasto_OC;


    @OneToMany(mappedBy = "oc_id", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @Getter @Setter
    private List<OCDetalle> detalleOC;


    public void agregarDetalle (OCDetalle detalle){
        if(this.detalleOC == null)
            this.detalleOC = new ArrayList<>();
        detalleOC.add(detalle);
        detalle.setOc_id(this);
    }
}

