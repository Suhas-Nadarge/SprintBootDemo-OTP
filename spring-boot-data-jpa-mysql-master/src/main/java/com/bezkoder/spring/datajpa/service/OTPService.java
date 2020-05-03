package com.bezkoder.spring.datajpa.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bezkoder.spring.datajpa.model.Mobile;
import com.bezkoder.spring.datajpa.repository.MobileRepository;

@Service
public class OTPService {

	@Autowired
	MobileRepository mobileRepository;
	public int generateOTP() {
		Random random = new Random();
		int otp = 100000 + random.nextInt(900000);
	    return otp;
	}
	
	public String sendOTP(String mobile, int otp) {
		final String uri = "http://49.50.67.32/smsapi/httpapi.jsp?username=MENUKT03&password=MENUKT@456&from=MENUKT&to="+mobile+"&text=Hellooo OTP for your number is-"+otp+"&coding=0";
	    RestTemplate restTemplate = new RestTemplate();
	    restTemplate.getForObject(uri, String.class);
		return "OTP sent successfully";
	}
	 
	public List <Mobile> getByMobileNumber(String mobile)  {
		List <Mobile> mobileObj =  mobileRepository.findBymobileNumber(mobile);
		return mobileObj;
	}
	
	public String verifyOTP(Mobile EnteredOTP) {
		List <Mobile> mobileObj = this.getByMobileNumber(EnteredOTP.mobileNumber);
		if(EnteredOTP.otp == mobileObj.get(mobileObj.size()-1).otp) {
		return "Success";
		}
		return "Fail";
    }
}
