package com.example.demo;

import java.io.Serializable;

public class Token implements Serializable{
	
	private String short_url;
	private String long_url;
	public String getShort_url() {
		return short_url;
	}
	public void setShort_url(String short_url) {
		this.short_url = short_url;
	}
	public String getLong_url() {
		return long_url;
	}
	public void setLong_url(String long_url) {
		this.long_url = long_url;
	}
	public Token(String short_url, String long_url) {
		super();
		this.short_url = short_url;
		this.long_url = long_url;
	}

}
