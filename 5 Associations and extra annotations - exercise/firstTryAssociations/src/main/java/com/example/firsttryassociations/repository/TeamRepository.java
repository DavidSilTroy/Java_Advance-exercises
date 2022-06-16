package com.example.firsttryassociations.repository;

import com.example.firsttryassociations.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team,Long> {
}
