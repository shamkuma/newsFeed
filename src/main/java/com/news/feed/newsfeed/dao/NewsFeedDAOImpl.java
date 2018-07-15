package com.news.feed.newsfeed.dao;

import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.news.feed.vo.NewsVO;

@Repository
public class NewsFeedDAOImpl implements NewsFeedDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	private Map<String, LinkedList<NewsVO>> breakingNewsList = new ConcurrentHashMap<String, LinkedList<NewsVO>>();

	@PostConstruct
	public void init() {
		LinkedList<NewsVO> newList = new LinkedList<NewsVO>();
		breakingNewsList.put("breakingNews", newList);
	}

	public boolean saveNews(NewsVO newsvo) {

		if (newsvo.getNewsPriority() == 2) {
			String sql = NewsFeedDAO.NEWS_SAVE_QUERY;
			LobHandler lobHandler = new DefaultLobHandler();
			jdbcTemplate.execute(sql, new AbstractLobCreatingPreparedStatementCallback(lobHandler) {
				@Override
				protected void setValues(PreparedStatement ps, LobCreator lobCreator)
						throws SQLException, DataAccessException {

					ps.setString(1, getNextNewsFeedSeq().toString());
					
					String contentType= newsvo.getNewsContentType();
					if(StringUtils.isEmpty(contentType)){
						throw new RuntimeException("News Content Type Not Defined; Accepted Value{(Sports, Finance, General)");
					}
					switch (contentType.toLowerCase()) {
					case "finance":
						ps.setString(2, newsvo.getNewsContentType());
						break;
					case "sports":
						ps.setString(2, newsvo.getNewsContentType());
						break;
					case "general":
						ps.setString(2, newsvo.getNewsContentType());
						break;
					default:
						throw new RuntimeException("News Content Type Not Defined; Accepted Value{(Sports, Finance, General)");
					}
					
					ps.setString(3, newsvo.getNewsPriority().toString());
					ps.setString(4, newsvo.getNewsTime().toString());
					ps.setString(5, newsvo.getNewsHeading());
					if (!StringUtils.isEmpty(newsvo.getNewsContent())) {
						Reader reader = new StringReader(newsvo.getNewsContent());
						lobCreator.setClobAsCharacterStream(ps, 6, reader, newsvo.getNewsContent().length());
					} else {
						ps.setString(6, null);
					}
					Timestamp timestamp = new Timestamp(System.currentTimeMillis());

					ps.setTimestamp(7, timestamp);

				}
			});

		} else if(newsvo.getNewsPriority() == 1){
			storeInMemory(newsvo);
		}else {
			throw new RuntimeException("News Priority Invalid; Accepted {1-Breaking,2-General}");
		}
		
		return true;
	}
	/*
	 * get newsFeed from DB
	 */

	public NewsVO getNewsByTimeStamp(String tm) {
		String query = NewsFeedDAO.GET_NEWS_BY_TIMESTAMP;
		query=query.replace("_insts_", tm);
		
		List<NewsVO> newsList =jdbcTemplate.query(query, (resultSet, i) -> {
			
             return toNewsVO(resultSet);
         });
 

		return newsList.get(0);

	}

	/*
	 * get latest 100 breaking news
	 */
	public List<NewsVO> getLatestBreakingNews() {
		return breakingNewsList.get("breakingNews").stream().limit(100).collect(Collectors.toList());
	}

	private Integer getNextNewsFeedSeq() {
		Integer seq = (Integer) jdbcTemplate.queryForObject(NewsFeedDAO.NEWS_FEED_SEQ_QUERY, Integer.class);
		return seq;
	}

	private void storeInMemory(NewsVO newsvo) {
		LinkedList<NewsVO> newsList = breakingNewsList.get("breakingNews");
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());

		newsvo.setInsertionTime(timestamp);
		newsList.addFirst(newsvo);
		breakingNewsList.put("breakingNews", newsList);
	}
	//news_id,news_content_type,news_priority,news_time,news_heading,news_content,ins_ts
	private NewsVO toNewsVO(ResultSet resultSet) throws SQLException {
		NewsVO newsvo = new NewsVO();
	      newsvo.setNewsContentType(resultSet.getString("news_content_type"));
	      newsvo.setNewsPriority(resultSet.getInt("news_priority"));
	      //news_time
	      newsvo.setNewsTime(resultSet.getString("news_time"));
	      newsvo.setNewsHeading(resultSet.getString("news_heading"));
	      InputStream contentStream = resultSet.getClob("news_content")
	                                           .getAsciiStream();
	      String newsContent =
	              new Scanner(contentStream, "UTF-8").useDelimiter("\\A").next();
	      newsvo.setNewsContent(newsContent);
	      
	      newsvo.setInsertionTime(resultSet.getDate("ins_ts"));
	      return newsvo;
	  }

}
