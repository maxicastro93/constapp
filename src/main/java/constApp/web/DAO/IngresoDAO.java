package constApp.web.DAO;

import constApp.web.models.Ingreso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
public interface IngresoDAO extends JpaRepository<Ingreso, Long> {

    ArrayList<Ingreso> findByPeriodoAndMoneda(String periodo, String moneda);

}


