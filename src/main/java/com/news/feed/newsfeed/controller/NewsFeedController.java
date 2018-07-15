package com.news.feed.newsfeed.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.news.feed.newsfeed.service.NewsFeedService;
import com.news.feed.vo.InputVO;
import com.news.feed.vo.NewsVO;


@RestController
public class NewsFeedController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	NewsFeedService newsFeedService;

	@RequestMapping(value = "/storeNewsFeed", method = RequestMethod.POST,consumes = { MediaType.APPLICATION_JSON })
	
	public String consumeNewsFeed(@RequestBody NewsVO newsvo) {
		
		Boolean result=newsFeedService.saveNews(newsvo);
		if(result) {
			return "News Saved";
		}else {
			return "There are some issue in storing News Feed";
		}
	}
	
	@RequestMapping(value = "/getNews", method = RequestMethod.POST,produces= {MediaType.APPLICATION_JSON})
	@Consumes( MediaType.APPLICATION_JSON )
	public NewsVO getNews(@RequestBody InputVO inputVo) {
		logger.info("NewsFeedController :getNews");
		return  newsFeedService.getNewsByTimeStamp(inputVo.getTimeStamp());
	}
	
	@RequestMapping(value = "/getBreakingNews", method = RequestMethod.GET,produces= {MediaType.APPLICATION_JSON})
	public List<NewsVO> getBreakingNews() {
		return newsFeedService.getLatestBreakingNews();
	}
}
