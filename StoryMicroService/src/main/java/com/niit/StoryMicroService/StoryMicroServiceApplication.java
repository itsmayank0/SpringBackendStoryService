package com.niit.StoryMicroService;

import com.niit.StoryMicroService.Filters.JWTFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StoryMicroServiceApplication {

	@Bean
	public FilterRegistrationBean jwtFilter()
	{
		FilterRegistrationBean filterRegistrationBean=
				new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new JWTFilter());
		filterRegistrationBean.addUrlPatterns("/api/storyManagement/*");

		return filterRegistrationBean;
	}

	public static void main(String[] args) {
		SpringApplication.run(StoryMicroServiceApplication.class, args);
	}

}
