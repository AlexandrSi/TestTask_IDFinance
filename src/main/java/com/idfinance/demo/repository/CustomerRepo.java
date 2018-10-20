package com.idfinance.demo.repository;


import com.idfinance.demo.model.CustomerStatement;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface CustomerRepo extends CrudRepository<CustomerStatement, Integer> {

   List<CustomerStatement> findByRequestAndBidAndDueDate(String request, BigDecimal bid, Date dueDate);

}
