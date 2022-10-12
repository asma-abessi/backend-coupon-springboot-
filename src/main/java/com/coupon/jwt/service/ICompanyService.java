package com.youtube.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youtube.jwt.Repository.CompanyRepository;
import com.youtube.jwt.entity.Company;


public interface ICompanyService {

	
    public List<Company> retrieveAllcompanies();
	
    Company addCompany(Company t);

	void deleteCompany(Long idCompany);

	Company updateCompany(Company t);

	void ajouterEtaffecterCompanytoUser(Company c, String userName);

	Company getCompanyById(Long idCompany);

	Company updateCompanyById(Company o, Long idCompany);

}
