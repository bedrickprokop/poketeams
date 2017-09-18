package br.com.poketeams.model.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Coach {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //TODO adicionar mensagem de texto em arquivo de mensagens
    @NotNull(message = "Name cannot be empty")
    @Length(min = 3, max = 20, message = "Name should "
            + "be between 3 to 20 characters")
    private String name;

    @OneToMany(mappedBy = "coach", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Team> teamList;

    public Coach() {
    }

    public Coach(String name) {
        this(name, null);
    }

    public Coach(String name, List<Team> teamList) {
        this(null, name, teamList);
    }

    public Coach(Long id, String name, List<Team> teamList) {
        this.id = id;
        this.name = name;
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

    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }
}
