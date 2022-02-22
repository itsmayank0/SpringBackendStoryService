package com.niit.StoryMicroService.Respository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.niit.StoryMicroService.Models.Story;
import org.springframework.stereotype.Repository;

@Repository
public interface IStoryRepository extends MongoRepository<Story, String> {

}
