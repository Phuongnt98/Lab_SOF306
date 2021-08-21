package com.poly.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	
	private String email;
	private String fullname;
	private Double marks;
	private Boolean gender;
	private String country;
	
	@Override
	public String toString() {
		return "Student [email=" + email + ", fullname=" + fullname + ", marks=" + marks + ", gender=" + gender
				+ ", country=" + country + "]";
	}
	
}