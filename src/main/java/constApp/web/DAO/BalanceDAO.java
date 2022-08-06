package constApp.web.DAO;

import constApp.web.models.Balance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceDAO extends JpaRepository<Balance,Long> {

    Balance deleteByMovimientoId(Long id);
    Balance deleteByObs(String s);


    Balance findByMovimientoIdAndTipoMovimiento(Long id, String movimiento);

    void deleteByMovimientoIdAndTipoMovimiento(Long id, String ingreso);
}
