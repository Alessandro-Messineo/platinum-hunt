package org.lessons.java.platinum_hunt.controller;

import org.lessons.java.platinum_hunt.model.Trophy;
import org.lessons.java.platinum_hunt.service.GameService;
import org.lessons.java.platinum_hunt.service.TrophyGradeService;
import org.lessons.java.platinum_hunt.service.TrophyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/trophies")
public class TrophyController {

    @Autowired
    private TrophyService trophyService;

    @Autowired
    private GameService gameService;

    @Autowired
    private TrophyGradeService trophyGradeService;

    @GetMapping("/create/{id}")
    public String create(@PathVariable Integer id, Model model) {
        Trophy trophy = new Trophy();
        trophy.setGame(gameService.findById(id));

        model.addAttribute("trophy", trophy);
        model.addAttribute("grades", trophyGradeService.findAll());
        model.addAttribute("edit", false);

        return "trophies/form-trophy";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("trophy") Trophy formTrophy, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("grades", trophyGradeService.findAll());
            return "trophies/form-trophy";
        }

        Trophy saved = trophyService.save(formTrophy);

        Integer gameId = saved.getGame().getId();

        return "redirect:/games/" + gameId;
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Trophy trophy = trophyService.findById(id);

        model.addAttribute("trophy", trophy);
        model.addAttribute("grades", trophyGradeService.findAll());
        model.addAttribute("edit", true);

        return "trophies/form-trophy";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable Integer id, @Valid @ModelAttribute("trophy") Trophy formTrophy,
            BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("grades", trophyGradeService.findAll());
            model.addAttribute("edit", true);
            return "trophies/form-trophy";
        }

        Trophy saved = trophyService.save(formTrophy);

        Integer gameId = saved.getGame().getId();

        return "redirect:/games/" + gameId;
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {

        Trophy trophy = trophyService.findById(id);

        Integer gameId = trophy.getGame().getId();

        trophyService.delete(id);
        
        return "redirect:/games/" + gameId;
    }
}