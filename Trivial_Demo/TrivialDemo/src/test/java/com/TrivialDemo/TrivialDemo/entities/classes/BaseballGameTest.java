package com.TrivialDemo.TrivialDemo.entities.classes;

import com.TrivialDemo.TrivialDemo.AppConfig;
import com.TrivialDemo.TrivialDemo.entities.interfaces.Game;
import com.TrivialDemo.TrivialDemo.entities.interfaces.Team;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class BaseballGameTest {

    private Game game;

    private ApplicationContext ctx;

    @Before
    public void setUp() {
        ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        game = ctx.getBean("game", Game.class);
    }

    @Test
    public void testPlayGame() throws Exception {
        String home = game.getHomeTeam().getName();
        String away = game.getAwayTeam().getName();

        String result = game.playGame();

        assertTrue(result.contains(home) || result.contains(away));
    }

    @Test
    public void testGetAndSetHomeTeam() throws Exception {
        Team redSox = ctx.getBean("redSox", Team.class);
        game.setHomeTeam(redSox);
        assertEquals(game.getHomeTeam().getName(), redSox.getName());
    }

}