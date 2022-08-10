package constApp.web.controllers;

import constApp.web.DAO.OCDetalleDAO;
import constApp.web.DAO.OrdenDeCompraDAO;
import constApp.web.DAO.ProveedorDAO;
import constApp.web.Utils.OCDetalleListDto;
import constApp.web.models.OCDetalle;
import constApp.web.models.OrdenDeCompra;
import constApp.web.models.Proveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OCController {

    @Autowired
    private OrdenDeCompraDAO ocRepo;
    @Autowired
    private OCDetalleDAO ocDetRepo;
    @Autowired
    private ProveedorDAO provRepo;

    @GetMapping({"/oc"})
    public ModelAndView getAllOC() {
        ModelAndView mav = new ModelAndView("oc");
        mav.addObject("oc", ocRepo.findAll());
        return mav;
    }


    @GetMapping("/addOc")
    public ModelAndView addOC() {
        ModelAndView mav = new ModelAndView("add-oc");
        OrdenDeCompra newOC = new OrdenDeCompra();
        OCDetalleListDto listOCdet = new OCDetalleListDto();

        for (int i = 0; i < 15; i++) {
            listOCdet.addOCDetalle(new OCDetalle());
        }
        System.out.println(listOCdet.getOcDetalleList().size());

        mav.addObject("proveedores", provRepo.findAll());
        mav.addObject("oc", newOC);
        mav.addObject("ocdetallelist", listOCdet);
        return mav;
    }

    @PostMapping(value = "/saveOC")
    public String saveOC(@ModelAttribute OrdenDeCompra oc, @ModelAttribute OCDetalleListDto ocdetallelist, Model model) {

        OCDetalleListDto ocDetalleListAux = new OCDetalleListDto();

        // Agarra el array y borra los elementos vacios
        for (OCDetalle ocdetaux : ocdetallelist.getOcDetalleList()) {
            if (ocdetaux.getDetalle() != "") {
                oc.agregarDetalle(ocdetaux);
                ocDetalleListAux.getOcDetalleList().add(ocdetaux);
            }
        }
            // guarda el array sin los vacios en la base de datos
            ocDetRepo.saveList(ocDetalleListAux.getOcDetalleList());
            model.addAttribute("ocdetalles", ocDetRepo.findAll());
            System.out.println(oc.getFecha());
            System.out.println(oc.getMontototal());
//        Proveedor provAux = provRepo.findById(gasto.getProv_id()).get();
//        gasto.setProveedor_id(provAux);
            ocRepo.save(oc);

            return "redirect:/oc";
    }

    @GetMapping("/UpdateOC")
    public ModelAndView showUpdateFormOC(@RequestParam Long ocId) {
        ModelAndView mav = new ModelAndView("add-oc");
        OrdenDeCompra oc = ocRepo.findById(ocId).get();
        mav.addObject("oc", oc);
        mav.addObject("ocdetallelist", oc.getDetalleOC());
        mav.addObject("proveedores", provRepo.findAll());
        return mav;
    }

    @GetMapping("/detalleOC")
    public ModelAndView verDetalleOC(@RequestParam Long ocId) {
        ModelAndView mav = new ModelAndView("vista-detalle-oc");
        OrdenDeCompra oc = ocRepo.findById(ocId).get();
        mav.addObject("oc", oc);
        mav.addObject("ocdetalle", oc.getDetalleOC());
        mav.addObject("proveedores", provRepo.findAll());
        return mav;
    }

    @GetMapping("/deleteOC")
    public String deleteOC(@RequestParam Long ocId) {
        OrdenDeCompra oc = ocRepo.findById(ocId).get();

        ocRepo.deleteById(ocId);

        return "redirect:/oc";
    }
}
