package constApp.web.DAO;

import constApp.web.models.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoDAO extends JpaRepository<Proyecto, Long> {
}
