package com.youtube.jwt.service;

import java.io.Console;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youtube.jwt.Repository.CompanyRepository;
import com.youtube.jwt.Repository.UserDao;
import com.youtube.jwt.entity.Company;
import com.youtube.jwt.entity.User;

@Service
public class CompanyService implements ICompanyService {
	@Autowired 
	CompanyRepository companyRepo;
	@Autowired 
	UserDao userRepo;
    
	@Override
	public List<Company> retrieveAllcompanies() {
		return (List<Company>) companyRepo.findAll();
	}

	@Override
	public Company addCompany(Company c) {
		return companyRepo.save(c);
		}
	
	
	@Override
	public void ajouterEtaffecterCompanytoUser(Company c, String userName) {
		
		User user= userRepo.findById(userName).orElse(null);
		c.setUser(user);
		companyRepo.save(c); 
		System.out.println("my user  "+ user.getUserName());
	}
	
	
	

	@Override
	public void deleteCompany(Long idCompany) {
		companyRepo.deleteById(idCompany);
		
	}

	@Override
	public Company updateCompany(Company c) {
		return companyRepo.save(c);
	}
	
	
	
	@Override
	public Company getCompanyById(Long idCompany) {

		return companyRepo.findById(idCompany).orElse(null);
	}
	
	
	@Override
	public Company updateCompanyById(Company o,Long idCompany) {
	
		Company opp= companyRepo.findById(idCompany).orElse(null);
		opp.setDescription(o.getDescription());
		opp.setName(o.getName());
		opp.setAdresse(o.getAdresse());
		opp.setAgentName(o.getAgentName());
		opp.setCodeCoupon(o.getCodeCoupon());
		opp.setCountry(o.getCountry());
		opp.setEmailC(o.getEmailC());
		opp.setImage(o.getImage());
		opp.setPhone(o.getPhone());
		opp.setWebsite(o.getWebsite());
		companyRepo.save(opp); 
	return opp;
	}

}
