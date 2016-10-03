package com.springapp.mvc.controller;
import com.springapp.mvc.dto.CityDto;
import com.springapp.mvc.service.ComplexQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class AjaxController {

    @Autowired
    private ComplexQueryService complexQueryService;

    @ResponseBody
    @RequestMapping(value = "/sumLongestStreet", method = RequestMethod.GET)
    public String showCityThisSumLongestStreet(@RequestParam("idCountry") int id) {
        CityDto result = complexQueryService.showCityThisSumLongestStreet(id);
        return result.getName();
    }

    @ResponseBody
    @RequestMapping(value = "/biggestPopulation", method = RequestMethod.GET)
    public String showCityThisBiggerstPopulation(@RequestParam("idCountry") int id) {
        CityDto result = complexQueryService.showCityThisBiggestPopulation(id);
        return result.getName();
    }

    @ResponseBody
    @RequestMapping(value = "/smallestPopulation", method = RequestMethod.GET)
    public String showCityThisSmallestPopulation(@RequestParam("idCountry") int id) {
        CityDto result = complexQueryService.showCityThisSmallestPopulation(id);
        return result.getName();
    }

}