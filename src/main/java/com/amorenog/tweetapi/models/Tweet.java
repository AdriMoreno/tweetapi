package com.amorenog.tweetapi.models;

import lombok.Data;
import lombok.Getter;

@Data
public class Tweet {

    private final long id;
    @Getter(lazy = true)
    private final Location location;
    @Getter(lazy = true)
    private final User user;
    private String text;
    private boolean validation;
    
}
