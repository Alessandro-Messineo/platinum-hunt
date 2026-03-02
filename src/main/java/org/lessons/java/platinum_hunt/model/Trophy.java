package org.lessons.java.platinum_hunt.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "trophies")
public class Trophy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Enter name of trophy")
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String name;

    @NotBlank(message = "Enter description of trophy")
    @Size(max = 300)
    @Column(nullable = false, length = 300)
    private String description;

    @NotNull(message = "Enter percentage")
    @DecimalMin(value = "0.0", inclusive = true, message = "Percentage must be at least 0")
    @DecimalMax(value = "100.0", inclusive = true, message = "Percentage must be at most 100")
    @Column(nullable = false)
    private Double percentage;
 
    @ManyToOne
    @JoinColumn(name = "trophy_grade_id", nullable = false)
    private TrophyGrade trophyGrade;

    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    public Trophy() {
    }

    public Trophy(Integer id, String name, String description, Double percentage, TrophyGrade trophyGrade, Game game) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.percentage = percentage;
        this.trophyGrade = trophyGrade;
        this.game = game;
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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPercentage() {
        return this.percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public TrophyGrade getTrophyGrade() {
        return this.trophyGrade;
    }

    public void setTrophyGrade(TrophyGrade trophyGrade) {
        this.trophyGrade = trophyGrade;
    }

    public Game getGame() {
        return this.game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}