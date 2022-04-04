package constApp.web.controllers;

import constApp.web.DAO.UsuarioDAO;
import constApp.web.Utils.JWTUtil;
import constApp.web.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthController {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private UsuarioDAO usuarioDAO;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String autenticarUsuario(@RequestBody Usuario usuario){

        Usuario usuarioLogueado = usuarioDAO.obtenerUsuarioPorCredenciales(usuario);

        if (usuarioLogueado != null){
            String tokenJWT = jwtUtil.create(String.valueOf(usuarioLogueado.getId()), usuarioLogueado.getEmail(), usuarioLogueado.getNombre());
            return tokenJWT;// ACA HAY QUE PONER LO QUE QUEREMOS QUE DEVUELVA(NOMBRE USUARIO, EMPRESA, ETC)
        }
        return "FAIL";
    }
}
