package constApp.web.controllers;

import constApp.web.DAO.BalanceDAO;
import constApp.web.DAO.GastoDAO;
import constApp.web.models.Balance;
import constApp.web.services.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BalanceController {

    @Autowired
    private BalanceService balanceService;


    @GetMapping({"/balance"})
    public ModelAndView getAllMovimientos() {
        ModelAndView mav = new ModelAndView("balance");
        List<Balance> allBalance = balanceService.getMovimientosSinNull();

        mav.addObject("balanceList", allBalance);

        return mav;
    }

}
