package com.news.feed.newsfeed.dao;

import java.util.List;

import com.news.feed.vo.NewsVO;

public interface NewsFeedDAO {
	
	String NEWS_SAVE_QUERY="insert into newsfeed (news_id,news_content_type,news_priority,news_time,news_heading,news_content,ins_ts) values(?,?,?,?,?,?,?)";
	String NEWS_FEED_SEQ_QUERY="select newsfeed_seq.nextval from dual";
	String GET_NEWS_BY_TIMESTAMP="select * from newsfeed where INS_TS='_insts_'";
	public boolean saveNews(NewsVO newsvo);
	public NewsVO getNewsByTimeStamp(String tm);
	public List<NewsVO> getLatestBreakingNews();

}
