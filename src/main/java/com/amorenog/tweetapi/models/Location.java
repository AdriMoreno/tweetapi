package com.amorenog.tweetapi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Location {
    @Id
    @GeneratedValue
    private long id;
    private double xCoordinate;
    private double yCoordinate;
    private String type=DEFAULT_LOCATION_TYPE;

    public static final String LOCATION_POINT = "Point";
    public static final String DEFAULT_LOCATION_TYPE = LOCATION_POINT;

    public Location(double xCoordinate, double yCoordinate) {
        setXCoordinate(xCoordinate);
        setYCoordinate(yCoordinate);
    }

}
