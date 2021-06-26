package com.amorenog.tweetapi.controllers;

import java.util.List;

import com.amorenog.tweetapi.ApiMessage;
import com.amorenog.tweetapi.models.Tweet;
import com.amorenog.tweetapi.services.TweetsService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TweetsApiController implements TweetsApi {

    @Autowired
    TweetsService tweetsService;

    private static Logger logger = LoggerFactory.getLogger(TweetsApiController.class);

    @Override
    public ResponseEntity<List<Tweet>> getAllTweets() {
        try {
            return new ResponseEntity<>(tweetsService.getAllTweets(), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error when getting tweets", e);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<ApiMessage> validateTweet(String id) {
        // TODO Auto-generated method stub
        return null;
    }
}
