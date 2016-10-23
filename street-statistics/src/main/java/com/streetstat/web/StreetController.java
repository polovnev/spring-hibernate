package com.streetstat.web;

import com.streetstat.facade.CityFacade;
import com.streetstat.facade.StreetFacade;
import com.streetstat.facade.dto.CityDto;
import com.streetstat.facade.dto.StreetDto;
import com.streetstat.facade.dto.StreetNameInfoDto;
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
    private StreetFacade streetFacade;

    @Autowired
    private CityFacade cityFacade;


    @RequestMapping(value = "/street/add", method = RequestMethod.POST)
    public ModelAndView addStreet(@RequestParam("city") int city, @RequestParam("streetNameInfo") int streetName, @RequestParam("length") int length) {
        StreetDto streetDto = new StreetDto();
        CityDto cityDto = new CityDto();
        cityDto.setId(city);
        streetDto.setCityDto(cityDto);

        StreetNameInfoDto streetNameInfoDto = new StreetNameInfoDto();
        streetNameInfoDto.setId(streetName);
        streetDto.setStreetNameInfoDto(streetNameInfoDto);

        streetDto.setLength(length);
        streetFacade.saveStreet(streetDto);
        return new ModelAndView("redirect:/country/show");
    }

    @RequestMapping(value = "/street/add", method = RequestMethod.GET)
    public String addStreet(ModelMap modelMap) {
        List<CityDto> cities = cityFacade.getAllCityDtos();
        List<StreetNameInfoDto> streetNames = streetFacade.getAllStreetNamesInfoDtos();
        modelMap.put("cities", cities);
        modelMap.put("streetNames", streetNames);
        return "add/addStreet";
    }

    @RequestMapping(value = "/street/show", method = RequestMethod.GET)
    public String showStreets(@RequestParam("idCity") int idCity, ModelMap model) {
        List<StreetDto> streets = streetFacade.getStreetDtosByCity(idCity);
        model.addAttribute("streets", streets);
        return "show/showStreets";
    }

    @RequestMapping(value = "/street/update", method = RequestMethod.GET)
    public String updateStreet(@RequestParam("id") int id, ModelMap modelMap) {
        StreetDto street = streetFacade.getStreetDtoById(id);
        List<CityDto> cities = cityFacade.getAllCityDtos();
        List<StreetNameInfoDto> streetNames = streetFacade.getAllStreetNamesInfoDtos();
        modelMap.put("street", street);
        modelMap.put("cities", cities);
        modelMap.put("streetNames", streetNames);
        return "change/changeStreet";
    }


    @RequestMapping(value = "/street/update", method = RequestMethod.POST)
    public ModelAndView updateStreet(@RequestParam("id") int id, @RequestParam("city") int city, @RequestParam("streetNameInfo") int streetNameInfo, @RequestParam("length") int length) {
        StreetDto streetDTO = new StreetDto();
        streetDTO.setId(id);
        CityDto cityDto = new CityDto();
        cityDto.setId(city);
        streetDTO.setCityDto(cityDto);

        StreetNameInfoDto streetNameInfoDto = new StreetNameInfoDto();
        streetNameInfoDto.setId(streetNameInfo);
        streetDTO.setStreetNameInfoDto(streetNameInfoDto);
        streetDTO.setLength(length);
        streetFacade.saveStreet(streetDTO);
        return new ModelAndView("redirect:/country/show");

    }

    @RequestMapping(value = "/street/remove", method = RequestMethod.GET)
    public ModelAndView removeStreet(@RequestParam("id") int id) {
        streetFacade.removeStreet(id);
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
        streetFacade.saveStreetNameInfoDto(streetNameInfoDto);
        return new ModelAndView("redirect:/country/show");
    }

    @RequestMapping(value = "/streetNameInfo/add", method = RequestMethod.GET)
    public String addStreetName() {
        return "add/addStreetNameInfo";
    }

    @RequestMapping(value = "/streetNameInfo/show", method = RequestMethod.GET)
    public String showStreetNames(ModelMap model) {
        List<StreetNameInfoDto> streetNames = streetFacade.getAllStreetNamesInfoDtos();
        model.addAttribute("streetNames", streetNames);
        return "show/showStreetNames";
    }

    @RequestMapping(value = "/streetNameInfo/remove", method = RequestMethod.GET)
    public ModelAndView removeStreetName(@RequestParam("id") int id) {
        streetFacade.removeStreetNameInfo(id);
        return new ModelAndView("redirect:/country/show");
    }

    @RequestMapping(value = "/streetNameInfo/update", method = RequestMethod.GET)
    public String updateStreetName(@RequestParam("id") int id, ModelMap modelMap) {
        StreetNameInfoDto streetName = streetFacade.getStreetNameInfoDtoById(id);
        modelMap.put("streetNameInfo", streetName);
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
        streetFacade.saveStreetNameInfoDto(streetNameInfoDto);
        return new ModelAndView("redirect:/country/show");
    }
}
