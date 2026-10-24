package com.example.LLD.models;

import com.example.LLD.models.UserProfDtls.UserProfDtlsBuilder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user_prsnl_dtls",schema="usrone")
public class UserPrsnlDtls {
	@Id
	@Column(name="id")
	String id;
	@Column(name="name")
	String name;
	@Column(name="age")
	Integer age;
	public UserPrsnlDtls(UserPrsnlDtlsBuilder builder){
		this.id = builder.id;
		this.name = builder.name;
		this.age = builder.age;

	}
	public UserPrsnlDtls() {}
	public static class UserPrsnlDtlsBuilder{
		String id;
		String name;
		Integer age;
		public UserPrsnlDtlsBuilder setId(String id) {
			this.id = id;
			return this;
		}
		public UserPrsnlDtlsBuilder setName(String name) {
			this.name = name;
			return this;
		}
		public UserPrsnlDtlsBuilder setAge(String age) {
			this.age = 0;
			if(age != "")
				this.age = Integer.parseInt(age);
			return this;
		}
		public UserPrsnlDtls build() {
			return new UserPrsnlDtls(this);
		}
	} 
}
