package br.com.poketeams.model.service;

import br.com.poketeams.model.entity.Team;

import java.util.List;

public interface TeamService {

    Team create(Team team, Long coachId);

    Team findOne(Long teamId);

    List<Team> findAll(Long coachId);

    Team update(Team team);

    Team delete(Long teamId);

}
