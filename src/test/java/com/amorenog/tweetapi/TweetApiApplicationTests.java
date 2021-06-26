package com.amorenog.tweetapi;

import com.amorenog.tweetapi.controllers.TweetsApi;
import com.amorenog.tweetapi.models.Location;
import com.amorenog.tweetapi.models.Tweet;
import com.amorenog.tweetapi.models.User;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TweetApiApplicationTests {

	private User emptyUser;
	private Location mockLocation;

	@Autowired
	TweetsApi tweetsApi;

	@Test
	void contextLoads() {
		emptyUser = new User(0);
		mockLocation = new Location(0, 0);
	}

	@Test
	void postAndRetrieveTweet() {
		final Tweet tweet = new Tweet(0, mockLocation, emptyUser);
		tweetsApi.addTweet(tweet);
		Assertions.assertEquals(tweet, tweetsApi.getAllTweets().getBody().iterator().next());


	}

}