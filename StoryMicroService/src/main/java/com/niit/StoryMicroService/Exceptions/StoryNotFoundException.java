package com.niit.StoryMicroService.Exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.CONFLICT,reason="=Sorry Story Not Exist")
public class StoryNotFoundException  extends Exception {
}
