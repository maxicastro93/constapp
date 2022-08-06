package constApp.web.DAO;

import constApp.web.models.Proveedor;
import constApp.web.models.Rubro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RubroDAO extends JpaRepository<Rubro, Long> {

}