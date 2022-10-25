package constApp.web.DAO;

import constApp.web.models.Gasto;
import constApp.web.models.Ingreso;
import constApp.web.models.OCDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface GastoDAO extends JpaRepository<Gasto, Long>{

    ArrayList<Gasto> findByPeriodoAndMoneda(String periodo, String moneda);
    ArrayList<Gasto> findByCuenta(String cuenta);
    ArrayList<Gasto> findAllByOrderByIdDesc();



}
