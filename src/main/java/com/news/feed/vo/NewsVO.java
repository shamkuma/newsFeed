package com.news.feed.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NewsVO {
	
	@JsonProperty
	private String newsContentType;
	
	@JsonProperty
	private Integer newsPriority;
	
	@JsonProperty
	private String newsTime;
	
	@JsonProperty
	private String newsHeading;
	
	@JsonProperty
	private String newsContent;
	
	private Date insertionTime;

	/**
	 * @return the insertionTime
	 */
	public Date getInsertionTime() {
		return insertionTime;
	}

	/**
	 * @param insertionTime the insertionTime to set
	 */
	public void setInsertionTime(Date insertionTime) {
		this.insertionTime = insertionTime;
	}

	/**
	 * @return the newsContentType
	 */
	public String getNewsContentType() {
		return newsContentType;
	}

	/**
	 * @param newsContentType
	 *            the newsContentType to set
	 */
	public void setNewsContentType(String newsContentType) {
		this.newsContentType = newsContentType;
	}

	/**
	 * @return the newsPriority
	 */
	public Integer getNewsPriority() {
		return newsPriority;
	}

	/**
	 * @param newsPriority
	 *            the newsPriority to set
	 */
	public void setNewsPriority(Integer newsPriority) {
		this.newsPriority = newsPriority;
	}

	/**
	 * @return the newsTime (Time converted in millisecond to be stored)
	 */
	public String getNewsTime() {
		return newsTime;
	}

	/**
	 * @param newsTime
	 *            the newsTime to set
	 */
	public void setNewsTime(String newsTime) {
		this.newsTime = newsTime;
	}

	/**
	 * @return the newsHeading
	 */
	public String getNewsHeading() {
		return newsHeading;
	}

	/**
	 * @param newsHeading
	 *            the newsHeading to set
	 */
	public void setNewsHeading(String newsHeading) {
		this.newsHeading = newsHeading;
	}

	/**
	 * @return the newsContent
	 */
	public String getNewsContent() {
		return newsContent;
	}

	/**
	 * @param newsContent
	 *            the newsContent to set
	 */
	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}
	@Override
	public String toString() {
		return "newsContentType:"+newsContentType+" newsPriority:"+newsPriority+" newsTime:"+newsTime+" newsHeading:"+newsHeading+" newsContent:"+newsContent; 
	}

}
