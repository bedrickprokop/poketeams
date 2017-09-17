package br.com.poketeams.service;

import br.com.poketeams.App;
import br.com.poketeams.config.H2Config;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {App.class, H2Config.class})
@WebAppConfiguration
public class TeamServiceTest {
}
