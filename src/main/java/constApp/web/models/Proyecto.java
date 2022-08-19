package constApp.web.models;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "proyecto")
@EqualsAndHashCode
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Proyecto {

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

    @Getter @Setter @Column(name = "gasto_proyectado_pesos")
    private BigDecimal gasto_proyectado_pesos;

    @Getter @Setter @Column(name = "gasto_proyectado_dolares")
    private BigDecimal gasto_proyectado_dolares;

    @OneToMany(mappedBy = "obra_ingreso", cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @Getter @Setter
    private List<Ingreso> ingresosProyecto;

    @OneToMany(mappedBy = "obra_gasto", cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @Getter @Setter
    private List<Gasto> gastosProyecto;

    @OneToMany(mappedBy = "obra_cliente", cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @Getter @Setter
    private List<Cliente> clientesProyecto;

}
///// AGREGAR EN CADA CONTROLLER EL REPO DE PROYECTO
//// Y EN CADA VISTA .HMTL TAMBIEN EN PROYECTO