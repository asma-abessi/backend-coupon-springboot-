package com.youtube.jwt.service;

import java.util.List;

import com.youtube.jwt.entity.Coupon;

public interface ICouponService {

	Coupon addCouponToCompany(Coupon c, long idCompany);

	

	//List<Coupon> retrieveAllCoupons();
	//List<Coupon> deleteCoupon(Long idCoupon);
	Coupon updateCouponById(Coupon o, Long idCoupon);
	Coupon retrieveCouponById(Long idCoupon);



	List<Coupon> retrieveAllCouponsbycompany(Long idCompany);



	List<Coupon> deleteCoupon(Long idCoupon, Long idCompany);

}
