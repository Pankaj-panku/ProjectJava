package com.Coupon.CompanyCouponApplication.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Coupon.CompanyCouponApplication.dao.CouponDao;
import com.Coupon.CompanyCouponApplication.dto.Coupon;
import java.util.*;

@RestController
public class CouponController 
{

	@Autowired
	CouponDao coupondao;
	
	@PostMapping("/coupon")
	public int generateCoupon(@RequestBody Coupon coupon)
	{
		Random random = new Random();
        int OTP = random.nextInt(900000) + 100000;
        coupon.setOTP(OTP);
        coupon.setStatus("Valid");
        coupondao.generateCoupon(coupon);
		return OTP;
	}
	
	@GetMapping("/checkcoupon")
	public String checkCoupons(@RequestParam int OTP)
	{
		List<Coupon> c= coupondao.checkValidity();
		for(Coupon cou:c)
		{
			if(cou.getOTP()==OTP)
			{
				return "Valid and Amount is "+cou.getAmount();
			}
		}
		return "Not Valid";
	}
	
	@PutMapping("/couponupdatestatus")
	public String couponstatusupdate(@RequestParam int OTP)
	{
		List<Coupon> c= coupondao.checkValidity();
		Coupon co=null;
		for(Coupon cou:c)
		{
			if(cou.getOTP()==OTP)
			{
				co=cou;
				break;
			}
		}
		if(co==null)
		{
			return "Coupon Not Found";
		}
		else
		{
			co.setStatus("Not Valid");
			coupondao.generateCoupon(co);
			return "Status Updated";
		}
		
		
	}
	
}
