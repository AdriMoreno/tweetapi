package com.amorenog.tweetapi.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class User {

    @Id
    private long id;
    private String name;
    private int followersCount;

}
