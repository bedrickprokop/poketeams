package br.com.poketeams.model.service.impl;

import br.com.poketeams.model.dao.CoachDao;
import br.com.poketeams.model.entity.Coach;
import br.com.poketeams.model.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CoachServiceImpl implements CoachService {

    @Autowired
    private CoachDao coachDao;

    @Override
    public Coach create(Coach coach) {
        return coachDao.create(coach);
    }

    @Override
    public Coach findOne(Long coachId) {
        return coachDao.findOne(coachId);
    }

    @Override
    public List<Coach> findAll() {
        return coachDao.findAll();
    }

    @Override
    public Coach update(Coach coach) {
        return coachDao.update(coach);
    }

    @Override
    public Coach delete(Long coachId) {
        Coach coach = coachDao.findOne(coachId);
        if (null != coach) {
            return coachDao.delete(coach);
        }
        throw new RuntimeException();
    }
}
