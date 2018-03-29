package com.TrivialDemo.TrivialDemo;

import com.TrivialDemo.TrivialDemo.entities.classes.Cubs;
import com.TrivialDemo.TrivialDemo.entities.classes.RedSox;
import com.TrivialDemo.TrivialDemo.entities.interfaces.Game;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunWithSpring {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Game game1 = context.getBean("game", Game.class);
        RedSox redSox = context.getBean("redSox", RedSox.class);
        game1.setAwayTeam(redSox);
//        System.out.println(game.playGame());
        System.out.println(game1.toString());

        Game game2 = context.getBean("game", Game.class);
        Cubs cubs = context.getBean("cubs", Cubs.class);
        game2.setAwayTeam(cubs);
//        System.out.println(game.playGame());
        System.out.println(game2.toString());

        // Note this has now changed as it was passed by reference.
        System.out.println(game1.toString());
    }

}
