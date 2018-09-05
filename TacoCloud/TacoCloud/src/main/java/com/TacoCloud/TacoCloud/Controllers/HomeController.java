package com.TacoCloud.TacoCloud.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    /**
     * This is used to return the name of the view we will be using for
     * the home page. It will be stored in /src/main/resources/templates/home.html
     *
     * This is configured thanks to Thymeleaf.
     *
     * @return The name of the view to return.
     */
    @GetMapping("/")
    public String home() {
        return "home";
    }

}
