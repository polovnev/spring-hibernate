package com.streetstat.controller;

import com.streetstat.dto.CityDto;
import com.streetstat.dto.StreetDto;
import com.streetstat.dto.StreetNameInfoDto;
import com.streetstat.service.CityService;
import com.streetstat.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class StreetController {

    @Autowired
    private StreetService streetService;

    @Autowired
    private CityService cityService;


    @RequestMapping(value = "/street/add", method = RequestMethod.POST)
    public ModelAndView addStreet(@RequestParam("city") int city,@RequestParam("streetName") int streetName,@RequestParam("length") int length) {
        StreetDto streetDto = new StreetDto();
        streetDto.setCityId(city);
        streetDto.setStreetNameId(streetName);
        streetDto.setLength(length);
        streetService.saveStreet(streetDto);
        return new ModelAndView("redirect:/country/show");
    }

    @RequestMapping(value = "/street/add", method = RequestMethod.GET)
    public String addStreet(ModelMap modelMap) {
        List<CityDto> cities = cityService.getAllCityDtos();
        List<StreetNameInfoDto> streetNames = streetService.getAllStreetNamesInfoDtos();
        modelMap.put("cities",cities);
        modelMap.put("streetNames",streetNames);
        return "add/addStreet";
    }

    @RequestMapping(value = "/street/show", method = RequestMethod.GET)
    public String showStreets(@RequestParam("idCity") int idCity, ModelMap model) {
        List<StreetDto> streets = streetService.getStreetsByCity(idCity);
        model.addAttribute("streets", streets);
        return "show/showStreets";
    }

    @RequestMapping(value = "/street/update", method = RequestMethod.GET)
    public String updateStreet(@RequestParam("id") int id, ModelMap modelMap) {
        StreetDto street = streetService.getStreetDtoById(id);
        List<CityDto> cities = cityService.getAllCityDtos();
        List<StreetNameInfoDto> streetNames = streetService.getAllStreetNamesInfoDtos();
        modelMap.put("street", street);
        modelMap.put("cities", cities);
        modelMap.put("streetNames", streetNames);
        return "change/changeStreet";
    }


    @RequestMapping(value = "/street/update", method = RequestMethod.POST)
    public ModelAndView updateStreet(@RequestParam("id") int id, @RequestParam("city") int city, @RequestParam("streetName") int streetName, @RequestParam("length") int length) {
        StreetDto streetDTO = new StreetDto();
        streetDTO.setId(id);
        streetDTO.setCityId(city);
        streetDTO.setStreetNameId(streetName);
        streetDTO.setLength(length);
        streetService.saveStreet(streetDTO);
        return new ModelAndView("redirect:/country/show");
    }

    @RequestMapping(value = "/street/remove", method = RequestMethod.GET)
    public ModelAndView removeStreet(@RequestParam("id") int id) {
        streetService.removeStreet(id);
        return new ModelAndView("redirect:/country/show");
    }

    @RequestMapping(value = "/streetNameInfo/add", method = RequestMethod.POST)
    public ModelAndView addStreetName(@RequestParam("street_name") String street_name, HttpServletRequest request, @RequestParam("description") String description) {
        String[] person = request.getParameterValues("person");
        boolean isPerson = person != null;
        StreetNameInfoDto streetNameInfoDto = new StreetNameInfoDto();
        streetNameInfoDto.setName(street_name);
        streetNameInfoDto.setPerson(isPerson);
        streetNameInfoDto.setDescription(description);
        streetService.saveStreetNameInfo(streetNameInfoDto);
        return new ModelAndView("redirect:/country/show");
    }

    @RequestMapping(value = "/streetNameInfo/add", method = RequestMethod.GET)
    public String addStreetName() {
        return "add/addStreetNameInfo";
    }

    @RequestMapping(value = "/streetNameInfo/show", method = RequestMethod.GET)
    public String showStreetNames(ModelMap model) {
        List<StreetNameInfoDto> streetNames = streetService.getAllStreetNamesInfoDtos();
        model.addAttribute("streetNames", streetNames);
        return "show/showStreetNames";
    }

    @RequestMapping(value = "/streetNameInfo/remove", method = RequestMethod.GET)
    public ModelAndView removeStreetName(@RequestParam("id") int id) {
        streetService.removeStreetNameInfo(id);
        return new ModelAndView("redirect:/country/show");
    }

    @RequestMapping(value = "/streetNameInfo/update", method = RequestMethod.GET)
    public String updateStreetName(@RequestParam("id") int id, ModelMap modelMap) {
        StreetNameInfoDto streetName = streetService.getStreetNameInfoById(id);
        modelMap.put("streetName", streetName);
        return "change/changeStreetName";
    }

    @RequestMapping(value = "/streetNameInfo/update", method = RequestMethod.POST)
    public ModelAndView updateStreetName(@RequestParam("id") int id, @RequestParam("street_name") String street_name, HttpServletRequest request, @RequestParam("description") String description) {
        String[] person = request.getParameterValues("person");
        boolean isPerson = person != null;
        StreetNameInfoDto streetNameInfoDto = new StreetNameInfoDto();
        streetNameInfoDto.setId(id);
        streetNameInfoDto.setName(street_name);
        streetNameInfoDto.setPerson(isPerson);
        streetNameInfoDto.setDescription(description);
        streetService.saveStreetNameInfo(streetNameInfoDto);
        return new ModelAndView("redirect:/country/show");
    }
}
