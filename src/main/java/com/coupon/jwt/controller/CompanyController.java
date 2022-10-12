package com.youtube.jwt.controller;


import java.util.List;

import javax.annotation.PostConstruct;

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

import com.youtube.jwt.entity.Company;
import com.youtube.jwt.service.CompanyService;
import com.youtube.jwt.service.UserService;



@RestController
public class CompanyController {
	 @Autowired
	    private CompanyService companyServ;
	 @Autowired
	    private UserService userService;
	 
	 
	 @PostConstruct
	    public void initRoleAndUser() {
	        userService.initRoleAndUser();
	   } 
	 
	 @GetMapping("/retrieve-all-companies") 
	
	 @ResponseBody 
	
		public List<Company> getCompanies() { 
			return companyServ.retrieveAllcompanies();
		  
		}
	
	 @PostMapping("/add-company")
	  @PreAuthorize("hasRole('Admin')")
		@ResponseBody
		public Company Addcompany(@RequestBody Company t)
		{
		 return  companyServ.addCompany( t);
		
		  
	     }
	 
	 
	 @PostMapping("/assigncompanyUser/{userName}")
	  @PreAuthorize("hasRole('User')")
		@ResponseBody
		public void assigncompanytoUser(@RequestBody Company c , @PathVariable("userName") String userName) {
			companyServ.ajouterEtaffecterCompanytoUser(c, userName);
		}
	 
	 
	 
	 @DeleteMapping("/remove-company/{company-id}")
	 @PreAuthorize("hasRole('Admin')")
		@ResponseBody
		public void removeCompany(@PathVariable("company-id") Long idCompany) {
		 companyServ.deleteCompany(idCompany);	}
		
		
		
		
			@PutMapping("/modify-company")
			@PreAuthorize("hasRole('Admin')")
			@ResponseBody
			public Company ModifyCompany(@RequestBody Company c)
			{
				return companyServ.updateCompany(c);
			}
			
			@GetMapping("/retrieve-company/{company-id}")
			@PreAuthorize("hasRole('Admin')")
			@ResponseBody
			public Company retrieveCompanyById(@PathVariable("company-id") Long idCompany) {
			return companyServ.getCompanyById(idCompany);
			}		
			
			
			@PutMapping("/modify-company-byID/{company-id}")
			@PreAuthorize("hasRole('Admin')")
			@ResponseBody
			public Company ModifyOpportunityById(@PathVariable("company-id") Long idCompany,@RequestBody Company o) {
			return companyServ.updateCompanyById(o, idCompany); 
			}
			
			
}
