 package com.crud.entity;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Employee {

	@Id
	private int eId;
	private String eName;
	private Long timestampMillis;

	private UUID uId;
	
	public int geteId() {
		return eId;
	}
	public void seteId(int eId) {
		this.eId = eId;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", eName=" + eName + "]";
	}
	public Employee(int eId, String eName) {
		super();
		this.eId = eId;
		this.eName = eName;
	}
	public Long getTimestampMillis() {
		return timestampMillis;
	}
	public void setTimestampMillis(Long timestampMillis) {
		this.timestampMillis = timestampMillis;
	}
	public UUID getuId() {
		return uId;
	}
	public void setuId(UUID uId) {
		this.uId = uId;
	}
	
	
	
}
