package constApp.web.DAO;

import constApp.web.models.Usuario;

import java.util.List;

// DAO (data access objet)
public interface UsuarioDAO {
    List<Usuario> getUsuarios();

    void eliminar(Long id);

    void registrar(Usuario usuario);

    Usuario obtenerUsuarioPorCredenciales(Usuario usuario);
}
