package com.amorenog.tweetapi.models;

import javax.persistence.Embeddable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@Data
public class Location {
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
