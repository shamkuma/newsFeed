package com.news.feed.newsfeed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"com.news.feed.newsfeed.*"})


public class NewsFeedApplication {

	
	   
	public static void main(String[] args) {
		SpringApplication.run(NewsFeedApplication.class, args);
	}
}
