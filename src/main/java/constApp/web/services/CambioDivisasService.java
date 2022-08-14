package constApp.web.services;

import constApp.web.DAO.*;
import constApp.web.Utils.Calculos;
import constApp.web.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Optional;

@Service
@Transactional
public class CambioDivisasService {

    @Autowired
    private CambioDivisaDAO cambioRepo;
    @Autowired
    private BalanceService balanceService;
    @Autowired
    private IngresoService ingresoService;
    @Autowired
    private GastoService gastoService;
    @Autowired
    private ClienteDAO clienteRepo;


    public ArrayList<CambioDivisa> getAllCambios() {
        ArrayList<CambioDivisa> cambioDivisaList = new ArrayList<CambioDivisa>(cambioRepo.findAll());

        return cambioDivisaList;

    }


    public void saveCambioDivisa(CambioDivisa cambioDivisa,
                                          Ingreso ingresoCambioDivisa,
                                          Gasto gastoCambioDivisa,
                                          Balance balance ) throws ParseException {


        //Actualiza el Balance
        balance.setFecha(cambioDivisa.getFecha()); // Crea un movimiento(ingreso) en Balance con sus caracteristicas
        balance.setPeriodo(cambioDivisa.getPeriodo());
        balance.setMovimientoId(cambioDivisa.getId());
        balance.setMotivo(cambioDivisa.getMovimiento());
        balance.setTipoMovimiento("Cambio Divisas");
        balance.setMoneda_movimiento("-");
        balance.setObs("");


        if(cambioDivisa.getMovimiento().equals("Pesos a Dolares")) {
            System.out.println("Pesos" + cambioDivisa.getImporte_pesos());
            System.out.println("Dolares" + cambioDivisa.getImporte_dolares());

            BigDecimal auxMonedaPesos = cambioDivisa.getImporte_dolares();
            BigDecimal auxMonedaDolares = cambioDivisa.getImporte_pesos();
            cambioDivisa.setImporte_dolares(auxMonedaDolares);
            cambioDivisa.setImporte_pesos(auxMonedaPesos);

            balance.setImporte_movimiento(cambioDivisa.getImporte_pesos());
            balance.setImporte_recibido(cambioDivisa.getImporte_dolares());
            balance.setTipo_cambio(cambioDivisa.getTipo_de_cambio());


            //SE REGISTRA COMO INGRESO DE DINERO EL CAMBIO DE DIVISAS
            ingresoCambioDivisa.setPeriodo(cambioDivisa.getPeriodo());
            ingresoCambioDivisa.setFecha(cambioDivisa.getFecha());
            ingresoCambioDivisa.setMoneda("Dolares");
            ingresoCambioDivisa.setMonto(cambioDivisa.getImporte_dolares());
            ingresoCambioDivisa.setTipoIngreso("Cambio Pesos a Dolares");
            ingresoCambioDivisa.setObservaciones("TC" + cambioDivisa.getTipo_de_cambio());

            // SE REGISTRA COMO GASTO EL CAMBIO DE DIVISA
            gastoCambioDivisa.setPeriodo(cambioDivisa.getPeriodo());
            gastoCambioDivisa.setFecha(cambioDivisa.getFecha());
            gastoCambioDivisa.setMoneda("Pesos");
            gastoCambioDivisa.setMonto(cambioDivisa.getImporte_pesos());
            gastoCambioDivisa.setTipo_gasto("Cambio Pesos a Dolares");
            gastoCambioDivisa.setObservaciones("TC: " + cambioDivisa.getTipo_de_cambio());
            gastoCambioDivisa.setGasto_OC(null);
        }
        else if (cambioDivisa.getMovimiento().equals("Dolares a Pesos")) {
            balance.setImporte_movimiento(cambioDivisa.getImporte_dolares());
            balance.setImporte_recibido(cambioDivisa.getImporte_pesos());
            balance.setTipo_cambio(cambioDivisa.getTipo_de_cambio());

            //SE REGISTRA COMO INGRESO DE DINERO EL CAMBIO DE DIVISAS
            ingresoCambioDivisa.setPeriodo(cambioDivisa.getPeriodo());
            ingresoCambioDivisa.setFecha(cambioDivisa.getFecha());
            ingresoCambioDivisa.setMoneda("Pesos");
            ingresoCambioDivisa.setMonto(cambioDivisa.getImporte_pesos());
            ingresoCambioDivisa.setTipoIngreso("Cambio Dolares a Pesos");
            ingresoCambioDivisa.setObservaciones("TC" + cambioDivisa.getTipo_de_cambio());

            // SE REGISTRA COMO GASTO EL CAMBIO DE DIVISA
            gastoCambioDivisa.setPeriodo(cambioDivisa.getPeriodo());
            gastoCambioDivisa.setFecha(cambioDivisa.getFecha());
            gastoCambioDivisa.setMoneda("Dolares");
            gastoCambioDivisa.setMonto(cambioDivisa.getImporte_dolares());
            gastoCambioDivisa.setTipo_gasto("Cambio Dolares a Pesos");
            gastoCambioDivisa.setObservaciones("TC: " + cambioDivisa.getTipo_de_cambio());
            gastoCambioDivisa.setGasto_OC(null);

        }
        ingresoService.saveIngreso(ingresoCambioDivisa);
        gastoService.saveGasto(gastoCambioDivisa);
        cambioDivisa.setIngreso_id(ingresoCambioDivisa.getId());
        cambioDivisa.setGasto_id(gastoCambioDivisa.getId());
        cambioRepo.save(cambioDivisa);

        balance.setMovimientoId(cambioDivisa.getId());
        balanceService.saveBalanceDivisa(balance);

    }


    public void deleteCambioDivisa(Long cambioId){
        Optional<CambioDivisa> auxCambio = cambioRepo.findById(cambioId);

        if (auxCambio.isPresent()) {
            ingresoService.deleteIngreso(auxCambio.get().getIngreso_id());
            gastoService.deleteGasto(auxCambio.get().getGasto_id());
            balanceService.deleteDivisa(cambioId);
        }
        cambioRepo.deleteById(cambioId);

    }


}
