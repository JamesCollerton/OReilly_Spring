package com.TrivialDemo.TrivialDemo.entities.interfaces;

public interface Game {
    void setHomeTeam(Team team);
    void setAwayTeam(Team team);
    Team getHomeTeam();
    Team getAwayTeam();
    String playGame();
}
