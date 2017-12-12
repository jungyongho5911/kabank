package com.kabank.web.bean;

public class MemberBean {
	private int customNum,age;
	private String name,gender,ssn,id,pass;
	public int getCustomNum() {
		return customNum;
	}
	public void setCustomNum(int customNum) {
		this.customNum = customNum;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "회원 [고객번호=" + customNum + ", 나이=" + age + ","
				+ " 이름=" + name + ", 성별=" + gender
				+ ", 주민번호=" + ssn + ", 아이디=" + id + ","
				+ " 비밀번호=" + pass + "]\n";
	}
	
	
	
	
}
