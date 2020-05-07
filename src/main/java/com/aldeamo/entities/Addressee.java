package com.aldeamo.entities;

import com.google.gson.Gson;

public class Addressee {
	
	String mobile;
	String URL;
	
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	
	@Override
	public String toString() {
		return new Gson().toJson(this);
	} 

}
