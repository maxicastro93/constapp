package constApp.web.services;

import constApp.web.DAO.*;
import constApp.web.Utils.Calculos;
import constApp.web.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProveedorService {

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
    @Autowired
    private ProyectoDAO proyectoRepo;


    public ArrayList<Proveedor> getAllProv() {
        ArrayList<Proveedor> provList = new ArrayList<Proveedor>(provRepo.findAll());

        return provList;

    }

    public BigDecimal totalGastadoPorProveedor(Long provId) {

        BigDecimal acumulado = new BigDecimal(0.0);
        Proveedor proveedor = provRepo.findById(provId).get();

        List<Gasto> gastosProv = proveedor.getGastosProveedor();
        for (Gasto gast: gastosProv) {
            acumulado = acumulado.add(gast.getMonto());
        }

        return acumulado;

    }

    public List<List<Object>> listGastosProveedor(Long provId){
        Calculos calculos = new Calculos();
        List<List<Object>> listGraficoGastosAnuales = new ArrayList<>();
        List<String> periodosAnual = calculos.get12PeriodosAtras();
        Proveedor proveedor = provRepo.findById(provId).get();


        for (int j=0;j< periodosAnual.size();j++){
            List<Object> c = new ArrayList<>();
            TuplaMontoPeriodo tuplaAux = new TuplaMontoPeriodo(periodosAnual.get(j), sumatoria(proveedor.getGastosProveedor(),periodosAnual.get(j)));
            c.add(tuplaAux.getPeriodo());
            c.add(tuplaAux.getMonto());
            listGraficoGastosAnuales.add(c);
        }

        return listGraficoGastosAnuales;
    }


    public BigDecimal sumatoria (List<Gasto> listado, String periodo){
        BigDecimal suma = new BigDecimal(0);

        for (Gasto g : listado) {

            if(g.getPeriodo().equals(periodo)){
                suma = suma.add(g.getMonto());
            }
        }
        return suma;
    }

    public void saveProveedor(Proveedor proveedor) {

        provRepo.save(proveedor);

    }


    public void deleteProveedor(Long provId) {

        provRepo.deleteById(provId);
    }

    public Proveedor getProvById(Long provId) {
        return provRepo.findById(provId).get();
    }
}
