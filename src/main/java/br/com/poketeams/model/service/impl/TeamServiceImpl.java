package br.com.poketeams.model.service.impl;

import br.com.poketeams.exception.ApplicationException;
import br.com.poketeams.model.dao.CoachDao;
import br.com.poketeams.model.dao.TeamDao;
import br.com.poketeams.model.entity.Coach;
import br.com.poketeams.model.entity.Team;
import br.com.poketeams.model.service.TeamService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;

@Service
@Transactional
public class TeamServiceImpl implements TeamService {

    @Inject
    private TeamDao teamDao;

    @Inject
    private CoachDao coachDao;

    @Override
    public Team create(Team team, Long coachId) {
        if (null != coachId) {
            Coach coach = coachDao.findOne(coachId);
            if (null != coach) {
                team.setCoach(coach);
                return teamDao.create(team);
            }
            throw new ApplicationException("Entity not found",
                    Response.Status.NOT_FOUND.getStatusCode());
        }
        throw new ApplicationException("Missing attribute to create",
                Response.Status.BAD_REQUEST.getStatusCode());
    }

    @Override
    public Team findOne(Long teamId) {
        Team team = teamDao.findOne(teamId);
        if (null != team) {
            return team;
        }
        throw new ApplicationException("Entity not found",
                Response.Status.NOT_FOUND.getStatusCode());
    }

    @Override
    public List<Team> findAll(Long coachId) {
        if (null != coachId) {
            return teamDao.findAllByCoach(coachId);
        }
        throw new ApplicationException("Missing attribute to find",
                Response.Status.BAD_REQUEST.getStatusCode());
    }

    @Override
    public Team update(Team team) {
        if (null != team.getId()) {
            return teamDao.update(team);
        }
        throw new ApplicationException("Missing attribute to update",
                Response.Status.BAD_REQUEST.getStatusCode());
    }

    @Override
    public Team delete(Long teamId) {
        Team team = teamDao.findOne(teamId);
        if (null != team) {
            return teamDao.delete(team);
        }
        throw new ApplicationException("Entity not found",
                Response.Status.NOT_FOUND.getStatusCode());
    }
}
