package com.TrivialDemo.TrivialDemo;

import com.TrivialDemo.TrivialDemo.entities.classes.BaseballGame;
import com.TrivialDemo.TrivialDemo.entities.interfaces.Game;
import com.TrivialDemo.TrivialDemo.entities.interfaces.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

@Configuration
@ComponentScan(basePackages = "com.TrivialDemo")
public class AppConfig {

    /**
     * This goes to find the bean in whichever config file this exists in. Note,
     * this only works if there is one data source. Note, Autowired is autowired
     * by type.
     */
    @Autowired
    private DataSource dataSource;

    /**
     * Note, in general you should put beans you want to scan into the same folder.
     * Resource loads it by name
     */
    @Autowired @Qualifier("redSox")
    private Team home;

    @Autowired @Qualifier("cubs")
    private Team away;

    /**
     * If we have multiple things that match a type (so we have two Teams) then we
     * can initialise a collection with them
     */
    @Autowired
    private List<Team> teams;

    @Bean
    public Game game() {
        BaseballGame baseballGame = new BaseballGame(home, away);
        baseballGame.setDataSource(dataSource);
        return baseballGame;
    }

}
