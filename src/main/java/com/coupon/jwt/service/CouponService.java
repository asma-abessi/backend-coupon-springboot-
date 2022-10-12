package com.youtube.jwt.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.youtube.jwt.Repository.CompanyRepository;
import com.youtube.jwt.Repository.CouponRepository;
import com.youtube.jwt.entity.Company;
import com.youtube.jwt.entity.Coupon;

@Service
public class CouponService implements ICouponService {
	@Autowired 
	CompanyRepository companyRepo;
	@Autowired 
	CouponRepository couponRepo;
	
	
	
	@Override
	public Coupon addCouponToCompany(Coupon c, long idCompany) {
		Company t = companyRepo.findById(idCompany).orElse(null);
	c.setCompany(t);
	return couponRepo.save(c);
	}

	@Override
	public List<Coupon> retrieveAllCouponsbycompany(Long idCompany) {
		return (List<Coupon>) couponRepo.retrieveCouponCompany(idCompany);
	}
	
	@Override
	public Coupon retrieveCouponById(Long idCoupon) {

		return couponRepo.findById(idCoupon).orElse(null);
	}
	
	@Override
	
	public List<Coupon> deleteCoupon(Long idCoupon, Long idCompany) {
		 couponRepo.deleteById(idCoupon);
		 return (List<Coupon>) couponRepo.retrieveCouponCompany(idCompany);
		
	}
	
	@Override
	public Coupon updateCouponById(Coupon o,Long idCoupon) {
	
		Coupon opp= couponRepo.findById(idCoupon).orElse(null);
		opp.setProductName(o.getProductName());
		opp.setCode(o.getCode());
		opp.setDateD(o.getDateD());
		opp.setDateF(o.getDateF());
		couponRepo.save(opp);
	return opp;
	}
}
