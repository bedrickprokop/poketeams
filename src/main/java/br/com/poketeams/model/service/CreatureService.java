package br.com.poketeams.model.service;

import br.com.poketeams.model.entity.Creature;

import java.util.List;

public interface CreatureService {

    Creature create(Creature creature);

    Creature findOne(Long creatureId);

    List<Creature> findAll();
}
