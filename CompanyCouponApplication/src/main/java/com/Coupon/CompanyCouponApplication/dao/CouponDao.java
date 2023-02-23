package com.Coupon.CompanyCouponApplication.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.Coupon.CompanyCouponApplication.dto.Coupon;
import com.Coupon.CompanyCouponApplication.repository.CouponRepo;

@Repository
public class CouponDao 
{

	@Autowired
	CouponRepo couponrepo;
	
	public void generateCoupon(Coupon coupon)
	{
		couponrepo.save(coupon);
	}
	
	public List<Coupon> checkValidity()
	{
		return couponrepo.findAll();
	}
	
}
