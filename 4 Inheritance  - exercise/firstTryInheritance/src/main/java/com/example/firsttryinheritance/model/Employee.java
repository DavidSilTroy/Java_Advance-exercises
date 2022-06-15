package com.example.firsttryinheritance.model;

import javax.persistence.Entity;

@Entity
public class Employee extends Person {

    //no attribute Id in this Entity because this is inherited from Person
    private double salary;
    public Employee () {
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this. salary = salary;
    }
}
