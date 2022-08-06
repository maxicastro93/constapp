package constApp.web.DAO;

import constApp.web.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// DAO (data access objet)
@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Long> {

    Usuario findByUsername(String username);
}
