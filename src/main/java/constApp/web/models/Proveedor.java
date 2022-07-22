// PROVEEDOR, LISTADO DE PROVEEDORES A QUIENES LE COMPRAN.
// DEBERA TENER LOS DATOS BASICOS, Y PODER FILTRAR CON LA BASE DE DATOS LAS COMPRAS Y LAS ORDENES DE COMPRA QUE LE ASIGNARON
// A EL PROVEEDOR SEGUN NOMBRE O ID DEL PROVEEDOR

// CLASE GASTO O PAGO, REGISTRARA EL PAGO A PROVEEDORES, O CUALQUIER OTRO TIPO DE GASTO

package constApp.web.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "proveedor")
@EqualsAndHashCode
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Proveedor {

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

    @Getter @Setter @Column(name = "rubro")
    private String rubro;

    @OneToMany(mappedBy = "proveedor_id", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @Getter @Setter
    private List<Gasto> gastosProveedor;


}
