package com.amorenog.tweetapi.services;

import java.util.List;

import com.amorenog.tweetapi.models.Tweet;

import org.springframework.stereotype.Service;

@Service
public interface TweetsService {

    public List<Tweet> getAllTweets();

    void setTweetsListener();

}
