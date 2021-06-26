package com.amorenog.tweetapi.models;

import lombok.Data;

@Data
public class Tweet {

    private final long id;
    private final Location location;
    private final User user;
    private String text;
    private boolean validation;
    
}
