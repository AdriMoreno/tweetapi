package com.amorenog.tweetapi.models;

public record Location (double xCoordinate, double yCoordinate, String type){

    public static final String LOCATION_POINT = "Point";
    public static final String DEFAULT_LOCATION_TYPE = LOCATION_POINT;

    public Location(double xCoordinate, double yCoordinate){
        this(xCoordinate, yCoordinate, DEFAULT_LOCATION_TYPE);
    }

}
