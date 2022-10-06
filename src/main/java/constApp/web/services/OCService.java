package constApp.web.services;

import constApp.web.DAO.CambioDivisaDAO;
import constApp.web.DAO.ClienteDAO;
import constApp.web.DAO.OrdenDeCompraDAO;
import constApp.web.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OCService {

    @Autowired
    private OrdenDeCompraDAO ocRepo;
    @Autowired
    private BalanceService balanceService;
    @Autowired
    private IngresoService ingresoService;
    @Autowired
    private GastoService gastoService;
    @Autowired
    private ClienteDAO clienteRepo;


    public ArrayList<OrdenDeCompra> getListadoOC() {
        ArrayList<OrdenDeCompra> listaOC = new ArrayList<OrdenDeCompra>(ocRepo.findAll());
        listaOC.remove(0);
        return listaOC;

    }
    public ArrayList<OrdenDeCompra> getListadoCompletoOC() {
        ArrayList<OrdenDeCompra> listaOC = new ArrayList<OrdenDeCompra>(ocRepo.findAll());
        return listaOC;

    }
    public BigDecimal getRestantePorGastar(OrdenDeCompra oc) {
        BigDecimal restante = oc.getMontototal();

        List<Gasto> gastosOC = oc.getGasto_OC();
        for (Gasto g: gastosOC) {
            restante = restante.subtract(g.getMonto());
        }
        return restante;

    }
}
