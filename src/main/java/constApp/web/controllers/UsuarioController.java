package constApp.web.controllers;

import constApp.web.DAO.RubroDAO;
import constApp.web.DAO.UsuarioDAO;
import constApp.web.Utils.JWTUtil;
import constApp.web.models.Rubro;
import constApp.web.models.Usuario;
import constApp.web.services.SecurityService;
import constApp.web.services.UserService;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.util.*;

@Controller
public class UsuarioController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

//    @GetMapping({"/", "login"})
//    public ModelAndView login(){
//
//        ModelAndView mav = new ModelAndView("login");
//
//        return mav;
//    }
    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (securityService.isAuthenticated()) {
            return "redirect:/home";
        }

        if (error != null)
            model.addAttribute("error", "Usuario o contraseña incorrectos.");

        if (logout != null)
            model.addAttribute("message", "Has sido logeado correctamente.");

        return "login";
    }




//    @GetMapping("/addUsuario")
    @GetMapping("/registrarse")
    public String registration(Model model) {
        if (securityService.isAuthenticated()) {
            return "redirect:/";
        }

        model.addAttribute("usuario", new Usuario());

        return "registrarse";
    }
//    public ModelAndView addUsuario() {
//        ModelAndView mav = new ModelAndView("registrarse");
//        if (securityService.isAuthenticated()) {
//            return "redirect:/";
//        }
//
//        Usuario usuario = new Usuario();
//        mav.addObject("usuario", usuario);
//        return mav;
//    }

//    @PostMapping("/saveUsuario")
//    public String saveUsuario(@ModelAttribute Usuario usuario){
//
//        usuarioRepo.save(usuario);
//        return "redirect:/login";
//    }

    @PostMapping("/registrarse")
    public String registration(@ModelAttribute("usuario") Usuario usuario, BindingResult bindingResult) {
        userValidator.validate(usuario, bindingResult);

        if (bindingResult.hasErrors()) {
            System.out.println("Entro aca");
            return "registrarse";
        }

        userService.save(usuario);

        securityService.autoLogin(usuario.getUsername(), usuario.getPassword());

        return "redirect:/home";
    }

}
