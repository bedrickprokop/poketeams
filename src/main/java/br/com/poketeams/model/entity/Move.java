package br.com.poketeams.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.SerializedName;

import javax.persistence.*;
import java.util.List;

@Entity
public class Move {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "moveList")
    private List<Creature> creatureList;

    public Move() {
    }

    public Move(String name) {
        this(null, name);
    }

    public Move(Long id, String name) {
        this.id = id;
        this.name = name;
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

    public List<Creature> getCreatureList() {
        return creatureList;
    }

    public void setCreatureList(List<Creature> creatureList) {
        this.creatureList = creatureList;
    }
}
