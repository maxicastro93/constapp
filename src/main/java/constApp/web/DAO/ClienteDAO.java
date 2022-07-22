package constApp.web.DAO;

import constApp.web.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteDAO  extends JpaRepository<Cliente, Long>{
}
