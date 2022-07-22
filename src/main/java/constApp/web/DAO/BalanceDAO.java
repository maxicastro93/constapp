package constApp.web.DAO;

import constApp.web.models.Balance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceDAO extends JpaRepository<Balance,Long> {
}
