package br.com.poketeams.model.service;

import br.com.poketeams.model.entity.Coach;

import java.util.List;

public interface CoachService {

    Coach create(Coach coach);

    Coach findOne(Long coachId);

    List<Coach> findAll();

    Coach update(Coach coach);

    Coach delete(Long coachId);
}
