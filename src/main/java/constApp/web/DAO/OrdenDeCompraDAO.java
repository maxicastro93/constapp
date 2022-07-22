package constApp.web.DAO;

import constApp.web.models.OrdenDeCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenDeCompraDAO extends JpaRepository<OrdenDeCompra, Long> {
}
