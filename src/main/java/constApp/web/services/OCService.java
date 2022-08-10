package constApp.web.services;

import constApp.web.DAO.CambioDivisaDAO;
import constApp.web.DAO.ClienteDAO;
import constApp.web.models.Balance;
import constApp.web.models.CambioDivisa;
import constApp.web.models.Gasto;
import constApp.web.models.Ingreso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Optional;

@Service
@Transactional
public class OCService {

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


    public ArrayList<CambioDivisa> getDetalleOC(Long id) {
        ArrayList<CambioDivisa> cambioDivisaList = new ArrayList<CambioDivisa>(cambioRepo.findAll());

        return cambioDivisaList;

    }

}
