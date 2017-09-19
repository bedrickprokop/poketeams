package br.com.poketeams.model.service.impl;

import br.com.poketeams.model.dao.CreatureDao;
import br.com.poketeams.model.entity.Creature;
import br.com.poketeams.model.service.CreatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CreatureServiceImpl implements CreatureService {

    @Autowired
    private CreatureDao creatureDao;

    @Override
    public Creature create(Creature creature) {
        return creatureDao.create(creature);
    }

    @Override
    public Creature findOne(Long creatureId) {
        return null;
    }

    @Override
    public List<Creature> findAll() {
        return null;
    }

    @Override
    public Creature update(Creature creature) {
        return null;
    }

    @Override
    public Creature delete(Long creatureId) {
        return null;
    }
}
