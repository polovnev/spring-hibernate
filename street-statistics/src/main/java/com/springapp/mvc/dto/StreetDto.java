package com.springapp.mvc.dto;


public class StreetDto {

    private int id;
    private int cityId;
    private int streetNameId;
    private int length;

    public StreetDto(int cityId, int streetNameId, int length) {
        this.cityId = cityId;
        this.streetNameId = streetNameId;
        this.length = length;
    }

    public StreetDto(int id, int cityId, int streetNameId, int length) {
        this.id = id;
        this.cityId = cityId;
        this.streetNameId = streetNameId;
        this.length = length;
    }

    public int getCityId() {
        return cityId;
    }

    public int getStreetNameId() {
        return streetNameId;
    }

    public int getLength() {
        return length;
    }

    public int getId() {
        return id;
    }
}
