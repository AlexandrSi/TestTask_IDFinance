package com.idfinance.demo.repository;


import com.idfinance.demo.model.CustomerStatement;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepo extends CrudRepository<CustomerStatement, Long> {
}
