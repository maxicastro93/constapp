package constApp.web.controllers;

import constApp.web.DAO.*;
import constApp.web.Utils.Calculos;
import constApp.web.models.Balance;
import constApp.web.models.Gasto;
import constApp.web.models.OrdenDeCompra;
import constApp.web.models.Proveedor;
import constApp.web.services.BalanceService;
import constApp.web.services.GastoService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class GastoController {

    @Autowired
    private GastoService gastoService;
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

    private Calculos calculo;

    @GetMapping({"/gastos"})
    public ModelAndView getGastos() {
        ModelAndView mav = new ModelAndView("gastos");
        ArrayList<Gasto> gastoAuxList = new ArrayList<>(gastoService.getAllGastos());
        mav.addObject("gastos", gastoAuxList);

        return mav;
    }


    @GetMapping("/addGastoForm")
    public ModelAndView addGastoForm() {
        ModelAndView mav = new ModelAndView("add-gasto");
        Gasto newGasto = new Gasto();
        mav.addObject("gasto", newGasto);
        mav.addObject("proveedores", provRepo.findAll());
        mav.addObject("ocs", ocRepo.findAll());
        mav.addObject("rubros", rubroRepo.findAll());
        mav.addObject("cuentas", cuentaRepo.findAll());


        return mav;
    }

    @PostMapping("/saveGasto")
    public String saveGasto(@ModelAttribute Gasto gasto, @ModelAttribute OrdenDeCompra oc, @ModelAttribute Balance balance) throws ParseException {

        Calculos calculo = new Calculos();

        gasto.setPeriodo(calculo.getPeriodoFromFecha(gasto.getFecha()));

        Gasto g = gastoService.retornaGastoActualizado(gasto);
        System.out.println(g.getId());
        balanceService.saveGasto(g);



        return "redirect:/gastos";
    }

    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam Long gastoId) {
        ModelAndView mav = new ModelAndView("add-gasto");
        Gasto gasto = gastoService.getGastoById(gastoId);
        mav.addObject("gasto", gasto);
        mav.addObject("proveedores", provRepo.findAll());
        mav.addObject("ocs", ocRepo.findAll());
        mav.addObject("rubros", rubroRepo.findAll());
        mav.addObject("cuentas", cuentaRepo.findAll());


        return mav;
    }

    @GetMapping("/deleteGasto")
    public String deleteGasto(@RequestParam Long gastoId) {

        balanceService.deleteGasto(gastoId);

        gastoService.deleteGasto(gastoId);

        return "redirect:/gastos";
    }
}