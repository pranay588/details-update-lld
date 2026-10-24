package com.example.LLD.models;

import com.example.LLD.models.UserTempAdd.UserTempAddBuilder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user_prof_dtls",schema="usrone")
public class UserProfDtls {
	@Id
	@Column(name="id")
	String id;
	@Column(name="occupation")
	String occupation;
	@Column(name="salary")
	Integer salary;
	
	
	public UserProfDtls(UserProfDtlsBuilder builder){
		this.id = builder.id;
		this.occupation = builder.occupation;
		this.salary = builder.salary;

	}
	public UserProfDtls(){}
	public static class UserProfDtlsBuilder{
		String id;
		String occupation;
		Integer salary;
		
		public UserProfDtlsBuilder setId(String id) {
			this.id = id;
			return this;
		}
		public UserProfDtlsBuilder setOccupation(String occupation) {
			this.occupation = occupation;
			return this;
		}
		public UserProfDtlsBuilder setSalary(String salary) {
			this.salary = 0;
			if(salary != "")
				this.salary = Integer.parseInt(salary);
			return this;
		}
		public UserProfDtls build() {
			return new UserProfDtls(this);
		}
	} 
}
