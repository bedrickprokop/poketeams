package br.com.poketeams.model.service.impl;

import br.com.poketeams.model.dao.CreatureDao;
import br.com.poketeams.model.dao.MoveDao;
import br.com.poketeams.model.entity.Move;
import br.com.poketeams.model.service.MoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MoveServiceImpl implements MoveService {

    @Autowired
    private MoveDao moveDao;

    @Override
    public Move create(Move move) {
        return moveDao.create(move);
    }

    @Override
    public Move findOne(Long moveId) {
        return null;
    }

    @Override
    public List<Move> findAll() {
        return null;
    }

    @Override
    public Move update(Move move) {
        return null;
    }

    @Override
    public Move delete(Long moveId) {
        return null;
    }
}
