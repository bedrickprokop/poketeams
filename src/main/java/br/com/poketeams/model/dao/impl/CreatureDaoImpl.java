package br.com.poketeams.model.dao.impl;

import br.com.poketeams.model.dao.CreatureDao;
import br.com.poketeams.model.entity.Creature;

import java.util.List;

public class CreatureDaoImpl extends BaseDao<Creature> implements CreatureDao {

    @Override
    public Creature create(Creature entity) {
        return super.create(entity);
    }

    @Override
    public Creature findOne(Long entityId) {
        return super.findOne(entityId);
    }

    @Override
    public List<Creature> findAll() {
        return super.findAll();
    }

    @Override
    public Creature update(Creature entity) {
        return super.update(entity);
    }

    @Override
    public Creature delete(Creature entity) {
        return super.delete(entity);
    }
}
