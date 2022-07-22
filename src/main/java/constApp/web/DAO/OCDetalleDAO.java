package constApp.web.DAO;


import constApp.web.models.OCDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface OCDetalleDAO extends JpaRepository<OCDetalle, Long> {

    default void saveList(ArrayList<OCDetalle> ocDetalleArrayList){
        for (OCDetalle ocdet: ocDetalleArrayList) {
                this.save(ocdet);
        }
    }
}
