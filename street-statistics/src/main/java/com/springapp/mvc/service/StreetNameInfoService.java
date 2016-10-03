package com.springapp.mvc.service;


import com.springapp.mvc.dto.StreetNameInfoDto;

import java.util.List;

public interface StreetNameInfoService {

    void saveStreetNameInfo(StreetNameInfoDto streetNameInfoDto);

    StreetNameInfoDto getStreetNameInfoById(int id);

    List<StreetNameInfoDto> getAllStreetNamesInfoDtos();

    void removeStreetName(int id);
}
