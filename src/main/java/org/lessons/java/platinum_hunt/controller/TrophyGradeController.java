package org.lessons.java.platinum_hunt.controller;

import org.lessons.java.platinum_hunt.service.TrophyGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/trophy-grades")
public class TrophyGradeController {

    @Autowired
    private TrophyGradeService trophyGradeService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("grades", trophyGradeService.findAll());
        return "trophy-grades/index";
    }

}