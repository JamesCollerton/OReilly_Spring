package com.TrivialDemo.TrivialDemo;

import com.TrivialDemo.TrivialDemo.entities.classes.Cubs;
import com.TrivialDemo.TrivialDemo.entities.classes.RedSox;
import com.TrivialDemo.TrivialDemo.entities.interfaces.Game;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunWithSpring {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        /**
         * Note, this doesn't necessarily call the end game method, as this is only
         * called when it's got rid of from scope.
         */
        Game game = context.getBean("game", Game.class);
        System.out.println(game.playGame());

        context.close();
    }

}
