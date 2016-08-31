package com.springapp.mvc.dao;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="city")
public class City implements Serializable{
    private int id;
    private String name;
    private Country country;
    private int population;
    private Set<Street> streets;

    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="city_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    @JoinColumn(name="contact_id")
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

    @OneToMany(mappedBy="city", cascade=CascadeType.ALL, orphanRemoval=true)
    public Set<Street> getStreets() {
        return streets;
    }

    public void setStreets(Set<Street> streets) {
        this.streets = streets;
    }
}
