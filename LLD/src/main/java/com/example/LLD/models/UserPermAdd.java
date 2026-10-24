package com.example.LLD.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user_perm_add",schema="usrone")
public class UserPermAdd {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	String id;
	@Column(name="add_line_one")
	String addLineOne;
	@Column(name="add_line_two")
	String addLineTwo;
	@Column(name="add_line_three")
	String addLineThree;
	
	UserPermAdd(){}
	
	UserPermAdd(UserPermAddBuiler builder){
		this.id = builder.id;
		this.addLineOne = builder.addLineOne;
		this.addLineTwo = builder.addLineTwo;
		this.addLineThree = builder.addLineThree;
	}
	
	public static class UserPermAddBuiler{
		String id;
		String addLineOne;
		String addLineTwo;
		String addLineThree;
		
		public UserPermAddBuiler setId(String id) {
			this.id = id;
			return this;
		}
		
		public UserPermAddBuiler setAddLineOne(String addLineOne) {
			this.addLineOne = addLineOne;
			return this;
		}
		public UserPermAddBuiler setAddLineTwo(String addLineTwo) {
			this.addLineTwo = addLineTwo;
			return this;
		}
		public UserPermAddBuiler setAddLineThree(String addLineThree) {
			this.addLineThree = addLineThree;
			return this;
		}
		
		public UserPermAdd build() {
			return new UserPermAdd(this);
		}
	} 
	
}
