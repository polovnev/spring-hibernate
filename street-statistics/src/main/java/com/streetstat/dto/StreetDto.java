package com.streetstat.dto;

public class StreetDto {

    private int id;
    private int cityId;
    private int streetNameId;
    private int length;
    private CityDto cityDto;
    private StreetNameInfoDto streetNameInfoDto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getStreetNameId() {
        return streetNameId;
    }

    public void setStreetNameId(int streetNameId) {
        this.streetNameId = streetNameId;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public CityDto getCityDto() {
        return cityDto;
    }

    public void setCityDto(CityDto cityDto) {
        this.cityDto = cityDto;
    }

    public StreetNameInfoDto getStreetNameInfoDto() {
        return streetNameInfoDto;
    }

    public void setStreetNameInfoDto(StreetNameInfoDto streetNameInfoDto) {
        this.streetNameInfoDto = streetNameInfoDto;
    }


}
