package com.news.feed.newsfeed.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.news.feed.newsfeed.dao.NewsFeedDAO;
import com.news.feed.vo.NewsVO;

@Service
public class NewsFeedServiceImpl implements NewsFeedService{
	@Autowired
	NewsFeedDAO newsFeedDAO;
	public Boolean saveNews(NewsVO newsvo) {
		return newsFeedDAO.saveNews(newsvo);
		
	}
	@Override
	public NewsVO getNewsByTimeStamp(String tm) {
		
		return newsFeedDAO.getNewsByTimeStamp(tm);
	}
	@Override
	public List<NewsVO> getLatestBreakingNews() {
		
		return newsFeedDAO.getLatestBreakingNews();
	}
	
	
	
}
