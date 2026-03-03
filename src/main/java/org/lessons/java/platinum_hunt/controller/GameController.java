package org.lessons.java.platinum_hunt.controller;

import org.lessons.java.platinum_hunt.model.Game;
import org.lessons.java.platinum_hunt.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/games")
public class GameController {
    
    @Autowired
    private GameService gameService;

    @GetMapping
    public String index(Model model) {

        model.addAttribute("games", gameService.findAll());
        return "games/index.html";
    }

    @GetMapping("/{id}")
    public String show(Model model, @PathVariable Integer id) {

        model.addAttribute("game", gameService.findById(id));

        return "games/detail-game";
    }

    
    
    
}
