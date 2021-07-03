package com.amorenog.tweetapi.services;

import java.util.ArrayList;
import java.util.List;

import com.amorenog.tweetapi.models.Tweet;
import com.amorenog.tweetapi.repositories.TweetsRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import twitter4j.TwitterStream;

@Service
public class TweetsServiceImpl implements TweetsService {

    @Autowired
    TwitterStream twitterStream;

    @Autowired
    TweetsRepository repo;


    private static Logger logger = LoggerFactory.getLogger(TweetsServiceImpl.class);

    @Override
    public List<Tweet> getAllTweets() {
        return new ArrayList<Tweet>();
    }

    @Override
    public Tweet save(Tweet tweet) {
        return repo.save(tweet);
    }

}
