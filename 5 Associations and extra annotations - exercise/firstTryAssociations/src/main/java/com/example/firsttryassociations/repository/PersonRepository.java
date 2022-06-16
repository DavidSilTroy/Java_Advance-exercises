package com.example.firsttryassociations.repository;


import com.example.firsttryassociations.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
}
