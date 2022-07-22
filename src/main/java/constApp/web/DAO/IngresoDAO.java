package constApp.web.DAO;

import constApp.web.models.Ingreso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

public interface IngresoDAO extends JpaRepository<Ingreso, Long> {

    ArrayList<Ingreso> findByPeriodoAndMoneda(String periodo, String moneda);

}


