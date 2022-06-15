package com.example.firsttryinheritance.model;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //This one is normally by default, so it is actually not necessary to write it
//The 2 next lines are to change the name of the column "dtype" to "persontype"
@DiscriminatorColumn(name = "PERSONTYPE", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Person") //This can be also added to each subclass
//
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

