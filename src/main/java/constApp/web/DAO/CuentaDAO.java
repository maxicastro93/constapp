package constApp.web.DAO;

import constApp.web.models.Cuenta;
import constApp.web.models.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaDAO extends JpaRepository<Cuenta, Long> {

}