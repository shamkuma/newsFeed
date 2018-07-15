package com.news.feed.NewsFeed;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.google.gson.Gson;
import com.news.feed.newsfeed.controller.NewsFeedController;
import com.news.feed.newsfeed.dao.NewsFeedDAO;
import com.news.feed.newsfeed.service.NewsFeedService;
import com.news.feed.vo.InputVO;
import com.news.feed.vo.NewsVO;

@RunWith(SpringRunner.class)
@WebMvcTest(NewsFeedController.class)
public class NewsFeedApplicationControllerTest {
	@Autowired
	private MockMvc mockMvc;

	

	@MockBean
	private NewsFeedService newsFeedService;

	@MockBean
	private NewsFeedDAO newsFeedDAO;

	

	
	

	@Test
	public void storeNewsFeedInDBTest() throws Exception {

		NewsVO newsvo = new NewsVO();
		newsvo.setNewsContentType("Finance");
		newsvo.setNewsPriority(2);
		newsvo.setNewsTime("00:00:02:234");
		newsvo.setNewsHeading("Heading1");
		newsvo.setNewsContent("Finance:News Content");

		
		 Gson gsonObj = new Gson();
		 String jsonStr = gsonObj.toJson(newsvo);
		 
		
		//mockMvc.perform(post("/storeNewsFeed").content(jsonStr).contentType(MediaType.APPLICATION_JSON));
				
	}
	@Test
	public void storeNewsFeedInMemoryTest() throws Exception {

		NewsVO newsvo = new NewsVO();
		newsvo.setNewsContentType("Finance");
		newsvo.setNewsPriority(1);
		newsvo.setNewsTime("00:00:02:234");
		newsvo.setNewsHeading("Heading1");
		newsvo.setNewsContent("Finance:News Content");

		
		 Gson gsonObj = new Gson();
		 String jsonStr = gsonObj.toJson(newsvo);
		 
		 System.out.println(jsonStr);
		  mockMvc.perform(post("/storeNewsFeed").content(jsonStr).contentType(MediaType.APPLICATION_JSON)) ;
		  
		  mockMvc.perform(get("/storeNewsFeed"));
				  
		
				
	}
	
	@Test
	public void getNewsFeedFromDBTest() throws Exception {

		InputVO inputvo=new InputVO();

		inputvo.setTimeStamp("14-JUL-18 09.50.11.822000000 PM");
		 Gson gsonObj = new Gson();
		 String jsonStr = gsonObj.toJson(inputvo);
		 
		 System.out.println(jsonStr);
		  mockMvc.perform(post("/getNews").content(jsonStr).contentType(MediaType.APPLICATION_JSON)) ;
		  
		 			  
		
				
	}
}
