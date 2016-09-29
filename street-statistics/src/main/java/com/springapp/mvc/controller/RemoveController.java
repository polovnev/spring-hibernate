package com.springapp.mvc.controller;

import com.springapp.mvc.service.impl.RemoveServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Transactional
@Controller
@RequestMapping("/remove")
public class RemoveController {

    @Autowired
    private RemoveServiceImpl service;

    @RequestMapping(value = "/country", method = RequestMethod.GET)
    public String removeCountry(@RequestParam("id") int id) {
        service.removeCountry(id);
        return "show/showCountry";
    }

    @RequestMapping(value = "/city", method = RequestMethod.GET)
    public String removeCity(@RequestParam("id") int id) {
        service.removeCity(id);
        return "show/showCountry";
    }

    @RequestMapping(value = "/street", method = RequestMethod.GET)
    public String removeStreet(@RequestParam("id") int id) {
        service.removeStreet(id);
        return "show/showCountry";
    }

    @RequestMapping(value = "/streetName", method = RequestMethod.GET)
    public String removeStreetName(@RequestParam("id") int id) {
        service.removeStreetName(id);
        return "show/showCountry";
    }
}
