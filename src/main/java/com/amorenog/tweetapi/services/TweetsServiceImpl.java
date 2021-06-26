package com.amorenog.tweetapi.services;

import java.util.ArrayList;
import java.util.List;

import com.amorenog.tweetapi.models.Tweet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;

@Service
public class TweetsServiceImpl implements TweetsService {

    private static Logger logger = LoggerFactory.getLogger(TweetsServiceImpl.class);
    @Override
    public List<Tweet> getAllTweets() {
        // TODO: Add twitter4j listener for status.
        return new ArrayList<Tweet>();
    }

    @Override
    public void setTweetsListener() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true).setOAuthConsumerKey("").setOAuthConsumerSecret("").setOAuthAccessToken("")
                .setOAuthAccessTokenSecret("");
        TwitterStream twitterStream = new TwitterStreamFactory(cb.build()).getInstance();
        StatusListener listener = new StatusListener() {
            @Override
            public void onStatus(Status status) {
                logger.info("@" + status.getUser().getScreenName() + " - " + status.getText());
            }

            @Override
            public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
                logger.info("Got a status deletion notice id:" + statusDeletionNotice.getStatusId());
            }

            @Override
            public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
                logger.info("Got track limitation notice:" + numberOfLimitedStatuses);
            }

            @Override
            public void onScrubGeo(long userId, long upToStatusId) {
                logger.info("Got scrub_geo event userId:" + userId + " upToStatusId:" + upToStatusId);
            }

            @Override
            public void onStallWarning(StallWarning warning) {
                logger.info("Got stall warning:" + warning);
            }

            @Override
            public void onException(Exception ex) {
                logger.error("Exception on StatusListener", ex);
            }
        };
        twitterStream.addListener(listener);
        twitterStream.sample();
    }

}
