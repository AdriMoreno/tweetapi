package com.amorenog.tweetapi;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;

import java.util.Arrays;

import com.amorenog.tweetapi.models.Tweet;
import com.amorenog.tweetapi.models.User;
import com.amorenog.tweetapi.repositories.TweetsRepository;
import com.amorenog.tweetapi.services.TweetsServiceImpl;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class TweetsServiceTests {

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
        // TODO: Check that the followers and language filter is working.
        verify(mockRepo).save(tweetCaptor.capture());
        assertTrue(tweetCaptor.getAllValues().stream()
        .map(t -> t.getLanguage())
        .allMatch(s -> Arrays.stream(languages.split(",")).anyMatch(l -> l.equals(s))));
    }

}