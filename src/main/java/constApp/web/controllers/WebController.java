package constApp.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;

@Controller
public class WebController {

    @GetMapping({"/"})
    public String inicio(Model model) {

        return "redirect:/home";
    }
    @GetMapping("/home")
    public ModelAndView home() {

        ModelAndView mav = new ModelAndView("home");


        return mav;
    }

    @GetMapping("/accessdenied")
    public ModelAndView restricted() {

        ModelAndView mav = new ModelAndView("404");


        return mav;
    }

}
