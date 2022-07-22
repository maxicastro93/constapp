package constApp.web.controllers;

import constApp.web.DAO.BalanceDAO;
import constApp.web.DAO.GastoDAO;
import constApp.web.models.Balance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

public class BalanceController {

    @Autowired
    private BalanceDAO balanceRepo;


    @GetMapping({"/balance"})
    public ModelAndView getAllMovimientos() {
        ModelAndView mav = new ModelAndView("balanceList");
        mav.addObject("balanceList", balanceRepo.findAll());
        return mav;
    }

}
