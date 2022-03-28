package com.test.java;

public class Item47 {

	public static void main(String[] args) {
		
		//[SUMMARY] Object 클래스, toString (2022. 3. 28. 오후 11:07:15)
		
		/*
		 
		 Object 클래스는 모든 클래스의 근원(Root)이 되는 클래스,
		 사용자가 만드는 모든 클래스는 자동으로 Object 클래스를 상속받는다.
		  
		 대표적인 Object 클래스의 메소드: Object.toString() 
		  - 모든 객체는 toString 메소드를 상속한다.
		  - 재정의해서 사용한다.
		  
		 */
		
		Time t1 = new Time(2, 30);
		
		//이때, 객체를 직접 출력 = 자동으로 toString을 호출한다!
		System.out.println(t1);                 //Time [hour=2, min=30]
		System.out.println(t1.toString());      //Time [hour=2, min=30]
		
	}
}

class Time {
	
	private int hour;
	private int min;
	
	public Time(int hour, int min) {
		this.hour = hour;
		this.min = min;		
	}

@Override
	public String toString() {
		return "Time [hour=" + hour + ", min=" + min + "]";
	}
}