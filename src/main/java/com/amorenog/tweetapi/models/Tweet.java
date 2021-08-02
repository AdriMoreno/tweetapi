package com.amorenog.tweetapi.models;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Tweet {

    @Id
    private long id;
    @Embedded
    private Location location;
    @ManyToOne
    private User user;
    @Lob
    @Column(length=300)
    private String text;
    @Column(length=4)
    private String language;
    private boolean validation;

}
