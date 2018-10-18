package com.idfinance.demo.controller;

import com.idfinance.demo.model.*;
import com.idfinance.demo.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ControllerCustomer {

    @GetMapping ("/customer")
    public String customer(){
        return "customer";
    }
}
