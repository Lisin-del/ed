package ru.lisin.labwork1lmm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.lisin.labwork1lmm.services.DepartmentService;

@RestController
public class MainController {
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String getLoginPage() {
        return "Home";
    }

    @RequestMapping(path = "/add-dep", method = RequestMethod.GET)
    @Secured(value = "USER")
    public String addDep() {
        return "something";
    }
}
