package edu.stevens.friccobo;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Configuration
public class JerseyConfig extends ResourceConfig {

    @PostConstruct
    public void init(){
        register(JokeResource.class);
    }
}
