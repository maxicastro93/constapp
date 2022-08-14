package constApp.web.services;

import constApp.web.DAO.*;
import constApp.web.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Service
@Transactional
public class GastoService {

    @Autowired
    private GastoDAO gastoRepo;
    @Autowired
    private ProveedorDAO provRepo;
    @Autowired
    private OrdenDeCompraDAO ocRepo;
    @Autowired
    private BalanceService balanceService;
    @Autowired
    private RubroDAO rubroRepo;
    @Autowired
    private CuentaDAO cuentaRepo;


    public ArrayList<Gasto> getAllGastos() {
        ArrayList<Gasto> gastoList = new ArrayList<Gasto>(gastoRepo.findAll());

        return gastoList;

    }


    public Gasto retornaGastoActualizado(Gasto gasto) {
//        Gasto g = new Gasto();


        Long idOC = gasto.getGasto_OC().getId();
        Long idProveedor = gasto.getProveedor_id().getId();


        Optional<OrdenDeCompra> auxOC = ocRepo.findById(idOC);
        Optional<Proveedor> provAux = provRepo.findById(idProveedor);

        if (auxOC.isPresent() && provAux.isPresent()) {
            gasto.setGasto_OC(auxOC.get());
            gasto.setProveedor_id(provAux.get());
//            provAux.get().getGastosProveedor().add(gasto); ESTO VA EN SERVICE DE PROVEEDOR
        }
        else{
            gasto.setGasto_OC(null);
            gasto.setProveedor_id(null);
        }

        gastoRepo.save(gasto);
        return gasto;
    }


    public void saveGasto(Gasto gasto) {

        if (gasto.getGasto_OC() != null ) {
            Long idOC = gasto.getGasto_OC().getId();
            Optional<OrdenDeCompra> auxOC = ocRepo.findById(idOC);
            gasto.setGasto_OC(auxOC.get());

        }
        if (gasto.getProveedor_id() != null ) {
            Long idProveedor = gasto.getProveedor_id().getId();
            Optional<Proveedor> provAux = provRepo.findById(idProveedor);
            gasto.setProveedor_id(provAux.get());
            //            provAux.get().getGastosProveedor().add(gasto); ESTO VA EN SERVICE DE PROVEEDOR

        }

        else{
            gasto.setGasto_OC(null);
            gasto.setProveedor_id(null);
        }

        gastoRepo.save(gasto);
    }


    public void deleteGasto(Long gastoId) {

        gastoRepo.deleteById(gastoId);
        balanceService.deleteGasto(gastoId);
    }

    public Gasto getGastoById(Long gastoId) {
        return gastoRepo.findById(gastoId).get();
    }
}
