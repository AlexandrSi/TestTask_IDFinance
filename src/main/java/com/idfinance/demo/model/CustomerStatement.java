package com.idfinance.demo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "customer_statement")
public class CustomerStatement {

    public CustomerStatement(String request, float bid, Date dueDate) {
        this.request = request;
        this.bid = bid;
        this.dueDate = dueDate;
    }

    public CustomerStatement(){}

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private  long id;

    private  String request;

    private  float bid;

    private Date dueDate;

    private  Boolean status = false;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public float getBid() {
        return bid;
    }

    public void setBid(float bid) {
        this.bid = bid;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date due_date) {
        this.dueDate = due_date;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
