package com.idfinance.demo.controller;

import com.idfinance.demo.model.CustomerStatement;
import com.idfinance.demo.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.stream.StreamSupport;

@Controller
public class ControllerAdmin {
    @Autowired
    private CustomerRepo customerRepo;

    @GetMapping("/admin")
    public String customer(Model model){
        Iterable<CustomerStatement> customerAll = customerRepo.findAll();
        model.addAttribute("adminList", customerAll);

        long countDone = StreamSupport.stream(customerAll.spliterator(), false)
                .filter(customerStatement -> customerStatement.getStatus().equals("Accepted"))
                .count();

        long countDenied = StreamSupport.stream(customerAll.spliterator(), false)
                .filter(customerStatement -> customerStatement.getStatus().equals("Reject"))
                .count();

        model.addAttribute("done", countDone);
        model.addAttribute("denied", countDenied);

        return "admin";
    }


    @RequestMapping(value = "/change", method = RequestMethod.GET )
    @ResponseBody
    public String changeStatus(@RequestParam(value = "id", required = true) int id,
                               @RequestParam(value = "decision") String decision, Model model){

        CustomerStatement customerStatement = customerRepo.findById(id).orElse(new  CustomerStatement());
        customerStatement.setStatus(decision);
        customerRepo.save(customerStatement);
        return "Your request has been sent. Go to page /admin";
    }
}
