package com.Coupon.CompanyCouponApplication.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.Coupon.CompanyCouponApplication.dto.*;


public interface CouponRepo extends JpaRepository<Coupon,Integer> {

	
}
