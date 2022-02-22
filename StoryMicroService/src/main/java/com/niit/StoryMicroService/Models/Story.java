package com.niit.StoryMicroService.Models;

import lombok.*;
import nonapi.io.github.classgraph.json.Id;
import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Story {
    @Id
    private String storyId;
    private String storyUserId;
    private String storyCaption;
    private String storyCaptionColor;
    private Date storyDate;

    private Binary[] storyImages;
}
