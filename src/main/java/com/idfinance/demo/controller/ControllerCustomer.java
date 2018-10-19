package com.idfinance.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.idfinance.demo.model.*;
import com.idfinance.demo.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
public class ControllerCustomer {

    @Autowired
    private CustomerRepo customerRepo;

    @GetMapping ("/customer")
    public String customer(){
        return "customer";
    }

    @RequestMapping (value = "/sendStmt", method = RequestMethod.GET)
    public String custStmt(@RequestParam(value = "json") String customStmt) throws IOException {
          ObjectMapper mapper = new ObjectMapper();
          CustomerStatement customerStatement = mapper.readValue(customStmt, CustomerStatement.class);
          customerRepo.save(customerStatement);
        return "customer";
    }

//    @RequestMapping (value = "/sendStmt", method = RequestMethod.GET)
//    public String custStmt(@RequestParam(value = "json") String customStmt) throws IOException {
//        ObjectMapper mapper = new ObjectMapper();
//        CustomerStatement customerStatement = mapper.readValue(customStmt, CustomerStatement.class);
//        customerRepo.save(customerStatement);
//        return "customer";
//    }
}
