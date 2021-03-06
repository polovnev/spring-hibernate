package com.streetstat.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="city")
public class City implements Serializable{
    private long id;
    private String name;
    private Country country;
    private int population;
    private Set<Street> streets;

    public City() {
    }

    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="city_id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name="city_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name="country_ref")
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Column(name="population")
    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy="city", cascade=CascadeType.ALL, orphanRemoval=true)
    public Set<Street> getStreets() {
        return streets;
    }

    public void setStreets(Set<Street> streets) {
        this.streets = streets;
    }


}
