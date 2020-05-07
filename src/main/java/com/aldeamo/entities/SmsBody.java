package com.aldeamo.entities;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class SmsBody {
	
	
	String country;
	String messageFormat;
	String message;
	List<Addressee> addresseeList = new ArrayList<>();
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getMessageFormat() {
		return messageFormat;
	}
	public void setMessageFormat(String messageFormat) {
		this.messageFormat = messageFormat;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Addressee> getAddresseeList() {
		return addresseeList;
	}
	public void setAddresseeList(List<Addressee> addresseeList) {
		this.addresseeList = addresseeList;
	}
	
	@Override
	public String toString() {
		return new Gson().toJson(this);
	} 

}
