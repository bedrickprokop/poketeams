package br.com.poketeams.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homepage() {
<<<<<<< HEAD
        return "index" //poketeams 1 - lll;
=======
<<<<<<< HEAD
        return "index" //poketeams2;
=======
        return "index" //poketeams 1;
>>>>>>> e7dc724a29208551a58ad7c122dd07ed27ec553e
>>>>>>> 8f2f353c1f81713dae9043f392e7b4d9ee7d78d4
    }
}
