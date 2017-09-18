package br.com.poketeams.model.dao.impl;

import br.com.poketeams.model.dao.CoachDao;
import br.com.poketeams.model.entity.Coach;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CoachDaoImpl extends BaseDao<Coach> implements CoachDao {

    @Override
    public Coach create(Coach entity) {
        return super.create(entity);
    }

    @Override
    public Coach findOne(Long entityId) {
        return super.findOne(entityId);
    }

    @Override
    public List<Coach> findAll() {
        return super.findAll();
    }

    @Override
    public Coach update(Coach entity) {
        return super.update(entity);
    }

    @Override
    public Coach delete(Coach entity) {
        return super.delete(entity);
    }
}
