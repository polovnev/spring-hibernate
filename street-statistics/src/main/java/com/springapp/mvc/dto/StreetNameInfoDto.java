package com.springapp.mvc.dto;

public class StreetNameInfoDto {

    private int id;
    private String name;
    private boolean isPerson;
    private String description;

    public String getName() {
        return name;
    }

    public boolean isPerson() {
        return isPerson;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public StreetNameInfoDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public StreetNameInfoDto(int id, String name, boolean person, String description) {
        this.id = id;
        this.name = name;
        isPerson = person;
        this.description = description;
    }

    public StreetNameInfoDto(String name, boolean person, String description) {
        this.name = name;
        isPerson = person;
        this.description = description;
    }
}
