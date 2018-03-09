package com.TrivialDemo.TrivialDemo;

import com.TrivialDemo.TrivialDemo.entities.classes.BaseballGame;
import com.TrivialDemo.TrivialDemo.entities.classes.Cubs;
import com.TrivialDemo.TrivialDemo.entities.classes.RedSox;
import com.TrivialDemo.TrivialDemo.entities.interfaces.Game;
import com.TrivialDemo.TrivialDemo.entities.interfaces.Team;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Game game() {
        return new BaseballGame(redSox(), cubs());
    }

    @Bean
    public Team redSox() {
        return new RedSox();
    }

    @Bean
    public Team cubs() {
        return new Cubs();
    }

}
