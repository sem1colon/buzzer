package com.sem1colon.buzzer.contestant;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContestantRepository extends JpaRepository<Contestant, String> {
}
