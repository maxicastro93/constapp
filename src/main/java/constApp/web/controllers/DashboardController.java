package constApp.web.controllers;
import constApp.web.DAO.ClienteDAO;
import constApp.web.DAO.IngresoDAO;
import constApp.web.models.Cliente;
import constApp.web.models.Ingreso;
import constApp.web.models.TuplaMontoPeriodo;
import constApp.web.services.DashboardServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.Tuple;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DashboardController {

    @Autowired
    private IngresoDAO ingresoRepo;
    @Autowired
    private ClienteDAO clienteRepo;
    @Autowired
    private DashboardServices dashServices;


//    @GetMapping({"/"})
//    public String home()
//    {
//        return "/home";
//    }

    @GetMapping({"/home"})
    public ModelAndView getDataDashboard() {
        ModelAndView mav = new ModelAndView("index");

        BigDecimal gastosDolares = new BigDecimal(0.0);
        BigDecimal gastosPesos = new BigDecimal(0.0);
        BigDecimal ingresosAgostoTotal = new BigDecimal(0.0);
        BigDecimal ingresosJulioTotal = new BigDecimal(0.0);

        gastosDolares = dashServices.listAllGastosDolares();
        gastosPesos = dashServices.listAllGastosPesos();

        ArrayList<Ingreso> ingresosAgosto = new ArrayList<>();
        ArrayList<Ingreso> ingresosJulio = new ArrayList<>();

        ingresosAgosto = dashServices.listIngresoPeriodoMoneda("Agosto 2022", "Pesos" );
        for(Ingreso ing1: ingresosAgosto){
            ingresosAgostoTotal = ingresosAgostoTotal.add(ing1.getMonto());
        }
        ingresosJulio = dashServices.listIngresoPeriodoMoneda("Julio 2022", "Pesos" );
        for(Ingreso ing2: ingresosJulio){
            ingresosJulioTotal = ingresosJulioTotal.add(ing2.getMonto());
        }

        BigDecimal m1 = new BigDecimal(1230.0);
        BigDecimal m2 = new BigDecimal(22220.0);
        BigDecimal m3 = new BigDecimal(3000);
        BigDecimal m4 = new BigDecimal(738920.0);
        BigDecimal m5 = new BigDecimal(2330.0);


        TuplaMontoPeriodo tuplaIngresoAgo = new TuplaMontoPeriodo("Agosto 2022", m1);
        TuplaMontoPeriodo tuplaIngresoJul = new TuplaMontoPeriodo("Julio 2022", m2);
        TuplaMontoPeriodo tuplaIngresoJun = new TuplaMontoPeriodo("Junio 2022", m3);
        TuplaMontoPeriodo tuplaIngresoMay = new TuplaMontoPeriodo("Mayo 2022", m4);
        TuplaMontoPeriodo tuplaIngresoAbr = new TuplaMontoPeriodo("Abril 2022", m5);



        List<List<Object>> listGraficoIngresosAnuales = new ArrayList<>();
        List<Object> c = new ArrayList<>();
        c.add(tuplaIngresoAgo.getPeriodo());
        c.add(tuplaIngresoAgo.getMonto());
        List<Object> d = new ArrayList<>();
        d.add(tuplaIngresoJul.getPeriodo());
        d.add(tuplaIngresoJul.getMonto());
        List<Object> f = new ArrayList<>();
        f.add(tuplaIngresoJun.getPeriodo());
        f.add(tuplaIngresoJun.getMonto());
        List<Object> g = new ArrayList<>();
        g.add(tuplaIngresoMay.getPeriodo());
        g.add(tuplaIngresoMay.getMonto());
        List<Object> h = new ArrayList<>();
        h.add(tuplaIngresoAbr.getPeriodo());
        h.add(tuplaIngresoAbr.getMonto());


        listGraficoIngresosAnuales.add(c);
        listGraficoIngresosAnuales.add(d);
        listGraficoIngresosAnuales.add(f);
        listGraficoIngresosAnuales.add(g);
        listGraficoIngresosAnuales.add(h);


        mav.addObject("gastosPesos", gastosPesos);
        mav.addObject("gastosDolares", gastosDolares);
        mav.addObject("listGraficoIngresosAnuales", listGraficoIngresosAnuales );


        return mav;
    }

}
