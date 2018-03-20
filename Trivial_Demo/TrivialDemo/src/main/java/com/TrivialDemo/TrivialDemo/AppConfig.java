package com.TrivialDemo.TrivialDemo;

import com.TrivialDemo.TrivialDemo.entities.classes.BaseballGame;
import com.TrivialDemo.TrivialDemo.entities.classes.Cubs;
import com.TrivialDemo.TrivialDemo.entities.classes.RedSox;
import com.TrivialDemo.TrivialDemo.entities.interfaces.Game;
import com.TrivialDemo.TrivialDemo.entities.interfaces.Team;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

@Configuration
@Import(InfrastructureConfig.class)
public class AppConfig {

    /**
     * This treats all beans as
     */

    @Bean
    public Game game(DataSource dataSource) {
        BaseballGame baseballGame = new BaseballGame(redSox(), cubs());
        baseballGame.setDataSource(dataSource);
        return baseballGame;
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
