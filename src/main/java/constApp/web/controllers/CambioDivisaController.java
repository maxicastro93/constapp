package constApp.web.controllers;

import constApp.web.DAO.*;
import constApp.web.Utils.Calculos;
import constApp.web.models.*;
import constApp.web.services.BalanceService;
import constApp.web.services.CambioDivisasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.text.ParseException;

@Controller
public class CambioDivisaController {

    @Autowired
    private CambioDivisasService cambioService;
    @Autowired
    private BalanceService balanceService;
    @Autowired
    private IngresoDAO ingresoRepo;
    @Autowired
    private GastoDAO gastoRepo;


    private Calculos calculos;

    @GetMapping({"/cambioDivisas"})
    public ModelAndView getAllCambios() throws ParseException {

        ModelAndView mav = new ModelAndView("cambio-divisas");

        mav.addObject("cambio_divisas", cambioService.getAllCambios());

        return mav;
    }

    @GetMapping("/addCambioForm")
    public ModelAndView addCambioForm() {
        ModelAndView mav = new ModelAndView("add-cambio-divisas");
        CambioDivisa newCambio = new CambioDivisa();
        mav.addObject("cambio_divisa", newCambio);
//        mav.addObject("balance", balanceService.findAll());
        return mav;
    }

    @PostMapping("/saveCambio")
    public String saveIngreso(@ModelAttribute CambioDivisa cambioDivisa,
                              @ModelAttribute Balance balance,
                              @ModelAttribute Ingreso ingresoCambioDivisa,
                              @ModelAttribute Gasto gastoCambioDivisa
                              ) throws ParseException {

        calculos = new Calculos();
        cambioDivisa.setPeriodo(calculos.getPeriodoFromFecha(cambioDivisa.getFecha())); // para despues filtrar por "Periodo" los gastos o ingresos

        cambioService.saveCambioDivisa(cambioDivisa, ingresoCambioDivisa, gastoCambioDivisa, balance);

        return "redirect:/cambioDivisas";
    }

    @GetMapping("/deleteCambio")
    public String deleteCambio(@RequestParam Long cambioId) {

        cambioService.deleteCambioDivisa(cambioId);
        return "redirect:/cambioDivisas";
    }

}
