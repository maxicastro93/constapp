package constApp.web.DAO;

import java.util.List;
import constApp.web.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

//implementacion clase usuarioDAO
@Repository
@Transactional

public class UsuarioDAOImp implements UsuarioDAO{

    @PersistenceContext
    private EntityManager entityManager; // sirve para la conexion con la base de datos

    @Override
    @Transactional
    public List<Usuario> getUsuarios() {

        // aca va el nombre de la Clase, no de la tabla
        String query = "FROM Usuario";
        // toma la consulta y la transforma en una lista de Usuarios
        return entityManager.createQuery(query).getResultList();

    }

    @Override
    public void eliminar(Long id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        entityManager.remove(usuario);
    }

    @Override
    public void registrar(Usuario usuario){
        entityManager.merge(usuario);
    }

    @Override
    public Usuario obtenerUsuarioPorCredenciales(Usuario usuario) {

        String query = "FROM Usuario WHERE email = :email";



        List<Usuario> lista = entityManager.createQuery(query)
                .setParameter("email", usuario.getEmail())
                .getResultList();

        if(lista.isEmpty()){
            return null;
        }
        String passwordHashed = lista.get(0).getPassword();
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

        if(argon2.verify(passwordHashed,usuario.getPassword())){
            return lista.get(0);
        }
        return null;


    }
}
