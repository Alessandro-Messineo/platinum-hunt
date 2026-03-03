package org.lessons.java.platinum_hunt.service;

import java.util.List;

import org.lessons.java.platinum_hunt.model.Game;
import org.lessons.java.platinum_hunt.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;
    
    public List<Game> findAll(){
        return gameRepository.findAll();
    }

  
}
