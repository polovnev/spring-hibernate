package com.springapp.mvc.dto;

public class StreetNameInfoDto {

    private int id;
    private String name;
    private boolean isPerson;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPerson() {
        return isPerson;
    }

    public void setPerson(boolean person) {
        isPerson = person;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
