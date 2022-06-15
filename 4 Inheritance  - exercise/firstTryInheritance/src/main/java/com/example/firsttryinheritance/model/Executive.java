package com.example.firsttryinheritance.model;

import javax.persistence.Entity;


@Entity
public class Executive extends Employee {
    //no attribute Id in this Entity because this is inherited from Person
    private double bonus;
    public Executive () {

    }
    public double getBonus() {
        return bonus;
    }
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
