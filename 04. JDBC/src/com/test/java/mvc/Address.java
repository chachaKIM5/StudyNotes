package com.test.java.mvc;

public class Address {

	//DTO, VO
	// - 멤버 변수와 Getter/Setter 두 가지만 구현하면 ok, 보통 생성자는 없어도 됨
	// - 디버깅용 toString 만드는 경우도 있다
	private String seq;
	private String name;
	private String age;
	private String gender;
	private String tel;
	private String address;
	private String regdate;
	
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	
	
	
}
