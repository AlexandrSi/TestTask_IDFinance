package com.idfinance.demo.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "customer_statement")
public class CustomerStatement {

    public CustomerStatement(String request, BigDecimal bid, Date dueDate) {
        this.request = request;
        this.bid = bid;
        this.dueDate = dueDate;
    }

    public CustomerStatement(){}

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private  int id;

    private  String request;

    private BigDecimal bid;

    @Type(type = "date")
    private Date dueDate;

    private  Boolean status = false;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public BigDecimal getBid() {
        return bid;
    }

    public void setBid(BigDecimal bid) {
        this.bid = bid;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
