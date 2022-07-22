package constApp.web.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "empresas")
@EqualsAndHashCode
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empresa {

    @Id
    @Getter
    @Setter
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "empresa_id", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @Getter @Setter
    private List<Usuario> lista_usuarios;
}
