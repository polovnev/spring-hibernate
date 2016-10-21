package com.streetstat.model;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="street")
public class Street implements Serializable{
    private long id;
    private City city;
    private StreetNameInfo streetNameInfo;
    private int length;

    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="street_id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name="city_ref")
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @ManyToOne
    @JoinColumn(name="street_name_info_ref")
    public StreetNameInfo getStreetNameInfo() {
        return streetNameInfo;
    }

    public void setStreetNameInfo(StreetNameInfo streetNameInfo) {
        this.streetNameInfo = streetNameInfo;
    }

    @Column(name="length")
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Street() {
    }
}
