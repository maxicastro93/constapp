package constApp.web.services;

import constApp.web.DAO.BalanceDAO;
import constApp.web.models.Balance;
import constApp.web.models.Gasto;
import constApp.web.models.Ingreso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BalanceService {

    @Autowired
    BalanceDAO balanceRepo;

    public ArrayList<Balance> getMovimientosSinNull() {

        List<Balance> allBalance = balanceRepo.findAll();
        ArrayList<Balance> listBalanceLimpia = new ArrayList<>();
        for(Balance bal : allBalance){
            if(bal.getObs() != null && !bal.getObs().equals("Eliminado"))
                listBalanceLimpia.add(bal);
        }

        return listBalanceLimpia;

    }

    public void saveIngreso(Ingreso ingreso) {
        Balance balance;

        if (balanceRepo.findByMovimientoIdAndTipoMovimiento(ingreso.getId(), "Ingreso") != null)
            balance = balanceRepo.findByMovimientoIdAndTipoMovimiento(ingreso.getId(), "Ingreso");
        else
            balance = new Balance();

        //Actualiza el Balance
        balance.setFecha(ingreso.getFecha()); // Crea un movimiento(ingreso) en Balance con sus caracteristicas
        balance.setPeriodo(ingreso.getPeriodo());
        balance.setMovimientoId(ingreso.getId());
        balance.setMotivo(ingreso.getTipoIngreso());
        balance.setTipoMovimiento("Ingreso");
        balance.setMoneda_movimiento(ingreso.getMoneda());
        balance.setImporte_movimiento(ingreso.getMonto());
        balance.setObs(ingreso.getObservaciones());

        if (ingreso.getCliente_id() != null)
            balance.setCliente_nombre(ingreso.getCliente_id().getNombre());
        else
            balance.setCliente_nombre("-");

        balanceRepo.save(balance);
    }

    public void saveGasto(Gasto gasto) {
        Balance balance;

        if (balanceRepo.findByMovimientoIdAndTipoMovimiento(gasto.getId(), "Gasto") != null)
            balance = balanceRepo.findByMovimientoIdAndTipoMovimiento(gasto.getId(), "Gasto");
        else
            balance = new Balance();

        //Actualiza el Balance

        balance.setFecha(gasto.getFecha()); // Crea un movimiento(gasto) en Balance con sus caracteristicas
        balance.setPeriodo(gasto.getPeriodo());
        balance.setMovimientoId(gasto.getId());
        balance.setMotivo("-");//gasto.getRubro() + " - " + gasto.getCuenta()); // COMPLETAR ESTOOOOO
        balance.setTipoMovimiento("Gasto");
        balance.setMoneda_movimiento(gasto.getMoneda());
        balance.setImporte_movimiento(gasto.getMonto());
        balance.setProveedor_nombre(gasto.getProveedor_id().getNombre());
        balance.setObs(gasto.getObservaciones());

        if (gasto.getProveedor_id() != null)
            balance.setProveedor_nombre(gasto.getProveedor_id().getNombre());
        else
            balance.setProveedor_nombre("-");

        balanceRepo.save(balance);
    }

    public void saveBalanceDivisa(Balance b){
        balanceRepo.save(b);
    }

    public void deleteGasto(Long gastoId) {

        balanceRepo.deleteByMovimientoIdAndTipoMovimiento(gastoId, "Gasto");
    }

    public void deleteDivisa(Long cambioId) {

        balanceRepo.deleteByMovimientoIdAndTipoMovimiento(cambioId, "Cambio Divisas");
    }

    public void deleteIngreso(Long ingresoId) {

        balanceRepo.deleteByMovimientoIdAndTipoMovimiento(ingresoId, "Ingreso");
    }
}
