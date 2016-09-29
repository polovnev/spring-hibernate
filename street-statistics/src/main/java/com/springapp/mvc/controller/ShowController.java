package com.springapp.mvc.controller;

import com.springapp.mvc.dto.CityDto;
import com.springapp.mvc.dto.CountryDto;
import com.springapp.mvc.dto.StreetDto;
import com.springapp.mvc.dto.StreetNameInfoDto;
import com.springapp.mvc.service.DtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/show")
@Transactional
public class ShowController {


    @Autowired
    private DtoService dtoService;

    @RequestMapping(value = "/countries", method = RequestMethod.GET)
    public String showCountries(ModelMap model) {
        List<CountryDto> countries = dtoService.getAllCountriesDtos();
        System.out.println("end");
        model.addAttribute("countries", countries);
        return "show/showCountry";
    }

    @RequestMapping(value = "/cities", method = RequestMethod.GET)
    public String showCities(@RequestParam("idCountry") int idCountry, ModelMap model) {
        List<CityDto> cities = dtoService.getCitiesByCountry(idCountry);
        model.addAttribute("cities", cities);
        return "show/showCities";
    }

    @RequestMapping(value = "/streets", method = RequestMethod.GET)
    public String showStreets(@RequestParam("idCity") int idCity, ModelMap model) {
        List<StreetDto> streets = dtoService.getStreetsByCity(idCity);
        model.addAttribute("streets", streets);
        return "show/showStreets";
    }

    @RequestMapping(value = "/streetNames", method = RequestMethod.GET)
    public String showStreetNames(ModelMap model) {
        List<StreetNameInfoDto> streetNames = dtoService.getAllStreetNamesInfoDtos();
        model.addAttribute("streetNames", streetNames);
        return "show/showStreetNames";
    }
}
