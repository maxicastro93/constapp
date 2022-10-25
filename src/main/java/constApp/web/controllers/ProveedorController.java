package constApp.web.controllers;

import constApp.web.DAO.ProveedorDAO;
import constApp.web.DAO.GastoDAO;
import constApp.web.models.Proveedor;
import constApp.web.services.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
@Controller
public class ProveedorController {

    @Autowired
    private GastoDAO gastosRepo;
    @Autowired
    private ProveedorService provService;

    @GetMapping({"/proveedores"})
    public ModelAndView getAllProveedores() {
        ModelAndView mav = new ModelAndView("proveedores");
        mav.addObject("proveedores", provService.getAllProv());
        return mav;
    }

    @GetMapping("/addProveedor")
    public ModelAndView addProveedor() {
        ModelAndView mav = new ModelAndView("add-proveedor");
        Proveedor newProveedor = new Proveedor();
        mav.addObject("proveedor", newProveedor);
//        mav.addObject("proveedor", provRepo.findAll());
        return mav;
    }

    @GetMapping("/detalleProveedor")
    public ModelAndView detalleProveedor(@RequestParam Long provId) {
        ModelAndView mav = new ModelAndView("detalle-proveedor");
        Proveedor proveedor = provService.getProvById(provId);
        mav.addObject("proveedor", proveedor);
        mav.addObject("movimientos", proveedor.getGastosProveedor());
        mav.addObject("acumulado", provService.totalGastadoPorProveedor(provId));
        mav.addObject("gastosGrafico", provService.listGastosProveedor(provId));



        return mav;
    }

    @PostMapping("/saveProveedor")
    public String saveProv(@ModelAttribute Proveedor proveedor) throws ParseException {

        provService.saveProveedor(proveedor);
        return "redirect:/proveedores";
    }

    @GetMapping("/showUpdateProv")
    public ModelAndView showUpdateProv(@RequestParam Long provId) {
        ModelAndView mav = new ModelAndView("add-proveedor");
        Proveedor proveedor = provService.getProvById(provId);
        mav.addObject("proveedor", proveedor);

        return mav;
    }

    @GetMapping("/deleteProveedor")
    public String deleteProveedor(@RequestParam Long provId) {
        provService.deleteProveedor(provId);
        return "redirect:/proveedores";
    }
}