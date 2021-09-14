package com.sem1colon.buzzer.repository;

import com.sem1colon.buzzer.entity.Contest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContestRepository extends JpaRepository<Contest, String> {
}
