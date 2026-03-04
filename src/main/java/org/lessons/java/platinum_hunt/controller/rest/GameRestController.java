package org.lessons.java.platinum_hunt.controller.rest;

import java.util.List;

import org.lessons.java.platinum_hunt.model.Game;
import org.lessons.java.platinum_hunt.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/games")
public class GameRestController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<Game>> index() {

        List<Game> games = gameService.findAll();

        return new ResponseEntity<>(games, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> show(@PathVariable Integer id) {

        if (!gameService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Game game = gameService.findById(id);
        
        return new ResponseEntity<>(game, HttpStatus.OK);
    }
}
