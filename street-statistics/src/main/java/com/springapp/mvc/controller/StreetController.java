package com.springapp.mvc.controller;

import com.springapp.mvc.dto.CityDto;
import com.springapp.mvc.dto.StreetDto;
import com.springapp.mvc.dto.StreetNameInfoDto;
import com.springapp.mvc.service.CityService;
import com.springapp.mvc.service.StreetNameInfoService;
import com.springapp.mvc.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping(value = "street")
public class StreetController extends Redirector{

    @Autowired
    private StreetService streetService;

    @Autowired
    private CityService cityService;

    @Autowired
    private StreetNameInfoService streetNameInfoService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public RedirectView addStreet(@RequestParam("city") int city,@RequestParam("streetName") int streetName,@RequestParam("length") int length) {
        StreetDto streetDTO = new StreetDto(city,streetName,length);
        streetService.saveStreet(streetDTO);
        return redirectToMainPage();
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addStreet(ModelMap modelMap) {
        List<CityDto> cities = cityService.getAllCityDtos();
        List<StreetNameInfoDto> streetNames = streetNameInfoService.getAllStreetNamesInfoDtos();
        modelMap.put("cities",cities);
        modelMap.put("streetNames",streetNames);
        return "add/addStreet";
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showStreets(@RequestParam("idCity") int idCity, ModelMap model) {
        List<StreetDto> streets = streetService.getStreetsByCity(idCity);
        model.addAttribute("streets", streets);
        return "show/showStreets";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateStreet(@RequestParam("id") int id, ModelMap modelMap) {
        StreetDto street = streetService.getStreetDtoById(id);
        List<CityDto> cities = cityService.getAllCityDtos();
        List<StreetNameInfoDto> streetNames = streetNameInfoService.getAllStreetNamesInfoDtos();
        modelMap.put("street", street);
        modelMap.put("cities", cities);
        modelMap.put("streetNames", streetNames);
        return "change/changeStreet";
    }


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public RedirectView updateStreet(@RequestParam("id") int id, @RequestParam("city") int city, @RequestParam("streetName") int streetName, @RequestParam("length") int length) {
        StreetDto streetDTO = new StreetDto(id, city, streetName, length);
        streetService.saveStreet(streetDTO);
        return redirectToMainPage();
    }

    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public String removeStreet(@RequestParam("id") int id) {
        streetService.removeStreet(id);
        return "show/showCountry";
    }
}
