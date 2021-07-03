package com.amorenog.tweetapi;

import com.amorenog.tweetapi.repositories.TweetsRepository;
import com.amorenog.tweetapi.services.TweetsServiceImpl;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TweetsServiceTests {
    
    @Mock
    TweetsRepository mockRepo;

    @InjectMocks
    TweetsServiceImpl service;

    
}
