package com.amorenog.tweetapi.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.amorenog.tweetapi.models.Location;
import com.amorenog.tweetapi.models.Tweet;
import com.amorenog.tweetapi.models.User;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import twitter4j.GeoLocation;
import twitter4j.Status;

@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
public class StatusToTweetConverterTests {
    
    private static StatusToTweetConverter converter;
    private static long mockId = 123L;
    private static String mockText = "This is a tweet";
    private static String mockLang= "en";
    private static long mockUserId= 12L;
    private static String mockUserName = "Nemo nobody";
    private static int mockUserFollowersCount = 11200;
    private static double testLatitude = 11.5;
    private static double testLongitude = 31.5;

    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    static Status mockStatus;

    @Mock
    static twitter4j.User mockUser;

    static GeoLocation testGeoLocation;

    @BeforeAll
    void setUp(){
        converter = new StatusToTweetConverter();
        testGeoLocation = new GeoLocation(testLatitude, testLongitude);
    }
    @Test
    void testUserConversion(){
        when(mockUser.getId()).thenReturn(mockUserId);
        when(mockUser.getName()).thenReturn(mockUserName);
        when(mockUser.getFollowersCount()).thenReturn(mockUserFollowersCount);
        User result = converter.convertUser(mockUser);
        assertEquals(mockUserId, result.getId());
        assertEquals(mockUserName, result.getName());
        assertEquals(mockUserFollowersCount, result.getFollowersCount());
    }

    @Test
    void testLocationConversion(){
        Location result = converter.convertLocation(testGeoLocation);
        assertEquals(testLatitude, result.getXCoordinate());
        assertEquals(testLongitude, result.getYCoordinate());
    }

    @Test
    void testTweetConversion(){
        when(mockStatus.getId()).thenReturn(mockId);
        when(mockStatus.getText()).thenReturn(mockText);
        when(mockStatus.getLang()).thenReturn(mockLang);
        when(mockStatus.getUser().getId()).thenReturn(mockUserId);
        when(mockStatus.getUser().getName()).thenReturn(mockUserName);
        when(mockStatus.getUser().getFollowersCount()).thenReturn(mockUserFollowersCount);
        when(mockStatus.getGeoLocation()).thenReturn(testGeoLocation);
        Tweet result = converter.convertStatus(mockStatus);
        assertEquals(mockId, result.getId());
        assertEquals(mockText, result.getText());
        assertEquals(mockLang, result.getLanguage());
    }



}
