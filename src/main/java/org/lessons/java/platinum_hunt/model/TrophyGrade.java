package org.lessons.java.platinum_hunt.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "trophy_grades")
public class TrophyGrade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Enter name of grade")
    @Size(max = 20)
    @Column(nullable = false, length = 20)
    private String name;

    @Size(max = 300)
    @Column(length = 300)
    private String img;

    @OneToMany(mappedBy = "trophyGrade")
    @JsonManagedReference(value = "trophy-grade-trophies")
    private List<Trophy> trophies;

    public TrophyGrade() {
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