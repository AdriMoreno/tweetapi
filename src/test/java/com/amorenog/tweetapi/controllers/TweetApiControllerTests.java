package com.amorenog.tweetapi.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.amorenog.tweetapi.models.Location;
import com.amorenog.tweetapi.models.Tweet;
import com.amorenog.tweetapi.models.User;
import com.amorenog.tweetapi.services.TweetsServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TweetApiControllerTests {
	private User emptyUser;
	private Location mockLocation;
	private List<Tweet> mockTweetsList = new ArrayList<>(2);

	@InjectMocks
	TweetsApiController tweetsApi;

	@Mock
	TweetsServiceImpl tweetsService;

	@BeforeEach
	void contextLoads() {
		emptyUser = new User();
		mockLocation = new Location(0, 0);
		Tweet t = new Tweet();
		t.setUser(emptyUser);
		t.setLocation(mockLocation);
		mockTweetsList.add(t);
		Tweet t2 = new Tweet();
		t2.setUser(emptyUser);
		t2.setLocation(mockLocation);
		mockTweetsList.add(t2);	
	}

    @Test
	void getAllTweets() {
		when(tweetsService.getAllTweets()).thenAnswer(invocation -> mockTweetsList);
		assertEquals(mockTweetsList, tweetsApi.getAllTweets().getBody());
	}
}
