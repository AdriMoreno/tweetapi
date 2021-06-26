package com.amorenog.tweetapi.services;

import java.util.ArrayList;
import java.util.List;

import com.amorenog.tweetapi.models.Tweet;

import org.springframework.stereotype.Service;

@Service
public class TweetsServiceImpl implements TweetsService {

    @Override
    public List<Tweet> getAllTweets() {
        // TODO: Add twitter4j listener for status.
        return new ArrayList<Tweet>();
    }
    
}
