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
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DashboardServices {

    @Autowired
    private IngresoDAO ingresosRepo;
    @Autowired
    private GastoDAO gastosRepo;
    @Autowired
    private ProyectoDAO proyectoRepo;

    // GASTOS

    public BigDecimal sumatoriaTotalGastosDolares(){
        BigDecimal sumatoriaGastos = new BigDecimal(0.00);
        for (Gasto g : gastosRepo.findAll()){
            if(g.getMoneda().equals("Dolares")){
                sumatoriaGastos = sumatoriaGastos.add(g.getMonto());
            }
        }
        return sumatoriaGastos;
    }

    public BigDecimal sumatoriaGastosDolares(ArrayList<Gasto> gastoList){
        BigDecimal sumatoriaGastos = new BigDecimal(0.00);
        for (Gasto g : gastoList){
            if(g.getMoneda().equals("Dolares")){
                sumatoriaGastos = sumatoriaGastos.add(g.getMonto());
            }
        }
        return sumatoriaGastos;
    }


    public BigDecimal sumatoriaTotalGastosPesos(){
        BigDecimal sumatoriaGastos = new BigDecimal(0.00);
        for (Gasto g : gastosRepo.findAll()){
            if(g.getMoneda().equals("Pesos")){
                sumatoriaGastos = sumatoriaGastos.add(g.getMonto());
            }
        }
        return sumatoriaGastos;
    }

    public BigDecimal sumatoriaGastosPesos(ArrayList<Gasto> gastoList){
        BigDecimal sumatoriaGastos = new BigDecimal(0.00);
        for (Gasto g : gastoList){
            if(g.getMoneda().equals("Pesos")){
                sumatoriaGastos = sumatoriaGastos.add(g.getMonto());
            }
        }
        return sumatoriaGastos;
    }


    // INGRESOS

    public BigDecimal sumatoriaTotalIngresosDolares(){
        BigDecimal sumatoriaIngresos = new BigDecimal(0.00);
        for (Ingreso i : ingresosRepo.findAll()){
            if(i.getMoneda().equals("Dolares")){
                sumatoriaIngresos = sumatoriaIngresos.add(i.getMonto());
            }
        }
        return sumatoriaIngresos;
    }

    public BigDecimal sumatoriaIngresosDolares(ArrayList<Ingreso> ingresosList){
        BigDecimal sumatoriaIngresos = new BigDecimal(0.00);
        for (Ingreso i : ingresosList){
            if(i.getMoneda().equals("Dolares")){
                sumatoriaIngresos = sumatoriaIngresos.add(i.getMonto());
            }
        }
        return sumatoriaIngresos;
    }


    public BigDecimal sumatoriaTotalIngresosPesos(){
        BigDecimal sumatoriaIngresos = new BigDecimal(0.00);
        for (Ingreso i : ingresosRepo.findAll()){
            if(i.getMoneda().equals("Pesos")){
                sumatoriaIngresos = sumatoriaIngresos.add(i.getMonto());
            }
        }
        return sumatoriaIngresos;
    }

    public BigDecimal sumatoriaIngresosPesos(ArrayList<Ingreso> ingresosList){
        BigDecimal sumatoriaIngresos = new BigDecimal(0.00);
        for (Ingreso i : ingresosList){
            if(i.getMoneda().equals("Pesos")){
                sumatoriaIngresos = sumatoriaIngresos.add(i.getMonto());
            }
        }
        return sumatoriaIngresos;
    }


    // LISTA CON GASTOS ANUALES
    public List<List<Object>> listGastosAnualPesosDolaresGrafico(){
        Calculos calculos = new Calculos();
        List<List<Object>> listGraficoGastosAnuales = new ArrayList<>();
        List<String> periodosAnual = calculos.get12PeriodosAtras();

        for (int j=0;j< periodosAnual.size();j++){
            List<Object> c = new ArrayList<>();
            TriplePesoDolarPeriodo tripleAux = new TriplePesoDolarPeriodo(periodosAnual.get(j),
                    sumatoriaGastosPesos(listGastoPeriodoMoneda(periodosAnual.get(j), "Pesos")),
                    sumatoriaGastosDolares(listGastoPeriodoMoneda(periodosAnual.get(j), "Dolares")));
            c.add(tripleAux.getPeriodo());
            c.add(tripleAux.getMontoPesos());
            c.add(tripleAux.getMontoDolares());
            listGraficoGastosAnuales.add(c);
        }

        return listGraficoGastosAnuales;
    }

    public List<List<Object>> listGastosAnualPesosGrafico(){
        Calculos calculos = new Calculos();
        List<List<Object>> listGraficoGastosAnuales = new ArrayList<>();
        List<String> periodosAnual = calculos.get12PeriodosAtras();

        for (int j=0;j< periodosAnual.size();j++){
            List<Object> c = new ArrayList<>();
            TuplaMontoPeriodo tuplaAux = new TuplaMontoPeriodo(periodosAnual.get(j), sumatoriaGastosPesos(listGastoPeriodoMoneda(periodosAnual.get(j), "Pesos")));
            c.add(tuplaAux.getPeriodo());
            c.add(tuplaAux.getMonto());
            listGraficoGastosAnuales.add(c);
        }

        return listGraficoGastosAnuales;
    }

    public List<List<Object>> listGastosAnualDolaresGrafico(){
        Calculos calculos = new Calculos();
        List<List<Object>> listGraficoGastosAnuales = new ArrayList<>();
        List<String> periodosAnual = calculos.get12PeriodosAtras();

        for (int j=0;j< periodosAnual.size();j++){
            List<Object> c = new ArrayList<>();
            TuplaMontoPeriodo tuplaAux = new TuplaMontoPeriodo(periodosAnual.get(j), sumatoriaGastosDolares(listGastoPeriodoMoneda(periodosAnual.get(j), "Dolares")));
            c.add(tuplaAux.getPeriodo());
            c.add(tuplaAux.getMonto());
            listGraficoGastosAnuales.add(c);
        }

        return listGraficoGastosAnuales;
    }



    // LISTA CON INGRESOS ANUALES

    public List<List<Object>> listIngresosAnualPesosGrafico(){
        Calculos calculos = new Calculos();
        List<List<Object>> listGraficoIngresosAnuales = new ArrayList<>();
        List<String> periodosAnual = calculos.get12PeriodosAtras();

        for (int j=0;j< periodosAnual.size();j++){
            List<Object> c = new ArrayList<>();
            TuplaMontoPeriodo tuplaAux = new TuplaMontoPeriodo(periodosAnual.get(j), sumatoriaIngresosPesos(listIngresoPeriodoMoneda(periodosAnual.get(j), "Pesos")));
            c.add(tuplaAux.getPeriodo());
            c.add(tuplaAux.getMonto());
            listGraficoIngresosAnuales.add(c);
        }

        return listGraficoIngresosAnuales;
    }

    public List<List<Object>> listIngresosAnualDolaresGrafico(){
        Calculos calculos = new Calculos();
        List<List<Object>> listGraficoIngresosAnuales = new ArrayList<>();
        List<String> periodosAnual = calculos.get12PeriodosAtras();

        for (int j=0;j< periodosAnual.size();j++){
            List<Object> c = new ArrayList<>();
            TuplaMontoPeriodo tuplaAux = new TuplaMontoPeriodo(periodosAnual.get(j), sumatoriaIngresosDolares(listIngresoPeriodoMoneda(periodosAnual.get(j), "Dolares")) );
            c.add(tuplaAux.getPeriodo());
            c.add(tuplaAux.getMonto());
            listGraficoIngresosAnuales.add(c);
        }

        return listGraficoIngresosAnuales;
    }

    public List<List<Object>> listIngresosAnualPesosDolaresGrafico(){
        Calculos calculos = new Calculos();
        List<List<Object>> listGraficoIngresosAnuales = new ArrayList<>();
        List<String> periodosAnual = calculos.get12PeriodosAtras();

        for (int j=0;j< periodosAnual.size();j++){
            List<Object> c = new ArrayList<>();
            TriplePesoDolarPeriodo tuplaAux = new TriplePesoDolarPeriodo(periodosAnual.get(j),
                    sumatoriaIngresosPesos(listIngresoPeriodoMoneda(periodosAnual.get(j), "Pesos")),
                    sumatoriaIngresosDolares(listIngresoPeriodoMoneda(periodosAnual.get(j), "Dolares")));
            c.add(tuplaAux.getPeriodo());
            c.add(tuplaAux.getMontoPesos());
            c.add(tuplaAux.getMontoDolares());

            listGraficoIngresosAnuales.add(c);
        }

        return listGraficoIngresosAnuales;
    }


    public ArrayList<Ingreso> listIngresoPeriodoMoneda(String p, String m){

        return ingresosRepo.findByPeriodoAndMoneda(p,m);

    }

    public ArrayList<Gasto> listGastoPeriodoMoneda(String p, String m){

        return gastosRepo.findByPeriodoAndMoneda(p,m);

    }

    public BigDecimal existenciasCajaPesos(){
        BigDecimal cajaPesos = sumatoriaTotalIngresosPesos().subtract(sumatoriaTotalGastosPesos());
        return cajaPesos;
    }

    public BigDecimal existenciasCajaDolares(){
        BigDecimal cajaDolares = sumatoriaTotalIngresosDolares().subtract(sumatoriaTotalGastosDolares());

        return cajaDolares;
    }



}
