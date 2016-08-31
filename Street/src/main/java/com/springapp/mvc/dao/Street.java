package com.springapp.mvc.dao;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="street")
public class Street implements Serializable{
    private int id;
    private City city;
    private StreetName streetName;
    private int length;

    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="street_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name="city_id")
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @ManyToOne
    @JoinColumn(name="street_name_info_id")
    public StreetName getStreetName() {
        return streetName;
    }

    public void setStreetName(StreetName streetName) {
        this.streetName = streetName;
    }

    @Column(name="length")
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
