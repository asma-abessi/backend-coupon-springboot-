package com.youtube.jwt.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.youtube.jwt.entity.Coupon;

@Repository 
public interface CouponRepository  extends CrudRepository<Coupon, Long>  {
	@Query("SELECT u FROM Coupon u join u.company f WHERE (f.idCompany LIKE :idCompany )")
	List<Coupon> retrieveCouponCompany(@Param("idCompany") Long idCompany);
	
}
