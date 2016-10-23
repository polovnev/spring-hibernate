package com.streetstat.facade;


import com.streetstat.facade.dto.CountryDto;
import com.streetstat.model.Country;

import java.util.List;

public interface CountryFacade {

    void saveCountry(CountryDto countryDto);

    CountryDto getCountryDtoById(long id);

    List<CountryDto> getAllCountriesDtos();

    void removeCountry(long id);
}
