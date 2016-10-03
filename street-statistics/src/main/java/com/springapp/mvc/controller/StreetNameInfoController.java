package com.springapp.mvc.controller;


import com.springapp.mvc.dto.StreetNameInfoDto;
import com.springapp.mvc.service.StreetNameInfoService;
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
@RequestMapping(value = "streetNameInfo")
public class StreetNameInfoController extends Redirector{

    @Autowired
    private StreetNameInfoService streetNameInfoService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public RedirectView addStreetName(@RequestParam("street_name") String street_name, HttpServletRequest request, @RequestParam("description") String description) {
        String[] person = request.getParameterValues("person");
        boolean isPerson = person != null;
        StreetNameInfoDto streetNameInfoDto = new StreetNameInfoDto(street_name,isPerson,description);
        streetNameInfoService.saveStreetNameInfo(streetNameInfoDto);
        return redirectToMainPage();
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addStreetName() {
        return "add/addStreetNameInfo";
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showStreetNames(ModelMap model) {
        List<StreetNameInfoDto> streetNames = streetNameInfoService.getAllStreetNamesInfoDtos();
        model.addAttribute("streetNames", streetNames);
        return "show/showStreetNames";
    }

    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public String removeStreetName(@RequestParam("id") int id) {
        streetNameInfoService.removeStreetName(id);
        return "show/showCountry";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateStreetName(@RequestParam("id") int id, ModelMap modelMap) {
        StreetNameInfoDto streetName = streetNameInfoService.getStreetNameInfoById(id);
        modelMap.put("streetName", streetName);
        return "change/changeStreetName";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public RedirectView updateStreetName(@RequestParam("id") int id, @RequestParam("street_name") String street_name, HttpServletRequest request, @RequestParam("description") String description) {
        String[] person = request.getParameterValues("person");
        boolean isPerson = person != null;
        StreetNameInfoDto streetNameDTO = new StreetNameInfoDto(id,street_name,isPerson,description);
        streetNameInfoService.saveStreetNameInfo(streetNameDTO);
        return redirectToMainPage();
    }

}
