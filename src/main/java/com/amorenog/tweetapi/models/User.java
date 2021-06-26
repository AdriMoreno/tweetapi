package com.amorenog.tweetapi.models;

import lombok.Data;

@Data
public class User {

    private final long id;
    private String name;
    private int followersCount;

}
