package constApp.web.services;


import constApp.web.DAO.GastoDAO;
import constApp.web.DAO.IngresoDAO;
import constApp.web.DAO.ProyectoDAO;
import constApp.web.Utils.Calculos;
import constApp.web.models.Gasto;
import constApp.web.models.Ingreso;
import constApp.web.models.TriplePesoDolarPeriodo;
import constApp.web.models.TuplaMontoPeriodo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

@Service
@Transactional
public class CashFlowServices {

    @Autowired
    private IngresoDAO ingresosRepo;
    @Autowired
    private GastoDAO gastosRepo;
    @Autowired
    private ProyectoDAO proyectoRepo;

    // GASTOS

    public HashMap<String,BigDecimal> cashFlow(){
        HashMap listCashFlow = new HashMap();
        ArrayList gastos = gastosRepo.findByCuenta("");
        BigDecimal sumatoriaGastos = new BigDecimal(0.00);
        for (Gasto g : gastosRepo.findAll()){
            if(g.getMoneda().equals("Dolares")){
                sumatoriaGastos = sumatoriaGastos.add(g.getMonto());
            }
        }
        return listCashFlow;
    }

}
