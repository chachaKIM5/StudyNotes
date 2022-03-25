package com.test.java.obj.constructor;

public class Ex37_Constructor {

	public static void main(String[] args) {
		
		//Ex37_Constructor.java
		
		
		//모든 마우스를 일괄적으로 초기화 > model(M705), price(40000)
		Mouse m1 = new Mouse();
		Mouse m2 = new Mouse();
		Mouse m3 = new Mouse();
		
		//QC를 거쳐 discount > 35000
		m2.setPrice(35000);
		m3.setPrice(35000);
		
		
		//m2, m3는 40000원으로 초기화했다가 다시 35000원으로...
		//m4는 생성자 오버로딩을 통해 35000원으로 태어나게 됨, 한 단계 감소
		//> 객체의 초기 상태를 상황에 따라 다르게 하고 싶다면 생성자의 매개변수를 사용하면 된다!
		//> 객체의 다양성, 오버로딩으로 하나의 틀로부터 나왔지만 성질을 조금씩 바꿀 수 있다
		Mouse m4 = new Mouse(35000); // 모델명 기본값 + 가격을 지정
		Mouse m5 = new Mouse("M100");// 모델명 지정 + 가격은 기본값
		Mouse m6 = new Mouse("B123", 30000); //모델명 지정 + 가격 지정
		
		System.out.println("모델명: " + m1.getModel() + ", 가격: " + m1.getPrice());
		System.out.println("모델명: " + m2.getModel() + ", 가격: " + m2.getPrice());
		System.out.println("모델명: " + m3.getModel() + ", 가격: " + m3.getPrice());
		System.out.println("모델명: " + m4.getModel() + ", 가격: " + m4.getPrice());
		System.out.println("모델명: " + m5.getModel() + ", 가격: " + m5.getPrice());
		System.out.println("모델명: " + m6.getModel() + ", 가격: " + m6.getPrice());
		
		
		
	}//main
}//class main



class Mouse {
	
	private String model;
	private int price;
	
	public Mouse() {			//생성자
		this.model = "M705";
		this.price = 40000;
	}
	
	public Mouse(int price) { 	//생성자 오버로딩
		this.model = "M705";
		this.price = price;
	}
	
	public Mouse(String model) {
		this.model = model;
		this.price = 40000;
	}
	
	public Mouse(String model, int price) {
		this.model = model;
		this.price = price;
	}
	
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
} //class Mouse
