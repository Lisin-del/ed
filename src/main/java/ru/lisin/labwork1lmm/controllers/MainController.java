package ru.lisin.labwork1lmm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @RequestMapping(path = "/home", method = RequestMethod.GET)
    public String getLoginPage() {
        System.out.println("controller was invoked");
        return "Login";
    }
}
