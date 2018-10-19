package com.idfinance.demo.repository;


import com.idfinance.demo.model.CustomerStatement;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface CustomerRepo extends CrudRepository<CustomerStatement, Long> {

   List<CustomerStatement> findByRequestAndBidAndDueDate(String request, float bit, Date due_date);
}
