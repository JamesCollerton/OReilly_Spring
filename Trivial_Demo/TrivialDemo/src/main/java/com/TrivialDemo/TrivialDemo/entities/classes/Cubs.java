package com.TrivialDemo.TrivialDemo.entities.classes;

import com.TrivialDemo.TrivialDemo.entities.interfaces.Team;

public class Cubs implements Team {
    @Override
    public String getName() {
        return "Cubs";
    }
}
