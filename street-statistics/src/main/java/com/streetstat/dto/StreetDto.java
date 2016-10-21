package com.streetstat.dto;

public class StreetDto {

    private long id;
    private int length;
    private CityDto cityDto;
    private StreetNameInfoDto streetNameInfoDto;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
