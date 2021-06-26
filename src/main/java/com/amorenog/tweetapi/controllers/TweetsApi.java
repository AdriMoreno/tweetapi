package com.amorenog.tweetapi.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import com.amorenog.tweetapi.ApiMessage;
import com.amorenog.tweetapi.models.Tweet;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/tweets")
public interface TweetsApi {
    
    @GetMapping
    ResponseEntity<List<Tweet>> getAllTweets();

    @PostMapping
    ResponseEntity<ApiMessage> addTweet(Tweet tweetToAdd);

    @PostMapping(value="/{id}")
    ResponseEntity<ApiMessage> validateTweet(@PathParam(value = "id") String id);
}
