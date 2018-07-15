package com.news.feed.NewsFeed;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.news.feed.newsfeed.service.NewsFeedService;
import com.news.feed.vo.NewsVO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NewsFeedApplicationTests {
	
		@Autowired 
	NewsFeedService newsFeedService;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void newsFeedServiceNotNullTest() {
		assertNotNull(newsFeedService);
	}
	@Test
	public void saveNewsTest1() {
		NewsVO newsvo= new NewsVO();
		newsvo.setNewsContentType("Finance");
		newsvo.setNewsPriority(2);
		newsvo.setNewsTime("00:00:02:234");
		newsvo.setNewsHeading("Heading1");
		newsvo.setNewsContent("Finance:News Content");
		boolean save=newsFeedService.saveNews(newsvo);
		assertTrue(save);
		
	}
	
	@Test
	public void saveNewsTest2() {
		NewsVO newsvo= new NewsVO();
		newsvo.setNewsContentType("Sports");
		newsvo.setNewsPriority(2);
		newsvo.setNewsTime("00:00:02:234");
		newsvo.setNewsHeading("Heading1");
		newsvo.setNewsContent("Finance:News Content");
		boolean save=newsFeedService.saveNews(newsvo);
		assertTrue(save);
		
	}
	@Test
	public void saveNewsTest3() {
		NewsVO newsvo= new NewsVO();
		newsvo.setNewsContentType("General");
		newsvo.setNewsPriority(2);
		newsvo.setNewsTime("00:00:02:234");
		newsvo.setNewsHeading("Heading1");
		newsvo.setNewsContent("Finance:News Content");
		boolean save=newsFeedService.saveNews(newsvo);
		assertTrue(save);
		
	}
	
	@Test (expected = RuntimeException.class)
	public void saveNewsTest4() {
		NewsVO newsvo= new NewsVO();
		newsvo.setNewsContentType("Finance");
		newsvo.setNewsPriority(3);
		newsvo.setNewsTime("00:00:02:234");
		newsvo.setNewsHeading("Heading1");
		newsvo.setNewsContent("Finance:News Content");
		newsFeedService.saveNews(newsvo);
		
		
	}
	@Test (expected = RuntimeException.class)
	public void saveNewsTest5() {
		NewsVO newsvo= new NewsVO();
		newsvo.setNewsContentType("Finance1");
		newsvo.setNewsPriority(2);
		newsvo.setNewsTime("00:00:02:234");
		newsvo.setNewsHeading("Heading1");
		newsvo.setNewsContent("Finance:News Content");
		newsFeedService.saveNews(newsvo);
		
		
	}
	@Test
	public void getNewsByTimeStampTest() {
		NewsVO newsvo=newsFeedService.getNewsByTimeStamp("14-JUL-18 09.50.11.822000000 PM");
		assertNotNull(newsvo);
	}
	@Test
	public void getLatestBreakingNewsTest() {
		NewsVO newsvo= new NewsVO();
		newsvo.setNewsContentType("Sports");
		newsvo.setNewsPriority(1);
		newsvo.setNewsTime("00:00:01:234");
		newsvo.setNewsHeading("Heading2");
		newsvo.setNewsContent("Sports:News Content");
		boolean save=newsFeedService.saveNews(newsvo);
		assertTrue(save);
		
		newsvo= new NewsVO();
		newsvo.setNewsContentType("General");
		newsvo.setNewsPriority(1);
		newsvo.setNewsTime("00:00:01:234");
		newsvo.setNewsHeading("Heading2");
		newsvo.setNewsContent("Sports:News Content");
		 save=newsFeedService.saveNews(newsvo);
		assertTrue(save);
		
		List<NewsVO> newsList=newsFeedService.getLatestBreakingNews();

		assertTrue(newsList.size()>1);
	}
	
	

}
