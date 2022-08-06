package constApp.web.DAO;

import constApp.web.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface ClienteDAO  extends JpaRepository<Cliente, Long>{
}
