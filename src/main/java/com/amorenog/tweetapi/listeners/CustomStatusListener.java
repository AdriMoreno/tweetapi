package com.amorenog.tweetapi.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;

public class CustomStatusListener implements StatusListener {
    private static Logger logger = LoggerFactory.getLogger(CustomStatusListener.class);

    private int followersThreshold;

    public CustomStatusListener(int followersThreshold) {
        this.followersThreshold = followersThreshold;
    }

    @Override
    public void onStatus(Status status) {
        if (status.getUser().getFollowersCount() > followersThreshold) {
            logger.info("@" + status.getUser().getScreenName() + " - " + status.getText() + "Fol:"
                    + status.getUser().getFollowersCount());
        }
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
    public void onException(Exception ex) {
        logger.error("Exception on listener", ex);
    }

    @Override
    public void onScrubGeo(long userId, long upToStatusId) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStallWarning(StallWarning warning) {
        // TODO Auto-generated method stub

    }
}