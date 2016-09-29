package com.springapp.mvc.controller;

import com.springapp.mvc.dto.CityDto;
import com.springapp.mvc.dto.CountryDto;
import com.springapp.mvc.dto.StreetDto;
import com.springapp.mvc.dto.StreetNameInfoDto;
import com.springapp.mvc.model.City;
import com.springapp.mvc.model.Country;
import com.springapp.mvc.model.Street;
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
@RequestMapping("/update")

public class UpdateController extends Redirector{

    @Autowired
    private SaveService saveService;

    @Autowired
    private DtoService dtoService;

    @RequestMapping(value = "/country", method = RequestMethod.POST)
    public RedirectView updateCountry(@RequestParam("id") int id, @RequestParam("country_name") String country_name, @RequestParam("population") int population) {
        CountryDto countryDTO = new CountryDto(id, country_name, population);
        saveService.saveCountry(countryDTO);
        return redirectToMainPage();
    }

    @RequestMapping(value = "/country", method = RequestMethod.GET)
    public String updateCountry(@RequestParam("id") int id, ModelMap modelMap) {
        CountryDto country = dtoService.getCountryDtoById(id);
        modelMap.put("country", country);
        return "change/changeCountry";
    }

    @RequestMapping(value = "/city", method = RequestMethod.POST)
    public RedirectView updateCity(@RequestParam("id") int id, @RequestParam("country") int countryId, @RequestParam("city_name") String city_name, @RequestParam("population") int population) {
        CityDto cityDTO = new CityDto(id, city_name, countryId, population);
        saveService.saveCity(cityDTO);
        return redirectToMainPage();
    }

    @RequestMapping(value = "/city", method = RequestMethod.GET)
    public String updateCity(@RequestParam("id") int id, ModelMap modelMap) {
        CityDto city = dtoService.getCityDtoById(id);
        List<CountryDto> countryList = dtoService.getAllCountriesDtos();
        modelMap.put("city", city);
        modelMap.put("countries", countryList);
        return "change/changeCity";
    }

    @RequestMapping(value = "/street", method = RequestMethod.GET)
    public String updateStreet(@RequestParam("id") int id, ModelMap modelMap) {
        StreetDto street = dtoService.getStreetDtoById(id);
        List<CityDto> cities = dtoService.getAllCityDtos();
        List<StreetNameInfoDto> streetNames = dtoService.getAllStreetNamesInfoDtos();
        modelMap.put("street", street);
        modelMap.put("cities", cities);
        modelMap.put("streetNames", streetNames);
        return "change/changeStreet";
    }


    @RequestMapping(value = "/street", method = RequestMethod.POST)
    public RedirectView updateStreet(@RequestParam("id") int id, @RequestParam("city") int city, @RequestParam("streetName") int streetName, @RequestParam("length") int length) {
        StreetDto streetDTO = new StreetDto(id, city, streetName, length);
        saveService.saveStreet(streetDTO);
        return redirectToMainPage();
    }


    @RequestMapping(value = "/streetName", method = RequestMethod.GET)
    public String addStreetName(@RequestParam("id") int id, ModelMap modelMap) {
        StreetNameInfoDto streetName = dtoService.getStreetNameInfoById(id);
        modelMap.put("streetName", streetName);
        return "change/changeStreetName";
    }

    @RequestMapping(value = "/streetName", method = RequestMethod.POST)
    public RedirectView addStreetName(@RequestParam("id") int id, @RequestParam("street_name") String street_name, HttpServletRequest request, @RequestParam("description") String description) {
        String[] person = request.getParameterValues("person");
        boolean isPerson = person != null;
        StreetNameInfoDto streetNameDTO = new StreetNameInfoDto(id,street_name,isPerson,description);
        saveService.saveStreetNameInfo(streetNameDTO);
        return redirectToMainPage();
    }

}
