package com.amorenog.tweetapi;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import com.amorenog.tweetapi.controllers.TweetsApi;
import com.amorenog.tweetapi.controllers.TweetsApiController;
import com.amorenog.tweetapi.models.Location;
import com.amorenog.tweetapi.models.Tweet;
import com.amorenog.tweetapi.models.User;
import com.amorenog.tweetapi.services.TweetsServiceImpl;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TweetApiApplicationTests {

	private User emptyUser;
	private Location mockLocation;

	@InjectMocks
	TweetsApiController tweetsApi;

	@Mock
	TweetsServiceImpl tweetsService;

	@Test
	void contextLoads() {
		emptyUser = new User(0);
		mockLocation = new Location(0, 0);
	}

	@Test
	void getAllTweets() {
		when(tweetsService.getAllTweets()).thenAnswer(invocation -> getTweetList());
		Assertions.assertEquals(getTweetList(), tweetsApi.getAllTweets().getBody());
	}

	private List<Tweet> getTweetList() {
		return Arrays.asList(new Tweet(0, mockLocation, emptyUser),
		 new Tweet(123, mockLocation, emptyUser));

	}

}