package constApp.web.DAO;

import constApp.web.models.Balance;
import constApp.web.models.CambioDivisa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CambioDivisaDAO extends JpaRepository<CambioDivisa,Long> {


}
