package constApp.web.services;


import constApp.web.DAO.GastoDAO;
import constApp.web.DAO.IngresoDAO;
import constApp.web.DAO.ProyectoDAO;
import constApp.web.models.Gasto;
import constApp.web.models.Ingreso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;

@Service
@Transactional
public class DashboardServices {

    @Autowired
    private IngresoDAO ingresosRepo;
    @Autowired
    private GastoDAO gastosRepo;
    @Autowired
    private ProyectoDAO proyectoRepo;


    public BigDecimal listAllGastosDolares(){
        BigDecimal sumatoriaGastos = new BigDecimal(0.00);
        for (Gasto g : gastosRepo.findAll()){
            if(g.getMoneda().equals("Dolares")){
                sumatoriaGastos = sumatoriaGastos.add(g.getMonto());
            }
        }
        return sumatoriaGastos;
    }
    public BigDecimal listAllGastosPesos(){
        BigDecimal sumatoriaGastos = new BigDecimal(0.00);
        for (Gasto g : gastosRepo.findAll()){
            if(g.getMoneda().equals("Pesos")){
                sumatoriaGastos = sumatoriaGastos.add(g.getMonto());
            }
        }
        return sumatoriaGastos;
    }

    public ArrayList<Ingreso> listIngresoPeriodoMoneda(String p, String m){

        return ingresosRepo.findByPeriodoAndMoneda(p,m);

    }



}
