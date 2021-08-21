package com.poly.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Students")
public class Student {
	@Id
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