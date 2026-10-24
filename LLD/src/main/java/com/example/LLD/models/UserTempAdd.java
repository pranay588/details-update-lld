package com.example.LLD.models;

import com.example.LLD.models.UserPermAdd.UserPermAddBuiler;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user_temp_add",schema="usrone")
public class UserTempAdd {

	@Id
	@Column(name="id")
	String id;
	@Column(name="add_line_one")
	String addLineOne;
	@Column(name="add_line_two")
	String addLineTwo;
	@Column(name="add_line_three")
	String addLineThree;
	
	public UserTempAdd(UserTempAddBuilder builder){
		this.id = builder.id;
		this.addLineOne = builder.addLineOne;
		this.addLineTwo = builder.addLineTwo;
		this.addLineThree = builder.addLineThree;
	}
	public UserTempAdd() {}
	public static class UserTempAddBuilder{
		String id;
		String addLineOne;
		String addLineTwo;
		String addLineThree;
		
		public UserTempAddBuilder setId(String id) {
			this.id = id;
			return this;
		}
		
		public UserTempAddBuilder setAddLineOne(String addLineOne) {
			this.addLineOne = addLineOne;
			return this;
		}
		public UserTempAddBuilder setAddLineTwo(String addLineTwo) {
			this.addLineTwo = addLineTwo;
			return this;
		}
		public UserTempAddBuilder setAddLineThree(String addLineThree) {
			this.addLineThree = addLineThree;
			return this;
		}
		
		public UserTempAdd build() {
			return new UserTempAdd(this);
		}
	} 
	
}
