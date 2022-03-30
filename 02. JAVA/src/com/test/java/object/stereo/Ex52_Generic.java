package com.test.java.obj.stereo;

public class Ex52_Generic {

	public static void main(String[] args) {
		
		//Ex52_Generic.java

		//클래스 종류
			//1. 클래스
			//2. 인터페이스
			//3. 추상 클래스
			//4. enum
			//5. 제네릭 클래스
		
		//제네릭, Generic
		//1. 제네릭 클래스
		//2. 제네릭 메소드
		
		
		//요구사항] 클래스 설계
		//1. 멤버 변수 선언 > int
		//2. 멤버 변수를 중심으로 여러가지 행동을 하는 메소드 선언
		
		//추가사항] String을 중심으로 하는 클래스 추가 설계
		//추가사항2] boolean을 중심으로 하는 클래스를 추가 설계
		//추가사항] double
		//추가사항] byte
		//추가사항] Calendar
		//추가사항] Date
		//추가사항] 무한대로...
		
		
		//위의 문제점 해결 방안
		//1. Object 클래스 	> 오래된 방식 > 개념은 Ex53_Object.java 참고
		//2. 제네릭 클래스 	> 최신 방식 > 개념은 Ex54_Generic.java 참고
		
		
		//예시
		//(1) 전용 클래스
		//(2) Object 클래스(범용)	> 사용할 때 다운캐스팅
		//(3) 제네릭 클래스(범용)	> 바로 사용 가능, 범용+전용 클래스 장점만 취함
		
		//(1)
		WrapperInt n1 = new WrapperInt(10);
		System.out.println(n1.toString());
		System.out.println(n1.getData() * 2);
		System.out.println();
		
		//(2)
		WrapperObject n2 = new WrapperObject(20); //UpCasting, Boxing
		System.out.println(n2.toString());
		System.out.println((int)(n2.getData()) * 2); //DownCasting, UnBoxing
		System.out.println();

		//(3)
		Wrapper<Integer> n3 = new Wrapper<Integer>(30);
		System.out.println(n3.toString());
		System.out.println(n3.getData() * 2);
		System.out.println();

		
		//(1)
		WrapperString s1 = new WrapperString("홍길동");
		System.out.println(s1.toString());
		System.out.println(s1.getData().length());
		System.out.println();

		//(2)
		WrapperObject s2 = new WrapperObject("아무개"); //UpCasting, Boxing
		System.out.println(s2.toString());
		System.out.println(((String)s2.getData()).length()); //괄호 유의, DownCasting, UnBoxing
		System.out.println();
		
		//(3)
		Wrapper<String> s3 = new Wrapper<String>("김승연");
		System.out.println(s3.toString());
		System.out.println(s3.getData().length());
		System.out.println();
		
		
		//(1)
		WrapperBoolean b1 = new WrapperBoolean(true);
		System.out.println(b1.toString());
		System.out.println(b1.getData() ? "참" : "거짓");
		System.out.println();
		
		//(2)
		WrapperObject b2 = new WrapperObject(false); //UpCasting, Boxing
		System.out.println(b2.toString());
		System.out.println((boolean)b2.getData() ? "참" : "거짓"); //DownCasting, UnBoxing
		System.out.println();
		
		//(3)
		Wrapper<Boolean> b3 = new Wrapper<Boolean>(true);
		System.out.println(b3.toString());
		System.out.println(b3.getData() ? "참" : "거짓");
		System.out.println();
		

		
		
	} //main
} //Ex52


class WrapperInt {
	private int data; //클래스의 중심이 되는 데이터!
	
	//생성자
	public WrapperInt(int data) {
		this.data = data;
	}

	
	//Getter, Setter
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	
	//toString
	@Override
	public String toString() {
		return "data=" + data;
	}
}


//추가사항]

class WrapperString {
	private String data;
	
	//생성자
	public WrapperString(String data) {
		this.data = data;
	}
	
	
	//Getter, Setter
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	
	//toString
	@Override
	public String toString() {
		return "data=" + data;
	}
}



class WrapperBoolean {
	
	private boolean data;
	
	public WrapperBoolean(boolean data) {
		this.data = data;
	}
	
	public boolean getData() {
		return data;
	}
	
	public void setData(boolean data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "data=" + data;
	}
}


class WrapperObject {
	
	private Object data;
	
	public WrapperObject(Object data) {
		this.data = data;
	}
	
	public Object getData() {
		return data;
	}
	
	public void setData(Object data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "data=" + data;
	}
}


class Wrapper<T> {
	private T data;
	
	public Wrapper(T data) {
		this.data = data;
	}
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "data=" + data;
	}
	//TODO 제네릭 클래스와 타입 변수 이해하고 복습, 연습해 보기
}