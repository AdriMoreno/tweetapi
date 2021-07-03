package com.converters;

import com.amorenog.tweetapi.models.Location;
import com.amorenog.tweetapi.models.Tweet;
import com.amorenog.tweetapi.models.User;

import org.springframework.stereotype.Component;

import twitter4j.GeoLocation;
import twitter4j.Status;

public class StatusToTweetConverter{

    public Tweet convertStatus(Status s){
        Tweet converted = new Tweet();
        converted.setId(s.getId());
        converted.setLocation(convertLocation(s.getGeoLocation()));
        converted.setUser(convertUser(s.getUser()));
        converted.setText(s.getText());
        return converted;
    }

    public User convertUser(twitter4j.User user) {
        User converted= new User();
        converted.setId(user.getId());
        converted.setName(user.getName());
        converted.setFollowersCount(user.getFollowersCount());
        return converted;
    }

    private Location convertLocation(GeoLocation geoLocation) {
        Location converted = new Location();
        converted.setXCoordinate(geoLocation.getLatitude());
        converted.setYCoordinate(geoLocation.getLongitude());
        converted.setType(geoLocation.getClass().getSimpleName());
        return converted;
    }
    
}
