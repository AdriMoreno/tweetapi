package com.amorenog.tweetapi.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Tweet {

    @Id
    private long id;
    @ManyToOne
    private Location location;
    @ManyToOne
    private User user;
    private String text;
    private boolean validation;

}
