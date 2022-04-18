package com.project.dentist.dataClass;
/**
 * 환자 정보 클래스입니다.
 * @author 고수경
 */
public class Patient {
   
   
   private String seq;
   private String id;
   private String password;
   private String name;
   private String gender;
   private String birthday;
   private String address;
   private String phoneNum;
   
   /**
    * Patient 객체가 만들어지면 Patient 멤버 변수들을 초기화하는 생성자입니다.
    * @param seq
    * @param id
    * @param password
    * @param name
    * @param gender
    * @param birthday
    * @param address
    * @param phoneNum
    */
   public Patient(String seq, String id, String password, String name, String gender, String birthday,
			String address, String phoneNum) {
		this.seq = seq;
		this.id = id;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
		this.phoneNum = phoneNum;
	}
   
   public String getSeq() {
      return seq;
   }
   public void setSeq(String seq) {
      this.seq = seq;
   }
   public String getId() {
      return id;
   }
   public void setId(String id) {
      this.id = id;
   }
   public String getPassword() {
      return password;
   }
   public void setPassword(String password) {
      this.password = password;
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
   public String getBirthday() {
      return birthday;
   }
   public void setBirthday(String birthday) {
      this.birthday = birthday;
   }
 
   public String getAddress() {
      return address;
   }
   public void setAddress(String address) {
      this.address = address;
   }
   
   public String getPhoneNum() {
	return phoneNum;
   }

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

@Override
   public String toString() {
      return String.format(
            "Patient [seq=%s, id=%s, password=%s, name=%s, gender=%s, birthday=%s, address=%s, phoneNum=%s]",
            seq, id, password, name, gender, birthday, address, phoneNum);
   }

   
   
   
   

}