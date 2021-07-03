package com.amorenog.tweetapi.repositories;

import com.amorenog.tweetapi.models.Tweet;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TweetsRepository extends JpaRepository<Tweet,Long>{

}
