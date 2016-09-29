package com.springapp.mvc.controller;

import com.springapp.mvc.dto.CityDto;
import com.springapp.mvc.dto.CountryDto;
import com.springapp.mvc.dto.StreetDto;
import com.springapp.mvc.dto.StreetNameInfoDto;
import com.springapp.mvc.model.City;
import com.springapp.mvc.model.StreetNameInfo;
import com.springapp.mvc.service.DtoService;
import com.springapp.mvc.service.SaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping("/add")

public class AddController extends Redirector {

    @Autowired
    private SaveService saveService;

    @Autowired
    private DtoService dtoService;

    @RequestMapping(value = "/country", method = RequestMethod.POST)
    public RedirectView addCountry(@RequestParam("country_name") String country_name, @RequestParam("population") int population) {
        CountryDto countryDTO = new CountryDto(country_name, population);
        saveService.saveCountry(countryDTO);
        return redirectToMainPage();
    }

    @RequestMapping(value = "/city", method = RequestMethod.POST)
    public RedirectView addCity(@RequestParam("country") int countryId, @RequestParam("city_name") String city_name, @RequestParam("population") int population) {
        CityDto cityDto = new CityDto(city_name, countryId, population);
        saveService.saveCity(cityDto);
        return redirectToMainPage();
    }

    @RequestMapping(value = "/streetName", method = RequestMethod.POST)
    public RedirectView addStreetName(@RequestParam("street_name") String street_name, HttpServletRequest request, @RequestParam("description") String description) {
        String[] person = request.getParameterValues("person");
        boolean isPerson = person != null;
        StreetNameInfoDto streetNameInfoDto = new StreetNameInfoDto(street_name,isPerson,description);
        saveService.saveStreetNameInfo(streetNameInfoDto);
        return redirectToMainPage();
    }

    @RequestMapping(value = "/street", method = RequestMethod.POST)
    public RedirectView addStreet(@RequestParam("city") int city,@RequestParam("streetName") int streetName,@RequestParam("length") int length) {
        StreetDto streetDTO = new StreetDto(city,streetName,length);
        saveService.saveStreet(streetDTO);
        return redirectToMainPage();
    }


    @RequestMapping(value = "/country", method = RequestMethod.GET)
    public String addCountry() {
        return "add/addCountry";
    }

    @RequestMapping(value = "/city", method = RequestMethod.GET)
    public String addCity(ModelMap modelMap) {
        List<CountryDto> countryList = dtoService.getAllCountriesDtos();
        modelMap.put("countries",countryList);
        return "add/addCity";
    }

    @RequestMapping(value = "/streetNameInfo", method = RequestMethod.GET)
    public String addStreetName() {
        return "add/addStreetNameInfo";
    }

    @RequestMapping(value = "/street", method = RequestMethod.GET)
    public String addStreet(ModelMap modelMap) {
        List<CityDto> cities = dtoService.getAllCityDtos();
        List<StreetNameInfoDto> streetNames = dtoService.getAllStreetNamesInfoDtos();
        modelMap.put("cities",cities);
        modelMap.put("streetNames",streetNames);
        return "add/addStreet";
    }





}
