package com.example.firsttryassociations.model;

import javax.persistence.*;

@Entity
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(mappedBy = "passport")
    private Person passportnbr;

    public Passport() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPassportnbr() {
        return passportnbr;
    }

    public void setPassportnbr(Person passportnbr) {
        this.passportnbr = passportnbr;
    }
}
