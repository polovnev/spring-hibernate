package com.springapp.mvc.dao;

import java.io.Serializable;
import java.util.Set;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.*;


@Entity
@Table(name="city")
public class StreetName implements Serializable{

    private int id;
    private String name;
    private int isPerson;
    private String description;
    private Set<Street> streets;

    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="street_name_info_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="street_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="isPerson")
    public int getPerson() {
        return isPerson;
    }

    public void setPerson(boolean person) {
        isPerson = (person)? 1 : 0;
    }

    @Column(name="description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(mappedBy="streetName", cascade=CascadeType.ALL, orphanRemoval=true)
    public Set<Street> getStreets() {
        return streets;
    }

    public void setStreets(Set<Street> streets) {
        this.streets = streets;
    }
}
