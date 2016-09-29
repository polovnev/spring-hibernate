package com.springapp.mvc.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="country")
public class Country implements Serializable{
    private int id;
    private String name;
    private int population;
    private Set<City> cities;

    public Country(int id, String name, int population) {
        this.id = id;
        this.name = name;
        this.population = population;
    }

    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="country_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="country_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="population")
    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy="country", cascade=CascadeType.ALL, orphanRemoval=true)
    public Set<City> getCities() {
        return cities;
    }

    public void setCities(Set<City> citys) {
        this.cities = citys;
    }

    public Country() {
    }


}
