package com.streetstat.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name="street_name_info")
public class StreetNameInfo implements Serializable{

    private long id;
    private String name;
    private boolean isPerson;
    private String description;
    private Set<Street> streets;

    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="street_name_info_id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
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
    @Type(type = "org.hibernate.type.NumericBooleanType")
    public boolean getPerson() {
        return isPerson;
    }

    public void setPerson(boolean person) {
        isPerson = person;
    }

    @Column(name="description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(mappedBy="streetNameInfo", cascade=CascadeType.ALL, orphanRemoval=true, fetch = FetchType.LAZY)
    public Set<Street> getStreets() {
        return streets;
    }

    public void setStreets(Set<Street> streets) {
        this.streets = streets;
    }

    public StreetNameInfo() {
    }
}
