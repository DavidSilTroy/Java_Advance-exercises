package com.example.firsttryassociations.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private  String name;

    @OneToOne(cascade={CascadeType.ALL})
    private Passport passport;

    @ManyToOne
    private Team team;

    @OneToMany
    private List<Phone> phonenbrs = new ArrayList<>(); // Always instantiate that collection immediately

    @ManyToMany
    private List<Course> courses = new ArrayList<>();

    public Person() {
    }

    public void  addPhonenbr(String type, String number){
        Phone phone = new Phone();
        phone.setType(type);
        phone.setNumber(number);
        this.phonenbrs.add(phone);
    }

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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<Phone> getPhonenbrs() {
        return phonenbrs;
    }

    public void setPhonenbrs(List<Phone> phonenbrs) {
        this.phonenbrs = phonenbrs;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString(){
        return name;
    }
}
