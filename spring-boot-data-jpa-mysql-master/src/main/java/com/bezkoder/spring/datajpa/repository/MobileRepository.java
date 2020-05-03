package com.bezkoder.spring.datajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.bezkoder.spring.datajpa.model.Mobile;

@Service
public interface MobileRepository extends JpaRepository<Mobile, String> {
//	List<Mobile> findByNumber(String mobileNumber);
	List<Mobile> findBymobileNumber(String mobileNumber);
	List<Mobile> findAllById(String mobileNumber);
}
