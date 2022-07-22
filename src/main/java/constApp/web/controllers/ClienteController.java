package constApp.web.controllers;
import constApp.web.DAO.ClienteDAO;
import constApp.web.DAO.IngresoDAO;
import constApp.web.DAO.ProveedorDAO;
import constApp.web.DAO.GastoDAO;
import constApp.web.models.Cliente;
import constApp.web.models.Proveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
@Controller
public class ClienteController {

    @Autowired
    private IngresoDAO ingresoRepo;
    @Autowired
    private ClienteDAO clienteRepo;

    @GetMapping({"/clientes"})
    public ModelAndView getAllClientes() {
        ModelAndView mav = new ModelAndView("clientes");
        mav.addObject("clientes", clienteRepo.findAll());
        return mav;
    }

    @GetMapping("/addCliente")
    public ModelAndView addCliente() {
        ModelAndView mav = new ModelAndView("add-cliente");
        Cliente newCliente = new Cliente();
        mav.addObject("cliente", newCliente);
//        mav.addObject("proveedor", provRepo.findAll());
        return mav;
    }
    @PostMapping("/saveCliente")
    public String saveCliente(@ModelAttribute Cliente cliente) throws ParseException {

        clienteRepo.save(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/showUpdateCliente")
    public ModelAndView showUpdateCliente(@RequestParam Long clienteId) {
        ModelAndView mav = new ModelAndView("add-cliente");
        Cliente cliente = clienteRepo.findById(clienteId).get();
        mav.addObject("cliente", cliente);

        return mav;
    }

    @GetMapping("/deleteCliente")
    public String deleteCliente(@RequestParam Long clienteId) {
        clienteRepo.deleteById(clienteId);
        return "redirect:/clientes";
    }

}
