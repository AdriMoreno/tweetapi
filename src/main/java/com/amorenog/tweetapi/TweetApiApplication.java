package com.amorenog.tweetapi;

import com.amorenog.tweetapi.services.TweetsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TweetApiApplication {

	@Autowired
	TweetsService tweetsService;
	public static void main(String[] args) {
		TweetsService
		SpringApplication.run(TweetApiApplication.class, args);
	}

}
