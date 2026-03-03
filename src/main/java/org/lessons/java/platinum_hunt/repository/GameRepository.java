package org.lessons.java.platinum_hunt.repository;

import org.lessons.java.platinum_hunt.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Integer>{
    
}
