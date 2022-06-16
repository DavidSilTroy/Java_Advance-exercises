package com.example.firsttryinheritance.model;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@MappedSuperclass
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE) //this is IMPORTANT for TABLE_PER_CLASS
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

