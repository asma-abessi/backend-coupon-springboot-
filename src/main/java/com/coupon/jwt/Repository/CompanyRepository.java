package com.youtube.jwt.Repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.youtube.jwt.entity.Company;


@Repository 
public interface CompanyRepository extends CrudRepository<Company, Long>  {

}	
