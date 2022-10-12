package com.youtube.jwt.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
public class Coupon {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long idCoupon;
	private String code;
	private String productName;
	private Date dateD;
	private Date dateF;
	
	@JsonIgnore
	@ManyToOne
    private Company company;
}
