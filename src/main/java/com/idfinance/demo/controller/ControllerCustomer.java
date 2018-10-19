package com.idfinance.demo.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.idfinance.demo.model.*;
import com.idfinance.demo.repository.CustomerRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ControllerCustomer {

    @Autowired
    private CustomerRepo customerRepo;

    @GetMapping ("/customer")
    public String customer(){
        return "customer";
    }

    @RequestMapping (value = "/sendStmt", method = RequestMethod.GET)
    public String custStmt(@RequestParam(value = "json") String customStmt) throws IOException, ParseException {
          ObjectMapper mapper = new ObjectMapper();
          JsonNode rootNode = mapper.readValue(customStmt, JsonNode.class);
          CustomerStatement customerStatement = new CustomerStatement();
          customerStatement.setRequest(rootNode.get("request").asText());
          customerStatement.setBid(rootNode.get("bid").floatValue());
          String dateStr =  rootNode.get("due_date").asText();
          String pattern = "yyyy-MM-dd";
          SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
          Date date = simpleDateFormat.parse(dateStr);
          customerStatement.setDueDate(date);

          customerRepo.save(customerStatement);
        return "customer";
    }

    @RequestMapping (value = "/checkStatus", method = RequestMethod.GET)
    public String checkStatus(@RequestParam(value = "json") String customStmt) throws IOException, ParseException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readValue(customStmt, JsonNode.class);
        CustomerStatement customerStatement = new CustomerStatement();
        customerStatement.setRequest(rootNode.get("request").asText());
        customerStatement.setBid(rootNode.get("bid").floatValue());
        String dateStr =  rootNode.get("due_date").asText();
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = simpleDateFormat.parse(dateStr);
        customerStatement.setDueDate(date);

        List<CustomerStatement> controllerCustomers = customerRepo.findByRequestAndBidAndDueDate(customerStatement.getRequest(),
                customerStatement.getBid(), customerStatement.getDueDate());
        return "customer";
    }
}
