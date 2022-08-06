package constApp.web.controllers;

import constApp.web.DAO.CuentaDAO;
import constApp.web.DAO.RubroDAO;
import constApp.web.models.Cuenta;
import constApp.web.models.Rubro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;

@Controller
public class CuentaController {

    @Autowired
    private CuentaDAO cuentaRepo;


    @GetMapping({"/cuentas"})
    public ModelAndView getAllCuentas() throws ParseException {

        ModelAndView mav = new ModelAndView("cuentas");

        mav.addObject("cuentas", cuentaRepo.findAll());

        return mav;
    }

    @GetMapping("/addCuentaForm")
    public ModelAndView addCuentaForm() {
        ModelAndView mav = new ModelAndView("add-cuenta");
        Cuenta cuenta = new Cuenta();
        mav.addObject("cuenta", cuenta);
        return mav;
    }

    @PostMapping("/saveCuenta")
    public String saveCuenta(@ModelAttribute Cuenta cuenta
                              ) throws ParseException {

        cuentaRepo.save(cuenta);
        return "redirect:/cuentas";
    }

    @GetMapping("/deleteCuenta")
    public String deleteCuenta(@RequestParam Long cuentaId) {
        cuentaRepo.deleteById(cuentaId);
        return "redirect:/cuentas";
    }

}
