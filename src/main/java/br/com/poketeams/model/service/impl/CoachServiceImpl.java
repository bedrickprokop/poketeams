package br.com.poketeams.model.service.impl;

import br.com.poketeams.App;
import br.com.poketeams.exception.ApplicationException;
import br.com.poketeams.model.dao.CoachDao;
import br.com.poketeams.model.entity.Coach;
import br.com.poketeams.model.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.core.Response;
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
        Coach coach = coachDao.findOne(coachId);
        if (null != coach) {
            return coach;
        }
        //TODO adicionar mensagem de texto em arquivo de mensagens
        throw new ApplicationException("Entity not found",
                Response.Status.NOT_FOUND.getStatusCode());
    }

    @Override
    public List<Coach> findAll() {
        return coachDao.findAll();
    }

    @Override
    public Coach update(Coach coach) {
        if (null != coach.getId()) {
            return coachDao.update(coach);
        }
        //TODO adicionar mensagem de texto em arquivo de mensagens
        throw new ApplicationException("Missing attribute to update",
                Response.Status.BAD_REQUEST.getStatusCode());
    }

    @Override
    public Coach delete(Long coachId) {
        Coach coach = coachDao.findOne(coachId);
        if (null != coach) {
            return coachDao.delete(coach);
        }
        //TODO adicionar mensagem de texto em arquivo de mensagens
        throw new ApplicationException("Entity not found",
                Response.Status.NOT_FOUND.getStatusCode());
    }
}
