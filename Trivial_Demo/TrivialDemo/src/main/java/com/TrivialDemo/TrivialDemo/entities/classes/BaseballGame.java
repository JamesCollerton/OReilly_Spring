package com.TrivialDemo.TrivialDemo.entities.classes;

import com.TrivialDemo.TrivialDemo.entities.interfaces.Game;
import com.TrivialDemo.TrivialDemo.entities.interfaces.Team;

import javax.sql.DataSource;

public class BaseballGame implements Game {

    private Team homeTeam;
    private Team awayTeam;
    private DataSource dataSource;

    public BaseballGame(Team homeTeam, Team awayTeam) {
        setHomeTeam(homeTeam);
        setAwayTeam(awayTeam);
    }

    @Override
    public void setHomeTeam(Team team) {
        this.homeTeam = team;
    }

    @Override
    public void setAwayTeam(Team team) {
        this.awayTeam = team;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Team getHomeTeam() {
        return homeTeam;
    }

    @Override
    public Team getAwayTeam() {
        return awayTeam;
    }

    @Override
    public String playGame() {
        return Math.random() > 0.5 ? homeTeam.getName() : awayTeam.getName();
    }

}
