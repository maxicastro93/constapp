package constApp.web.controllers;

import constApp.web.DAO.UsuarioDAO;
import constApp.web.Utils.JWTUtil;
import constApp.web.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Autowired
    private JWTUtil jdtUtil;

    @RequestMapping(value = "api/usuario/{id}")
    public Usuario getUsuario(@PathVariable Long id) {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Maxi");
        usuario.setApellido("Castro");
        usuario.setEmail("maxi@hotmail.com");
        usuario.setTelefono("1165554389");
        usuario.setPassword("conta1");
        usuario.setEmpresa("Bicastro");
        return usuario;
    }

    @RequestMapping(value = "api/usuarios")
    public List<Usuario> getUsuarios(@RequestHeader(value = "Authorization") String token)// RequestHeader lo que hace es ponerle una condicion a la peticion de getUsuarios
            // es decir, si o si tiene que tener el parametro autorization, osea que tiene que estar logueado
    {
        if(!validarToken(token)){
            return null;
        }
        return usuarioDAO.getUsuarios();
    }

    private boolean validarToken(String token){
        String usuarioId = jdtUtil.getKey(token);
        return usuarioId != null;
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void registrarUsuarios(@RequestBody Usuario usuario){

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

        String hash = argon2.hash(2,1024,1,usuario.getPassword());
        usuario.setPassword(hash);
        usuarioDAO.registrar(usuario);


    }

//    @RequestMapping(value = "usuariosdf")
//    public Usuario editarUsuario() {
//        Usuario usuario = new Usuario();
//        usuario.setNombre("Maxi");
//        usuario.setApellido("Castro");
//        usuario.setEmail("maxi@hotmail.com");
//        usuario.setTelefono("1165554389");
//        usuario.setPassword("conta1");
//        usuario.setEmpresa("Bicastro");
//        return usuario;
//    }

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminarUsuario(@RequestHeader(value = "Authorization") String token,
                                @PathVariable Long id) {
        if(!validarToken(token)){
            return;
        }
        usuarioDAO.eliminar(id);
    }
}
