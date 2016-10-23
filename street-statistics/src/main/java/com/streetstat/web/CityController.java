package com.streetstat.web;

import com.streetstat.facade.CityFacade;
import com.streetstat.facade.CountryFacade;
import com.streetstat.facade.dto.CityDto;
import com.streetstat.facade.dto.CountryDto;
import com.streetstat.service.CityService;
import com.streetstat.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityFacade cityFacade;

    @Autowired
    private CountryFacade countryFacade;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addCity(@RequestParam("country") int countryId, @RequestParam("city_name") String city_name, @RequestParam("population") int population) {
        CityDto cityDto = new CityDto();
        cityDto.setName(city_name);
        CountryDto countryDto = new CountryDto();
        countryDto.setId(countryId);
        cityDto.setCountryDto(countryDto);
        cityDto.setPopulation(population);
        cityFacade.saveCity(cityDto);
        return new ModelAndView("redirect:/country/show");
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addCity(ModelMap modelMap) {
        List<CountryDto> countryList = countryFacade.getAllCountriesDtos();
        modelMap.put("countries", countryList);
        return "add/addCity";
    }

    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public String removeCity(@RequestParam("id") int id) {
        cityFacade.removeCity(id);
        return "show/showCountry";
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showCities(@RequestParam("idCountry") int idCountry, ModelMap model) {
        Set<CityDto> cities = cityFacade.getCityDtosByCountry(idCountry);
        model.addAttribute("cities", cities);
        return "show/showCities";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView updateCity(@RequestParam("id") int id, @RequestParam("country") int countryId, @RequestParam("city_name") String city_name, @RequestParam("population") int population) {
        CityDto cityDto = new CityDto();
        cityDto.setId(id);
        cityDto.setName(city_name);
        CountryDto countryDto = new CountryDto();
        countryDto.setId(countryId);
        cityDto.setCountryDto(countryDto);
        cityDto.setPopulation(population);
        cityFacade.saveCity(cityDto);
        return new ModelAndView("redirect:/country/show");
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateCity(@RequestParam("id") int id, ModelMap modelMap) {
        CityDto city = cityFacade.getCityDtoById(id);
        List<CountryDto> countryList = countryFacade.getAllCountriesDtos();
        modelMap.put("city", city);
        modelMap.put("countries", countryList);
        return "change/changeCity";
    }

    @ResponseBody
    @RequestMapping(value = "/sumLongestStreet", method = RequestMethod.GET)
    public String showCityThisSumLongestStreet(@RequestParam("idCountry") int id) {
        CityDto cityDto = cityFacade.showCityDtoThisSumLongestStreet(id);
        return cityDto.getName();
    }

    @ResponseBody
    @RequestMapping(value = "/biggestPopulation", method = RequestMethod.GET)
    public String showCityThisBiggerstPopulation(@RequestParam("idCountry") int id) {
        CityDto cityDto = cityFacade.showCityDtoThisBiggestPopulation(id);
        return cityDto.getName();
    }

    @ResponseBody
    @RequestMapping(value = "/smallestPopulation", method = RequestMethod.GET)
    public String showCityThisSmallestPopulation(@RequestParam("idCountry") int id) {
        CityDto cityDto = cityFacade.showCityDtoThisSmallestPopulation(id);
        return cityDto.getName();
    }

}
