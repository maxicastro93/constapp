package constApp.web.controllers;
import constApp.web.DAO.ClienteDAO;
import constApp.web.DAO.IngresoDAO;
import constApp.web.DAO.ProyectoDAO;
import constApp.web.models.Cliente;
import constApp.web.models.Ingreso;
import constApp.web.models.Proyecto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.util.List;

@Controller
public class ProyectoController {

    @Autowired
    private ProyectoDAO proyectoRepo;


    @GetMapping({"/proyectos"})
    public ModelAndView getAllProyectos() {
        ModelAndView mav = new ModelAndView("proyectos");
        List<Proyecto> proyectosList = proyectoRepo.findAll();

        mav.addObject("proyectos", proyectosList);
        return mav;
    }

    @GetMapping("/addProyecto")
    public ModelAndView addProyecto() {
        ModelAndView mav = new ModelAndView("add-proyecto");
        Proyecto newProyecto = new Proyecto();
        mav.addObject("proyecto", newProyecto);
        return mav;
    }

//    @GetMapping("/verDetalleCliente")
//    public ModelAndView verDetalleCliente(@RequestParam Long clienteId) {
//        ModelAndView mav = new ModelAndView("vista-movimientos-cliente");
//        Cliente cliente = clienteRepo.findById(clienteId).get();
//        mav.addObject("cliente", cliente);
//        mav.addObject("movimientos", cliente.getPagosCliente());
//        mav.addObject("totalAdeudado", cliente.getSaldo_pendiente());
//
//        return mav;
//    }


    @PostMapping("/saveProyecto")
    public String saveProyecto(@ModelAttribute Proyecto proyecto) throws ParseException {

        proyectoRepo.save(proyecto);
        return "redirect:/proyectos";
    }

    @GetMapping("/showUpdateProyecto")
    public ModelAndView showUpdateCliente(@RequestParam Long proyectoId) {
        ModelAndView mav = new ModelAndView("add-proyecto");
        Proyecto proyecto = proyectoRepo.findById(proyectoId).get();
        mav.addObject("proyecto", proyecto);

        return mav;
    }

    @GetMapping("/deleteProyecto")
    public String deleteProyectyo(@RequestParam Long proyectoId) {
        proyectoRepo.deleteById(proyectoId);
        return "redirect:/proyectos";
    }

}
