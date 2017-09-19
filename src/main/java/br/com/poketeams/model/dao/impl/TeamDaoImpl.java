package br.com.poketeams.model.dao.impl;

import br.com.poketeams.model.dao.TeamDao;
import br.com.poketeams.model.entity.Coach;
import br.com.poketeams.model.entity.Team;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
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

    @Override
    public List<Team> findAllByCoach(Long coachId) {
        String strQuery = "SELECT t FROM Team t WHERE t.coach.id = " + coachId;
        TypedQuery<Team> typedQuery = entityManager.createQuery(strQuery, Team.class);
        return typedQuery.getResultList();
    }
}
