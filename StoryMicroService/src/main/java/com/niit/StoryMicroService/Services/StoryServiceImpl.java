package com.niit.StoryMicroService.Services;

import com.niit.StoryMicroService.Models.Story;
import com.niit.StoryMicroService.Respository.IStoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoryServiceImpl implements IStoryService{
    @Autowired
    IStoryRepository storyRepository;

    @Override
    public List<Story> getAllStories(){
        return storyRepository.findAll();
    }
}
