package com.test.java;

public class Item42 {

	public static void main(String[] args) {
		
		//[SUMMARY] 클래스 (2022. 3. 23. 오후 7:37:57)
		
		SmartPhone s1 = new SmartPhone();
		s1.setModel("Galaxy S22");
		System.out.printf("핸드폰의 모델은 %s입니다.", s1.getModel());
		
	}
}

class SmartPhone {

	//멤버 변수는 무조건 private로 생성
	private String model;
	private String color;
	private int price;
	private int weight;

	
	//인터페이스 역할 = 개방된 메소드(Getter, Setter)
	//Setter
	public void setModel(String model) {
		
		//this.멤버변수 = 매개변수(지역변수)
		this.model = model;
	}


	//Getter
	public String getModel() {

		//this 유무 상관 X, 가독성 위해 붙인다
		return this.model;
	}


	
	public double calWeight(int weight) {     //Getter의 코드가 길어지면 가독성을 위해 분리시키기도 한다
		return weight / 1000.0;

	}
}