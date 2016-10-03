package com.springapp.mvc.controller;

import com.springapp.mvc.dto.CityDto;
import com.springapp.mvc.dto.CountryDto;
import com.springapp.mvc.service.CityService;
import com.springapp.mvc.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/city")
public class CityController extends Redirector {

    @Autowired
    private CityService cityService;

    @Autowired
    private CountryService countryService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public RedirectView addCity(@RequestParam("country") int countryId, @RequestParam("city_name") String city_name, @RequestParam("population") int population) {
        CityDto cityDto = new CityDto(city_name, countryId, population);
        cityService.saveCity(cityDto);
        return redirectToMainPage();
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addCity(ModelMap modelMap) {
        List<CountryDto> countryList = countryService.getAllCountriesDtos();
        modelMap.put("countries",countryList);
        return "add/addCity";
    }

    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public String removeCity(@RequestParam("id") int id) {
        cityService.removeCity(id);
        return "show/showCountry";
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showCities(@RequestParam("idCountry") int idCountry, ModelMap model) {
        List<CityDto> cities = cityService.getCitiesByCountry(idCountry);
        model.addAttribute("cities", cities);
        return "show/showCities";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public RedirectView updateCity(@RequestParam("id") int id, @RequestParam("country") int countryId, @RequestParam("city_name") String city_name, @RequestParam("population") int population) {
        CityDto cityDTO = new CityDto(id, city_name, countryId, population);
        cityService.saveCity(cityDTO);
        return redirectToMainPage();
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateCity(@RequestParam("id") int id, ModelMap modelMap) {
        CityDto city = cityService.getCityDtoById(id);
        List<CountryDto> countryList = countryService.getAllCountriesDtos();
        modelMap.put("city", city);
        modelMap.put("countries", countryList);
        return "change/changeCity";
    }

}
