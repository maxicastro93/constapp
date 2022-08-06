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
import java.util.Optional;

@Controller
public class RubroController {

    @Autowired
    private RubroDAO rubroRepo;


    @GetMapping({"/rubros"})
    public ModelAndView getAllRubros() throws ParseException {

        ModelAndView mav = new ModelAndView("rubros");

        mav.addObject("rubros", rubroRepo.findAll());

        return mav;
    }

    @GetMapping("/addRubroForm")
    public ModelAndView addRubroForm() {
        ModelAndView mav = new ModelAndView("add-rubro");
        Rubro rubro = new Rubro();
        mav.addObject("rubro", rubro);
        return mav;
    }

    @PostMapping("/saveRubro")
    public String saveRubro(@ModelAttribute Rubro rubro
                              ) throws ParseException {

        rubroRepo.save(rubro);
        return "redirect:/rubros";
    }

    @GetMapping("/deleteRubro")
    public String deleteRubro(@RequestParam Long rubroId) {
        rubroRepo.deleteById(rubroId);
        return "redirect:/rubros";
    }

}
