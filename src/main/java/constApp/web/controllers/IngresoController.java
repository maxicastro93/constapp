package constApp.web.controllers;

import constApp.web.DAO.*;
import constApp.web.Utils.Calculos;
import constApp.web.models.*;
import constApp.web.services.BalanceService;
import constApp.web.services.IngresoService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class IngresoController {

    @Autowired
    private IngresoService ingresoService;
    @Autowired
    private ClienteDAO clienteRepo;
    @Autowired
    private BalanceService balanceService;
    @Autowired
    private ProyectoDAO proyectoRepo;

    private Calculos calculos;

    @GetMapping({"/ingresos"})
    public ModelAndView getAllIngresos() throws ParseException {

        ModelAndView mav = new ModelAndView("ingresos");
        BigDecimal acumuladoPesosMensual = ingresoService.getAcumuladoPesosPeriodoActual();
        BigDecimal acumuladoDolaresMensual = ingresoService.getAcumuladoDolaresPeriodoActual();


        mav.addObject("ingresos", ingresoService.getAllIngresos());
        mav.addObject("totalDolaresMensual", acumuladoDolaresMensual);
        mav.addObject("totalPesosMensual", acumuladoPesosMensual);


        return mav;
    }

    @GetMapping("/addIngresoForm")
    public ModelAndView addIngresoForm() {
        ModelAndView mav = new ModelAndView("add-ingreso");
        Ingreso newIngreso = new Ingreso();

        mav.addObject("ingreso", newIngreso);
        mav.addObject("clientes", clienteRepo.findAll());
        mav.addObject("proyectos", proyectoRepo.findAll());

        return mav;
    }

    @PostMapping("/saveIngreso")
    public String saveIngreso(@ModelAttribute Ingreso ingreso, @ModelAttribute Cliente cliente, @ModelAttribute Balance balance) throws ParseException {
        Calculos calculo = new Calculos();
        ingreso.setPeriodo(calculo.getPeriodoFromFecha(ingreso.getFecha())); // para despues filtrar por "Periodo" los gastos o ingresos


        Ingreso i = ingresoService.retornaIngresoActualizado(ingreso);

        ingresoService.saveIngreso(i);
        balanceService.saveIngreso(i);

        return "redirect:/ingresos";
    }

    @GetMapping("/updateIngresoForm")
    public ModelAndView updateIngresoForm(@RequestParam Long ingresoId) {
        ModelAndView mav = new ModelAndView("add-ingreso");
        Ingreso ingAux = ingresoService.getIngresoById(ingresoId);
        Optional<Cliente> clienteAux = clienteRepo.findById(ingAux.getCliente_id().getId());


        mav.addObject("ingreso", ingAux);
        mav.addObject("clientes", clienteRepo.findAll());
        mav.addObject("proyectos", proyectoRepo.findAll());


        return mav;
    }

    @GetMapping("/deleteIngreso")
    public String deleteIngreso(@RequestParam Long ingresoId) {
        balanceService.deleteIngreso(ingresoId);
        ingresoService.deleteIngreso(ingresoId);
        return "redirect:/ingresos";
    }

}
