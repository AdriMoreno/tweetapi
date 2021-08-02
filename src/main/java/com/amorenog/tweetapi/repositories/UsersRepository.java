package com.amorenog.tweetapi.repositories;

import com.amorenog.tweetapi.models.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User,Long>{

}
