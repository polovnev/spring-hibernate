package com.streetstat.service;


import com.streetstat.model.Street;
import com.streetstat.model.StreetNameInfo;

import java.util.List;
import java.util.Set;


public interface StreetService {

    void saveStreet(Street street);

    Street getStreetById(long id);

    Set<Street> getStreetsByCity(long id);

    void removeStreet(long id);

    void saveStreetNameInfo(StreetNameInfo streetNameInfo);

    StreetNameInfo getStreetNameInfoById(long id);

    List<StreetNameInfo> getAllStreetNamesInfos();

    void removeStreetNameInfo(long id);

}
