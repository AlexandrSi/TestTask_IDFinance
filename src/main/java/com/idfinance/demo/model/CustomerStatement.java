package com.idfinance.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class CustomerStatement {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private  long id;

    private  String request;

    private  float bid;

    private Date due_date;

    private  Boolean status = false;

    public CustomerStatement(String request, float bid, Date due_date) {
        this.id = id;
        this.request = request;
        this.bid = bid;
        this.due_date = due_date;
        this.status = status;
    }

    public CustomerStatement(){}

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

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
