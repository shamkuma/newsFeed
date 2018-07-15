package com.news.feed.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InputVO {
	@JsonProperty
  private String timeStamp;

	/**
	 * @return the timeStamp
	 */
	public String getTimeStamp() {
		return timeStamp;
	}

	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
}
