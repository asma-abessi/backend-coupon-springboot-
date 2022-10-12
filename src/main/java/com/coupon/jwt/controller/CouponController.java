package com.youtube.jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.youtube.jwt.entity.Coupon;

import com.youtube.jwt.service.CouponService;

@RestController
public class CouponController {

	 @Autowired
	    private CouponService couponServ;
	
	 @PostMapping("/add-coupon/{company-id}")
	 @PreAuthorize("hasRole('Admin')")
	 @ResponseBody
	 public Coupon addCoupon(@RequestBody Coupon c,@PathVariable ("company-id")  long idCompany) 
	{
		return couponServ.addCouponToCompany(c, idCompany);
	 }
	 
	 @GetMapping("/retrieve-Company-coupon/{company-id}") 
		@ResponseBody 
		public List<Coupon> retrieveFournisseurProduit(@PathVariable("company-id") Long idCompany) { 
			return couponServ.retrieveAllCouponsbycompany(idCompany);
		} 
	 
	 @GetMapping("/retrieve-coupon/{coupon-id}")
		@ResponseBody
		public Coupon retrieveCouponById(@PathVariable("coupon-id") Long idCoupon) {
		return couponServ.retrieveCouponById(idCoupon);
		}
	 
	 @DeleteMapping("/removeCoupon/{coupon-id}/{company-id}")
	 @ResponseBody
	 public List<Coupon> removeCoupon(@PathVariable("coupon-id") Long idCoupon,@PathVariable("company-id") Long idCompany) {
		return couponServ.deleteCoupon(idCoupon, idCoupon);
	 }
	 
		@PutMapping("/modify-coupon/{coupon-id}")
		@ResponseBody
		public Coupon ModifyCoupon(@PathVariable("coupon-id") Long idCoupon,@RequestBody Coupon o)
		{
			return couponServ.updateCouponById(o, idCoupon);
		}
		
}
