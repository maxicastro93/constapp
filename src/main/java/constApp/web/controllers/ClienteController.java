package constApp.web.controllers;
import constApp.web.DAO.ClienteDAO;
import constApp.web.DAO.IngresoDAO;
import constApp.web.DAO.ProveedorDAO;
import constApp.web.DAO.GastoDAO;
import constApp.web.models.Cliente;
import constApp.web.models.Ingreso;
import constApp.web.models.Proveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ClienteController {

    @Autowired
    private IngresoDAO ingresoRepo;
    @Autowired
    private ClienteDAO clienteRepo;

    @GetMapping({"/clientes"})
    public ModelAndView getAllClientes() {
        ModelAndView mav = new ModelAndView("clientes");
        List<Cliente> clAuxList = clienteRepo.findAll();
        for(Cliente cl : clAuxList){
            Cliente clAux = clienteRepo.findById(cl.getId()).get();
            clAux.actualizar_saldoPendiente();
            clienteRepo.save(clAux);
        }
//        clienteRepo.save(clienteAux.get());

        mav.addObject("clientes", clAuxList);
        return mav;
    }

    @GetMapping("/addCliente")
    public ModelAndView addCliente() {
        ModelAndView mav = new ModelAndView("add-cliente");
        Cliente newCliente = new Cliente();
        mav.addObject("cliente", newCliente);
        return mav;
    }
    @GetMapping("/verDetalleCliente")
    public ModelAndView verDetalleCliente(@RequestParam Long clienteId) {
        ModelAndView mav = new ModelAndView("vista-movimientos-cliente");
        Cliente cliente = clienteRepo.findById(clienteId).get();
        mav.addObject("cliente", cliente);
        mav.addObject("movimientos", cliente.getPagosCliente());
        mav.addObject("totalAdeudado", cliente.getSaldo_pendiente());

        return mav;
    }


    @PostMapping("/saveCliente")
    public String saveCliente(@ModelAttribute Cliente cliente) throws ParseException {

        // BUSCA SI YA EXISTE (ES DECIR, ESTA MODIFICANDO AL CLIENTE EXISTENTE), COMPRUEBA NUEVAMENTE TO DO SU SALDO, BUSCA LOS CONSUMOS
        // Y VUELVE A CALCULAR EL SALDO PENDIENTE.
        if (cliente.getId() != null && clienteRepo.findById(cliente.getId()).isPresent()){
            cliente.crearSaldo_pendiente(); // actualiza el saldo total inicial del cliente
            List<Ingreso> pagosDelCliente = cliente.getPagosCliente();
            for (Ingreso ingreso : pagosDelCliente) {
                cliente.actualizar_saldoPendiente();
            }
        }
        cliente.crearSaldo_pendiente(); // Ingresa el saldo total inicial del cliente
        System.out.println(cliente.getSaldo_pendiente());
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
