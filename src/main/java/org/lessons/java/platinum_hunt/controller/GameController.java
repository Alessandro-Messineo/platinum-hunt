package org.lessons.java.platinum_hunt.controller;


import org.lessons.java.platinum_hunt.model.Game;
import org.lessons.java.platinum_hunt.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;





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

    @GetMapping("/create")
    public String create(Model model) {

        model.addAttribute("game", new Game());

        return "games/form-game";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("game") Game formGame, BindingResult bindingResult) {
        
        if(bindingResult.hasErrors()){
            return "games/form-game";
        }

        Game saved = gameService.save(formGame);
        return "redirect:/games/" + saved.getId();
    }
    
    
    
    
}
