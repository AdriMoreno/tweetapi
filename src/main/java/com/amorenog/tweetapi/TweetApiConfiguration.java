package com.amorenog.tweetapi;

import com.amorenog.tweetapi.listeners.CustomStatusListener;
import com.amorenog.tweetapi.services.TweetsService;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.amorenog.tweetapi.converters.StatusToTweetConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import twitter4j.FilterQuery;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;

@Configuration
public class TweetApiConfiguration {

    @Value("${twitter.api.consumer.token}")
    private String consumerToken;
    @Value("${twitter.api.consumer.secret}")
    private String consumerSecret;
    @Value("${twitter.api.access.token}")
    private String accessToken;
    @Value("${twitter.api.access.secret}")
    private String accessSecret;
    @Value("${filter.followers.threshold}")
    private int followersThreshold;
    @Value("${filter.languages}")
    private String languages;

    @Autowired
    private StatusToTweetConverter converter;
    @Autowired
    private TweetsService service;

    private static Logger logger = LoggerFactory.getLogger(TweetApiConfiguration.class);

    @Bean
    public TwitterStream getTweetStream() {
        final ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true).setOAuthConsumerKey(consumerToken).setOAuthConsumerSecret(consumerSecret)
                .setOAuthAccessToken(accessToken).setOAuthAccessTokenSecret(accessSecret);
        final TwitterStream twitterStream = new TwitterStreamFactory(cb.build()).getInstance();
        final Set<String> languageSet = new HashSet<String>(Arrays.asList(languages.split(",")));
        final StatusListener listener = new CustomStatusListener(followersThreshold, languageSet,
                s -> service.save(converter.convertStatus(s)));
        logger.info("Listener created with threshold: " + followersThreshold);
        twitterStream.addListener(listener);
        logger.info("Listener created with filtered langs: " + Arrays.toString(languages.split(",")));
        twitterStream.sample();
        return twitterStream;
    }

    @Bean
    public StatusToTweetConverter getTweetConverter() {
        return new StatusToTweetConverter();
    }

}
