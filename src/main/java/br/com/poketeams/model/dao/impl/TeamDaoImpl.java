package br.com.poketeams.model.dao.impl;

import br.com.poketeams.model.dao.TeamDao;
import br.com.poketeams.model.entity.Team;

import java.util.List;

public class TeamDaoImpl extends BaseDao<Team> implements TeamDao {

    @Override
    public Team create(Team entity) {
        return super.create(entity);
    }

    @Override
    public Team findOne(Long entityId) {
        return super.findOne(entityId);
    }

    @Override
    public List<Team> findAll() {
        return super.findAll();
    }

    @Override
    public Team update(Team entity) {
        return super.update(entity);
    }

    @Override
    public Team delete(Team entity) {
        return super.delete(entity);
    }
}
