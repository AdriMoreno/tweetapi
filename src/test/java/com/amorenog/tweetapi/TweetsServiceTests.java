package com.amorenog.tweetapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;

import java.util.Arrays;

import com.amorenog.tweetapi.models.Tweet;
import com.amorenog.tweetapi.models.User;
import com.amorenog.tweetapi.repositories.TweetsRepository;
import com.amorenog.tweetapi.services.TweetsServiceImpl;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class TweetsServiceTests {

    static Logger log = LoggerFactory.getLogger(TweetsServiceTests.class);

    @MockBean
    TweetsRepository mockRepo;

    @Autowired
    TweetsServiceImpl service;

    @Captor
    ArgumentCaptor<Tweet> tweetCaptor;

    @Captor
    ArgumentCaptor<User> userCaptor;

    @Value("${filter.followers.threshold}")
    private int followersThreshold;

    @Value("${filter.languages}")
    private String languages;

    public void contextLoads(){
    }

    @Test
    void connectionTest() {
        verify(mockRepo, timeout(1000).atLeastOnce()).save(any());
    }

    @Test
    void filterTest() {
        verify(mockRepo, timeout(2000).atLeastOnce()).save(tweetCaptor.capture());
        tweetCaptor.getAllValues().stream()
        .map(t -> t.getLanguage())
        .peek(l -> log.info(l))
        .forEach(l -> assertTrue(languages.contains(l)));
    }

}