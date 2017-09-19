package br.com.poketeams.config;

import br.com.poketeams.endpoint.CoachEndpoint;
import br.com.poketeams.endpoint.CreatureEndpoint;
import br.com.poketeams.endpoint.TeamEndpoint;
import br.com.poketeams.exception.ApplicationExceptionMapper;
import br.com.poketeams.exception.ValidationExceptionMapper;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("api")
public class JerseyRestConfig extends ResourceConfig {

    @PostConstruct
    private void init() {
        registerControllers();
        registerMappers();
    }

    private void registerControllers() {
        registerClasses(CoachEndpoint.class, CreatureEndpoint.class, TeamEndpoint.class);
    }

    private void registerMappers() {
        registerClasses(ApplicationExceptionMapper.class,
                ValidationExceptionMapper.class);
    }
}
