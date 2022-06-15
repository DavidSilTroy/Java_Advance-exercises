package com.example.firsttryjpa.repository;

import com.example.firsttryjpa.model.Bread;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BreadRepository extends JpaRepository<Bread,Long> {
}
