package br.com.poketeams.service;

import br.com.poketeams.App;
import br.com.poketeams.config.H2Config;
import br.com.poketeams.exception.ApplicationException;
import br.com.poketeams.model.entity.Coach;
import br.com.poketeams.model.service.CoachService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {App.class, H2Config.class})
@WebAppConfiguration
public class CoachServiceTest {

    @Autowired
    private CoachService coachService;

    private Coach coach1;
    private Coach coach2;

    @Before
    public void setup() {
        coach1 = new Coach("Coach1");
        coach2 = new Coach("Coach2");
    }

    @Test
    public void create() {
        coach1 = coachService.create(coach1);
        Assert.assertNotNull(coach1.getId());
    }

    @Test
    public void findOne() {
        coach1 = coachService.create(coach1);
        coach2 = coachService.findOne(coach1.getId());

        Assert.assertNotNull(coach2);
        Assert.assertEquals(coach1.getId(), coach2.getId());
    }

    @Test
    public void findAll() {
        coach1 = coachService.create(coach1);
        coach2 = coachService.create(coach2);

        List<Coach> all = coachService.findAll();
        Assert.assertTrue(all.size() > 0);
    }

    @Test
    public void update() {
        coach1 = coachService.create(coach1);
        coach1.setName("LALAL");

        coach1 = coachService.update(coach1);

        Assert.assertEquals("LALAL", coach1.getName());
    }

    @Test
    public void delete() {
        Coach coach = coachService.create(coach1);
        long coachId = coach.getId();

        coach = coachService.delete(coachId);

        try {
            coachService.findOne(coach.getId());
            Assert.assertFalse(false);
        } catch (ApplicationException e) {
            Assert.assertTrue(true);
        }
    }

}
