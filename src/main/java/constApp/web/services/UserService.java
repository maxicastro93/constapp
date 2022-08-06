package constApp.web.services;

import constApp.web.models.Usuario;

public interface UserService {
    void save(Usuario user);

    Usuario findByUsername(String username);
}
