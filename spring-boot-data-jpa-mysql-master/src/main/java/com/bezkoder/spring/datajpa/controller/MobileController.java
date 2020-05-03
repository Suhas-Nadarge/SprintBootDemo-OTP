package com.bezkoder.spring.datajpa.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.datajpa.model.Mobile;
import com.bezkoder.spring.datajpa.repository.MobileRepository;
import com.bezkoder.spring.datajpa.service.OTPService;

import net.bytebuddy.dynamic.loading.PackageDefinitionStrategy.Definition.Undefined;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class MobileController {

	@Autowired
	MobileRepository mobileRepository;
	
	@Autowired
	OTPService otpservice;

	@GetMapping(value = "/generate/{mobile}")
	public String generateOTP(@PathVariable("mobile") String mobile) {	
//		Generate OTP for given number
	int otp = otpservice.generateOTP();

//	Save otp and mobile number in db
	   LocalDateTime now = LocalDateTime.now();  
	mobileRepository.save(new Mobile(now,mobile,otp));
	
//	Sending otp to given number using cellx api
	return otpservice.sendOTP(mobile, otp);
	}
	
	@PostMapping("/verify")
	public String verifyOTP(@RequestBody Mobile mobile) {
		return otpservice.verifyOTP(mobile);
	}
}




//Mobile mobileObj = otpservice.getByMobileNumber(mobile);
//if(mobileObj.mobileNumbe) {
//	
//}
//mobileRepository.deleteById(mobile);
