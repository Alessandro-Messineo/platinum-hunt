package org.lessons.java.platinum_hunt.service;

import java.util.List;

import org.lessons.java.platinum_hunt.model.Game;
import org.lessons.java.platinum_hunt.model.Trophy;
import org.lessons.java.platinum_hunt.repository.GameRepository;
import org.lessons.java.platinum_hunt.repository.TrophyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private TrophyRepository trophyRepository;
    
    public List<Game> findAll(){
        return gameRepository.findAll();
    }

    public Game findById(Integer id){
        return gameRepository.findById(id).get();
    }

    public Game save(Game game){
        return gameRepository.save(game);
    }

     public void delete(Integer id) {
       Game game = findById(id);

       for (Trophy trophy : game.getTrophies()) {
        trophyRepository.delete(trophy);
       }
       gameRepository.delete(game);
    }

    public boolean existsById(Integer id) {
        return gameRepository.existsById(id);
    }

    public List<Game> findByName(String name){
        return gameRepository.findByNameContainingIgnoreCase(name);
    }
}
