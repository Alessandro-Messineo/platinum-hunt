package org.lessons.java.platinum_hunt.service;

import java.util.List;
import org.lessons.java.platinum_hunt.model.Trophy;
import org.lessons.java.platinum_hunt.repository.TrophyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrophyService {

    @Autowired
    private TrophyRepository trophyRepository;

    public List<Trophy> findAll() {
        return trophyRepository.findAll();
    }

    public Trophy findById(Integer id) {
        return trophyRepository.findById(id).get();
    }

    public Trophy save(Trophy trophy) {
        return trophyRepository.save(trophy);
    }

    public void delete(Integer id) {
        trophyRepository.deleteById(id);
    }

}