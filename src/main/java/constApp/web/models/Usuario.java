package constApp.web.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
@ToString @EqualsAndHashCode
public class Usuario {
    // se utiliza la anotacion getter y setter para reemplazar los get y set
    //de cada variable
    // la anotacion Column es para indicarle a que columnta de la tabla
    //de la base de datos es la que va
    @Id
    @Getter @Setter @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter @Column(name = "nombre")
    private String nombre;

    @Getter @Setter @Column(name = "apellido")
    private String apellido;

    @Getter @Setter @Column(name = "nickname")
    private String nickname;

    @Getter @Setter @Column(name = "password")
    private String password;

    @Getter @Setter @Column(name = "rol")
    private String rol;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "empresa_id")
    private Empresa empresa_id;

}
