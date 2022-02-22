package com.niit.StoryMicroService.Controller;

import com.niit.StoryMicroService.Services.IStoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/storyManagement/")
public class StoryController {

    @Autowired
    private IStoryService storyService;

    @GetMapping("/stories")
    @Operation(summary="Getting all Stories of Specific user")
    @ApiResponses(value= {

            @ApiResponse(responseCode="200",description="Success || OK"),
            @ApiResponse(responseCode="401",description="Unauthorized"),
            @ApiResponse(responseCode="403",description="forbidden"),
            @ApiResponse(responseCode="404",description="Resource not found"),
            @ApiResponse(responseCode="500",description="Internal Server Error")
    })
    public ResponseEntity<?> getAllProducts()
    {
        return new ResponseEntity<>(storyService.getAllStories(), HttpStatus.OK);
    }

}
