package constApp.web.controllers;
import constApp.web.DAO.ClienteDAO;
import constApp.web.DAO.IngresoDAO;
import constApp.web.services.DashboardServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
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

    @GetMapping({"/dashboard"})
    public ModelAndView getDataDashboard() {
        ModelAndView mav = new ModelAndView("dashboard");



        List<List<Object>> listGraficoGastosAnualesPesos = dashServices.listGastosAnualPesosGrafico();
        List<List<Object>> listGraficoGastosAnualesDolares = dashServices.listGastosAnualDolaresGrafico();
        List<List<Object>> listGraficoIngresosAnualesPesos = dashServices.listIngresosAnualPesosGrafico();
        List<List<Object>> listGraficoIngresosAnualesDolares = dashServices.listIngresosAnualDolaresGrafico();
        List<List<Object>> listGraficoGastosPesosDolares = dashServices.listGastosAnualPesosDolaresGrafico();
        List<List<Object>> listGraficoIngresosPesosDolares = dashServices.listIngresosAnualPesosDolaresGrafico();




        BigDecimal gastosDolares = dashServices.sumatoriaTotalGastosDolares();
        BigDecimal gastosPesos = dashServices.sumatoriaTotalGastosPesos();

        BigDecimal cajaPesos = dashServices.existenciasCajaPesos();
        BigDecimal cajaDolares = dashServices.existenciasCajaDolares();



        mav.addObject("gastosPesos", gastosPesos);
        mav.addObject("gastosDolares", gastosDolares);
        mav.addObject("listGraficoGastosAnualesPesos", listGraficoGastosAnualesPesos);
        mav.addObject("listGraficoGastosAnualesDolares", listGraficoGastosAnualesDolares);
        mav.addObject("listGraficoIngresosAnualesPesos", listGraficoIngresosAnualesPesos);
        mav.addObject("listGraficoIngresosAnualesDolares", listGraficoIngresosAnualesDolares);
        mav.addObject("listGraficoGastosPesosDolares", listGraficoGastosPesosDolares);
        mav.addObject("listGraficoIngresosPesosDolares", listGraficoIngresosPesosDolares);
        mav.addObject("cajaPesos", cajaPesos );
        mav.addObject("cajaDolares",cajaDolares);


        return mav;
    }

}
