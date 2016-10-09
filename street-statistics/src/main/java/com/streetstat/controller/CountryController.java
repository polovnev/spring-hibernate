package com.streetstat.controller;

import com.streetstat.dto.CountryDto;
import com.streetstat.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

@Controller
@RequestMapping(value = {"/country", "/"})
public class CountryController {

    @Autowired
    private CountryService countryService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addCountry() {
        return "add/addCountry";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addCountry(@RequestParam("country_name") String country_name, @RequestParam("population") int population) {
        CountryDto countryDTO = new CountryDto();
        countryDTO.setName(country_name);
        countryDTO.setPopulation(population);
        countryService.saveCountry(countryDTO);
        return new ModelAndView("redirect:/country/show");
    }

    @RequestMapping(value = {"/show",""}, method = RequestMethod.GET)
    public String showCountries(ModelMap model) {
        List<CountryDto> countries = countryService.getAllCountriesDtos();
        model.addAttribute("countries", countries);
        return "show/showCountry";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView updateCountry(@RequestParam("id") int id, @RequestParam("country_name") String country_name, @RequestParam("population") int population) {
        CountryDto countryDTO = new CountryDto();
        countryDTO.setId(id);
        countryDTO.setName(country_name);
        countryDTO.setPopulation(population);
        countryService.saveCountry(countryDTO);
        return new ModelAndView("redirect:/country/show");
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateCountry(@RequestParam("id") int id, ModelMap modelMap) {
        CountryDto country = countryService.getCountryDtoById(id);
        modelMap.put("country", country);
        return "change/changeCountry";
    }

    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public ModelAndView removeCountry(@RequestParam("id") int id) {
        countryService.removeCountry(id);
        return new ModelAndView("redirect:/country/show");
    }
}
