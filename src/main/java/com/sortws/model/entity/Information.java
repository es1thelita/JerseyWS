package com.sortws.model.entity;

import java.io.Serializable;

public class Information implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9118011845016194255L;
	
	private String name;
	private String numberList;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNumberList() {
		return numberList;
	}
	
	public void setNumberList(String numberList) {
		this.numberList = numberList;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Name : " + this.name + '\n');
        sb.append("NumberList : " + this.numberList + '\n');
        return sb.toString();
	}
}
