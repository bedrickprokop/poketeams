package br.com.poketeams.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.SerializedName;

import javax.persistence.*;
import java.util.List;

@Entity
public class Creature {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String url;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "creature_has_move",
            joinColumns = {@JoinColumn(name = "creature_id")},
            inverseJoinColumns = {@JoinColumn(name = "move_id")})
    private List<Move> moveList;

    @JsonIgnore
    @ManyToMany(mappedBy = "creatureList")
    private List<Team> teamList;

    public Creature() {
    }

    public Creature(String name, List<Move> moveList) {
        this(name, moveList, null);
    }

    public Creature(String name, List<Move> moveList, List<Team> teamList) {
        this(null, name, moveList, teamList);
    }

    public Creature(Long id, String name, List<Move> moveList, List<Team> teamList) {
        this.id = id;
        this.name = name;
        this.moveList = moveList;
        this.teamList = teamList;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Move> getMoveList() {
        return moveList;
    }

    public void setMoveList(List<Move> moveList) {
        this.moveList = moveList;
    }

    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }
}
