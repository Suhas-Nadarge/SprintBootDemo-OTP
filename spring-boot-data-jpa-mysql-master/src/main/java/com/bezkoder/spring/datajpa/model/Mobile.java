package com.bezkoder.spring.datajpa.model;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "mobile_otps")
public class Mobile {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column (name= "time_stamp")
	public LocalDateTime time_stamp;

	@Column(name = "mobile_number")
	public String mobileNumber;

	@Column(name = "otp")
	public int otp;
	
	public Mobile(LocalDateTime time_stamp, String mobileNumber, int otp) {
		super();
		this.time_stamp = time_stamp;
		this.mobileNumber = mobileNumber;
		this.otp = otp;
	}

	public LocalDateTime getTime_stamp() {
		return time_stamp;
	}

	public void setTime_stamp(LocalDateTime time_stamp) {
		this.time_stamp = time_stamp;
	}

	
	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}


	public Mobile() {

	}

	

}
