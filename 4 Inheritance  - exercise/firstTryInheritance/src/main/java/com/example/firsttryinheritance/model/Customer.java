package com.example.firsttryinheritance.model;

import javax.persistence.Entity;

@Entity
public class Customer extends Person {
    //no attribute Id in this Entity because this is inherited from Person
    private double discount;
    public Customer () {
    }
    public double getDiscount () {
        return discount;
    }
    public void setDiscount (double discount) {
        this. discount = discount;
    }
}
