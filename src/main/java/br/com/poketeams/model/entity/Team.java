package br.com.poketeams.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "coach_id")
    private Coach coach;

    @ManyToMany
    @JoinTable(name = "team_has_creature",
            joinColumns = {@JoinColumn(name = "team_id")},
            inverseJoinColumns = {@JoinColumn(name = "creature_id")})
    private List<Creature> creatureList;

    public Team() {
    }

    public Team(String name, Coach coach, List<Creature> creatureList) {
        this(null, name, coach, creatureList);
    }

    public Team(Long id, String name, Coach coach, List<Creature> creatureList) {
        this.id = id;
        this.name = name;
        this.coach = coach;
        this.creatureList = creatureList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }
}
