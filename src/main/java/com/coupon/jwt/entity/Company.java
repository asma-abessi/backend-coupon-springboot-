package com.youtube.jwt.entity;




import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Company {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long idCompany;
	private String name;	
	private String image;
	private String emailC;
	private String adresse;		
	private String codeCoupon;
	private String website ;
	private String description;
	private int phone;
	private String agentName;
	private String country;
 ;
	//= "#" + String.valueOf(idCompany);
		
	@JsonIgnore
	@ManyToOne
    private User user;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="company")
    private Set<Coupon> coupons;
}
