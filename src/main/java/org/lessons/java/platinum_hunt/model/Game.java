package org.lessons.java.platinum_hunt.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Enter name of game")
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String name;

    @NotNull(message = "Enter difficulty")
    @Min(value = 1, message = "Difficulty must be at least 1")
    @Max(value = 10, message = "Difficulty must be at most 10")
    @Column(nullable = false)
    private Integer difficulty;

    @NotNull(message = "Enter hours")
    @Min(value = 1, message = "Hours must be at least 1")
    @Column(nullable = false)
    private Integer hours;

    @NotNull(message = "Enter playthrough")
    @Min(value = 1, message = "Playthrough must be at least 1")
    @Column(nullable = false)
    private Integer playthrough;

    @Size(max = 300)
    @Column(length = 300)
    private String img;

    @OneToMany(mappedBy = "game")
    private List<Trophy> trophies;

    public Game() {
    }

    public Game(Integer id, String name, Integer difficulty, Integer hours, Integer playthrough, String img) {
        this.id = id;
        this.name = name;
        this.difficulty = difficulty;
        this.hours = hours;
        this.playthrough = playthrough;
        this.img = img;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDifficulty() {
        return this.difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getHours() {
        return this.hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Integer getPlaythrough() {
        return this.playthrough;
    }

    public void setPlaythrough(Integer playthrough) {
        this.playthrough = playthrough;
    }

    public String getImg() {
        return this.img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public List<Trophy> getTrophies() {
        return this.trophies;
    }

    public void setTrophies(List<Trophy> trophies) {
        this.trophies = trophies;
    }
}
