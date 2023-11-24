package com.inc.excelexport.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Emp_List")
public class Emp {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int emp_Id;
	private String email_Id;
	private String mobile_No;
	private String department;
	private String role;
	private String org_Name;
	private String emp_Type;
	private String b_Place;
	private String address;

}
