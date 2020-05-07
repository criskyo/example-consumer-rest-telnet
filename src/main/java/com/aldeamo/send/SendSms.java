package com.aldeamo.send;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.aldeamo.entities.Addressee;
import com.aldeamo.entities.SmsBody;



public class SendSms {
	
	private static final Logger logger = LoggerFactory.getLogger(SendSms.class);
	
	
	public ResponseEntity<String> sendSms() {
		
		SmsBody smsBody = new SmsBody();
		Addressee addressee = new Addressee();
		List <Addressee> listAddressee = new ArrayList<>();
		
		smsBody.setCountry("57");
		smsBody.setMessage("puede que jasmin se encuentre abajo revisar!!");
		smsBody.setMessageFormat("1");
		addressee.setMobile("NUMBER");
		addressee.setURL("");
		listAddressee.add(addressee);
		smsBody.setAddresseeList(listAddressee);
		

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		
		String url = "URL";
		
		headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));

		
		headers.set("Content-Type", "application/json");
		headers.set("Authorization", "Basic BASIC_AUT");
		headers.set("Content-Type", "application/json");
		headers.setContentType(MediaType.APPLICATION_JSON);

		logger.info("headers:{} ", headers.toString());
		logger.info("smsBody :{} ", smsBody.toString());
		logger.info("urltigosendsms :{} ", url);

		HttpEntity<String> entity = new HttpEntity<>(smsBody.toString(), headers);
		ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class,
				new Object[0]);

		logger.info("request :{}", response);

		return response;

	}
	
	
//	public static void main(String[] args) {
//		SendSms sms = new SendSms();
//		System.out.println(sms.sendSms());
//	}
//	

}
