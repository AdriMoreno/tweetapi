package com.amorenog.tweetapi.listeners;

import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;

public class CustomStatusListener implements StatusListener {
    private static Logger logger = LoggerFactory.getLogger(CustomStatusListener.class);

    private int followersThreshold;
    private Set<String> languages;

    private Consumer<Status> statusConsumer;

    public CustomStatusListener(int followersThreshold, Set<String> languages, Consumer<Status> consumer) {
        this.followersThreshold = followersThreshold;
        this.languages = languages;
        this.statusConsumer = consumer.andThen(status -> logger.debug("Status with id: " + status.getId() + " saved"));
    }

    @Override
    public void onStatus(Status status) {
        if (status.getUser().getFollowersCount() > followersThreshold && languages.contains(status.getLang())) {
            logger.info("@" + status.getUser().getScreenName() + " - " + status.getText() + "Lang:"
                    + status.getLang());
                    statusConsumer.accept(status);
        }
    }

    @Override
    public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
        logger.debug("Got a status deletion notice id:" + statusDeletionNotice.getStatusId());
    }

    @Override
    public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
        logger.debug("Got track limitation notice:" + numberOfLimitedStatuses);
    }

    @Override
    public void onException(Exception ex) {
        logger.error("Exception on listener", ex);
    }

    @Override
    public void onScrubGeo(long userId, long upToStatusId) {
        logger.debug("On Scrub Geo - userId: " + userId + " upToStatusId" + upToStatusId);
    }

    @Override
    public void onStallWarning(StallWarning warning) {
        logger.debug("On StallWarning: " + warning.getMessage());
    }
}