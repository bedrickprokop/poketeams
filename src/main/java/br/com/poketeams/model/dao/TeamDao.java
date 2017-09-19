package br.com.poketeams.model.dao;

import br.com.poketeams.model.entity.Team;

import java.util.List;

public interface TeamDao extends GenericDao<Team> {

    List<Team> findAllByCoach(Long coachId);
}
