package br.com.poketeams.model.dao.impl;

import br.com.poketeams.model.dao.MoveDao;
import br.com.poketeams.model.entity.Move;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MoveDaoImpl extends BaseDao<Move> implements MoveDao {

    @Override
    public Move create(Move entity) {
        return super.create(entity);
    }

    @Override
    public Move findOne(Long entityId) {
        return super.findOne(entityId);
    }

    @Override
    public List<Move> findAll() {
        return super.findAll();
    }

    @Override
    public Move update(Move entity) {
        return super.update(entity);
    }

    @Override
    public Move delete(Move entity) {
        return super.delete(entity);
    }
}
