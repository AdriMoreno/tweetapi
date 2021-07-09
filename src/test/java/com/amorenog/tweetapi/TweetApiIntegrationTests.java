package com.amorenog.tweetapi;

import com.amorenog.tweetapi.controllers.TweetsApiController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
// @RunWith(SpringRunner.class)
public class TweetApiIntegrationTests {

    @Autowired
	private TweetsApiController controller;

   
    
}
