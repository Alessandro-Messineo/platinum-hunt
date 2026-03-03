package org.lessons.java.platinum_hunt.service;

import java.util.List;

import org.lessons.java.platinum_hunt.model.TrophyGrade;
import org.lessons.java.platinum_hunt.repository.TrophyGradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrophyGradeService {

    @Autowired
    private TrophyGradeRepository trophyGradeRepository;

    public List<TrophyGrade> findAll() {
        return trophyGradeRepository.findAll();
    }

}