package com.amorenog.tweetapi.controllers;

import java.util.List;

import com.amorenog.tweetapi.ApiMessage;
import com.amorenog.tweetapi.models.Tweet;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TweetsApiController implements TweetsApi {


    @Override
    public ResponseEntity<List<Tweet>> getAllTweets() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<ApiMessage> validateTweet(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<ApiMessage> addTweet(Tweet tweetToAdd) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
