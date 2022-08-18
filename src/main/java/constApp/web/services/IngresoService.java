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
public class IngresoService {

    @Autowired
    private IngresoDAO ingresoRepo;

    @Autowired
    private ClienteDAO clienteRepo;

    @Autowired
    private BalanceService balanceService;

    @Autowired
    private ProyectoDAO proyectoRepo;


    public ArrayList<Ingreso> getAllIngresos() {
        ArrayList<Ingreso> ingresosList = new ArrayList<Ingreso>(ingresoRepo.findAll());

        return ingresosList;

    }


    public Ingreso retornaIngresoActualizado(Ingreso ingreso) {
//        Gasto g = new Gasto();

        if (ingreso.getCliente_id() != null && ingreso.getObra() != null) {
            Optional<Cliente> clienteAux = clienteRepo.findById(ingreso.getCliente_id().getId());
            Optional<Proyecto> proyAux = proyectoRepo.findById(ingreso.getObra().getId());


            if (clienteAux.isPresent() && proyAux.isPresent()) {

                ingreso.setCliente_id(clienteAux.get()); // Vincula el Cliente al ingreso
                ingreso.setObra(proyAux.get()); // Vincula el Proyecto al ingreso

            }
        }
        else {
            ingreso.setCliente_id(null);
            ingreso.setObra(null);

        }
        return ingreso;
    }

    public void saveIngreso(Ingreso ingreso) {

        ingresoRepo.save(ingreso);
    }


    public BigDecimal getAcumuladoDolaresPeriodoActual() throws ParseException {
        Calculos calculos = new Calculos();
        BigDecimal acumuladoDolaresMensual = new BigDecimal(0);

        ArrayList<Ingreso> ingresoDolaresPeriodoActual = ingresoRepo.findByPeriodoAndMoneda(calculos.getPeriodoActual(), "Dolares");

        for (Ingreso ingAux : ingresoDolaresPeriodoActual) {
            acumuladoDolaresMensual = acumuladoDolaresMensual.add(ingAux.getMonto());
        }
        return acumuladoDolaresMensual;

    }

    public BigDecimal getAcumuladoPesosPeriodoActual() throws ParseException {
        Calculos calculos = new Calculos();
        BigDecimal acumuladoPesosMensual = new BigDecimal(0);

        ArrayList<Ingreso> ingresoPesosPeriodoActual = ingresoRepo.findByPeriodoAndMoneda(calculos.getPeriodoActual(), "Pesos");
        for (Ingreso ingAux : ingresoPesosPeriodoActual) {
            acumuladoPesosMensual = acumuladoPesosMensual.add(ingAux.getMonto());

        }
        return acumuladoPesosMensual;
    }

    public void deleteIngreso(Long ingresoId) {
        balanceService.deleteIngreso(ingresoId);
        ingresoRepo.deleteById(ingresoId);

    }

    public Ingreso getIngresoById(Long ingresoId) {
        return ingresoRepo.findById(ingresoId).get();
    }
}
