package com.test.java.obj.inheritance;

import java.util.Calendar;
import java.util.Date;

public class Ex44_ToString {

	public static void main(String[] args) {
		
		//Ex44_ToString.java
		
		
		Time t1 = new Time(2, 30);
		Time t2 = new Time(5, 10);
		
		System.out.println(t1.getHour()); //각각의 멤버 변수의 Getter 호출
		System.out.println(t1.getMin());
		
		System.out.println(t1.info());
		System.out.println(t2.info()); //객체의 상태를 한 줄로 확인 가능!
		
		
		
		Date now = new Date();
		
		Calendar now2 = Calendar.getInstance();
		
		System.out.println(now);	//객체의 내부 데이터 출력
		System.out.println(now2);	//객체의 내부 데이터 출력
		
		System.out.println(t1); 	//com.test.java.obj.inheritance.Time@2aafb23c -> ???
		System.out.println(t2); 	//com.test.java.obj.inheritance.Time@2b80d80f -> ???
		System.out.println();
		
		//com.test.java.obj.inheritance.Time : 객체의 자료형(패키지.클래스)
		//@ : 구분자
		//2aafb23c : 숫자(16진수) > 메모리 주소값 > 해시코드(HashCode)

		
		
		//객체의 출력 = 객체의 toString() 반환값을 출력, 자동으로 toString 호출
		System.out.println(now);
		System.out.println(now.toString());
		
		System.out.println(t1);
		System.out.println(t1.toString()); //Object.toString()을 상속
		//t1.toStrign() : String - Object
		//now.toString : String - Date (오버라이드)
		
		//Object.toString()
		//- 자식 클래스에서 그대로 사용하지 않는다. > 쓸모 없음
		//- 반드시 메소드 오버라이드(재정의)를 해서 사용한다
		//- 모든 객체는 toString() 소유
		//- 주로 자신이 소유한 데이터(멤버 변수)의 값을 문자열로 돌려주는 코드(=덤프, dump)
		
	} //main
} //Ex44



class PPP {
	public void test() {	
	}
	
}


class QQQ extends PPP {
	public void aaa() {
		
	}
	
	@Override
	public void test() {
		super.test();
	}
	
}


//클래스 = 멤버변수 + 생성자 + Getter/Setter + toString() 재정의
class Time {
	
	private int hour;
	private int min;
	
	public Time(int hour, int min) {
		this.hour = hour;
		this.min = min;		
	}

	
	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}
	
	//객체의 상태를 확인하기 쉽도록 만드는 메소드 (for 개발자)
	public String info() {
		return this.hour + ":" + this.min;
	}


	@Override
	public String toString() {
		return "Time [hour=" + hour + ", min=" + min + "]";
	}
	
//	@Override
//	public String toString() {
//		
//		//toString 오버라이딩의 최소한의 권유 사항 : 객체의 데이터를 알아볼 수 있게 문자열로...
//		
	
//		return this.hour + ":" + this.min;
//	}
	
	
	
}