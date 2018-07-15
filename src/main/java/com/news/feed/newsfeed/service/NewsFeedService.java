package com.news.feed.newsfeed.service;

import java.util.List;

import com.news.feed.vo.NewsVO;

public interface NewsFeedService {
	public Boolean saveNews(NewsVO newsvo);
	public NewsVO getNewsByTimeStamp(String tm);
	public List<NewsVO> getLatestBreakingNews();
}
