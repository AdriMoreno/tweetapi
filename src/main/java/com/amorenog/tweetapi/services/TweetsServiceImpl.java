package com.amorenog.tweetapi.services;

import java.util.ArrayList;
import java.util.List;

import com.amorenog.tweetapi.models.Tweet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
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

    @Value("${twitter.api.consumer.token}")
    private String consumerToken;
    @Value("${twitter.api.consumer.secret}")
    private String consumerSecret;
    @Value("${twitter.api.access.token}")
    private String accessToken;
    @Value("${twitter.api.access.secret}")
    private String accessSecret;

    @Autowired
    TwitterStream twitterStream;

    private static Logger logger = LoggerFactory.getLogger(TweetsServiceImpl.class);

    @Override
    public List<Tweet> getAllTweets() {
        return new ArrayList<Tweet>();
    }

    @Bean
    public TwitterStream getTweetStream() {
        final ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true).setOAuthConsumerKey(consumerToken).setOAuthConsumerSecret(consumerSecret)
                .setOAuthAccessToken(accessToken).setOAuthAccessTokenSecret(accessSecret);
        final TwitterStream twitterStream = new TwitterStreamFactory(cb.build()).getInstance();
        final StatusListener listener = new StatusListener() {
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
        logger.info("Listener created");
        twitterStream.addListener(listener);
        twitterStream.sample();
        return twitterStream;
    }

}
