package com.idfinance.demo.controller;

import com.idfinance.demo.model.CustomerStatement;
import com.idfinance.demo.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class RESTCustCtrl {

    @Autowired
    private CustomerRepo customerRepo;

    @RequestMapping(value = "/sendStmt", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerStatement custStmt(CustomerStatement customerStatement){
        customerRepo.save(customerStatement);
        return customerStatement;
    }
}
