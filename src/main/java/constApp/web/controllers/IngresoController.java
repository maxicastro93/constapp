package constApp.web.controllers;

import constApp.web.DAO.*;
import constApp.web.Utils.Calculos;
import constApp.web.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class IngresoController {

    @Autowired
    private IngresoDAO ingresoRepo;
    @Autowired
    private ClienteDAO clienteRepo;

    private Calculos calculos;

    @GetMapping({"/ingresos"})
    public ModelAndView getAllIngresos() throws ParseException {

        ModelAndView mav = new ModelAndView("ingresos");
        BigDecimal acumuladoPesosMensual = new BigDecimal(0);
        BigDecimal acumuladoDolaresMensual = new BigDecimal(0);

        calculos = new Calculos();


        ArrayList<Ingreso> ingresoDolaresPeriodoActual = ingresoRepo.findByPeriodoAndMoneda(calculos.getPeriodoActual(), "Dolares");
        ArrayList<Ingreso> ingresoPesosPeriodoActual = ingresoRepo.findByPeriodoAndMoneda(calculos.getPeriodoActual(), "Pesos");

        for (Ingreso ingAux : ingresoDolaresPeriodoActual) {
            acumuladoDolaresMensual = acumuladoDolaresMensual.add(ingAux.getMonto());
        }
        for (Ingreso ingAux : ingresoPesosPeriodoActual) {
            acumuladoPesosMensual = acumuladoPesosMensual.add(ingAux.getMonto());
        }

        mav.addObject("ingresos", ingresoRepo.findAll());
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
        return mav;
    }

    @PostMapping("/saveIngreso")
    public String saveIngreso(@ModelAttribute Ingreso ingreso, @ModelAttribute Cliente cliente) throws ParseException {

        ingreso.setPeriodo(ingreso.getFecha());

        Optional<Cliente> clienteAux = clienteRepo.findById(ingreso.getCliente_id().getId());
        if (clienteAux.isPresent()) {
            clienteAux.get().getPagosCliente().add(ingreso);
            ingreso.setCliente_id(clienteAux.get());
            ingresoRepo.save(ingreso);
        }
        else{
            ingreso.setCliente_id(null);
            clienteAux.get().getPagosCliente().add(null);
            ingresoRepo.save(ingreso);
        }
        return "redirect:/ingresos";
    }

    @GetMapping("/updateIngresoForm")
    public ModelAndView updateIngresoForm(@RequestParam Long ingresoId) {
        ModelAndView mav = new ModelAndView("add-ingreso");
        Ingreso ingAux = ingresoRepo.findById(ingresoId).get();
//        ingAux.setCliente_id(null);
        mav.addObject("ingreso", ingAux);
        mav.addObject("clientes", clienteRepo.findAll());

        return mav;
    }

    @GetMapping("/deleteIngreso")
    public String deleteIngreso(@RequestParam Long ingresoId) {
        ingresoRepo.deleteById(ingresoId);
        return "redirect:/ingresos";
    }

}
