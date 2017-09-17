package br.com.poketeams.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Creature {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @Column(name = "image_url")
    private String imageUrl;
    private String weight;
    private String height;

    @OneToMany(mappedBy = "creature", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Move> moveList;

    @JsonIgnore
    @ManyToMany(mappedBy = "creatureList")
    private List<Team> teamList;

    public Creature() {
    }

    public Creature(String name, String imageUrl, String weight, String height, List<Move> moveList, List<Team> teamList) {
        this(null, name, imageUrl, weight, height, moveList, teamList);
    }

    public Creature(Long id, String name, String imageUrl, String weight, String height, List<Move> moveList,
                    List<Team> teamList) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.weight = weight;
        this.height = height;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
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
