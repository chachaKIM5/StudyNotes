package com.test.java.obj.access;

public class Ex33_Access {

	public static void main(String[] args) {
		
		//Ex33_Access.java
		
		//접근 지정자(제어자), Access Modifier
		//- 클래스 멤버에 붙여서 사용한다.
		//- 클래스 자체에도 붙여서 사용한다.
		//- 지역변수에는 사용 불가능
		//- 클래스(객체)의 영역을 기준으로 외부에 해당 멤버를 노출하는 수위를 결정
		//- 멤버를 외부에 공개할지 여부를 조절하는 역할
		
		//1. public > 100% 공개
		//2. private > 100% 비공개
		//--------------- ▲ 22/03/23 수업 / ▼ 추후 수업
		//3. protected
		//4. default
		
		
		
		Book b1 = new Book();
		b1.title = "자바의 정석"; //> public
		//b1.author = "남궁"; > error > private
		
		
		
		//"아무개"가 객체 생성
//		Phone p1 = new Phone();
//		p1.model = "S22";
//		p1.color = "white";
//		p1.price = 1200000;
//		p1.weight = 350;
//		
//		System.out.println(p1.model);
//		System.out.println(p1.color);
//		System.out.println(p1.price);
//		System.out.println(p1.weight);
//		
//		
//		
//		//"홍길동"이 객체 생성
//		Phone p2 = new Phone();
//		p2.model = "A10";
//		p2.color = "yellow";
//		p2.price = 1000000000;
//		p2.weight = 1000000000;
//		
//		System.out.println(p2.model);
//		System.out.println(p2.color);
//		System.out.println(p2.price);
//		System.out.println(p2.weight);
		
		
		Phone p3 = new Phone();
		
		p3.aaa("S22");
		System.out.println(p3.bbb());
		p3.ccc(1000000000);
		System.out.println(p3.ddd());
		
		
		
		System.out.println();
		System.out.println();

		
		SmartPhone s1 = new SmartPhone(); //오브젝트 생성
		
		s1.setModel("S22");
		s1.setColor("white");
		s1.setPrice(1200000);
		s1.setWeight(300); //g로 입력하고
		
		
		System.out.println(s1.getModel());
		System.out.println(s1.getColor());
		System.out.println(s1.getPrice());
		System.out.println(s1.getWeight()); //kg로 환산해서 출력하고 싶다면? Getter에서 가공
		
		
		
		//결론
		//클래스 설계시 접근 지정자 가이드
		//1. 멤버 변수 > private
		//2. 필요한 Getter/Setter > public
		//3. 불필요한 내부 멤버 메소드 > private
		//4. 외부 호출 멤버 메소드 > public
		
		//잘 모르겠으면?
		//무조건 private (변수, 메소드 다)
		//Getter, Setter만 public
		//필요한데 안 보이는 멤버가 발생 -> 하나씩 public으로 교체
		
		
		System.out.println();
		System.out.println();

		
		Cup cup = new Cup();
		
		cup.setColor("brown"); //쓰기, 읽기 프로퍼티
		System.out.println(cup.getColor());
		
		cup.setWeight(500); //쓰기만 > 쓰기 전용 프로퍼티
		//System.out.println(cup.getWeight()); //읽기 X > Getter X
		
		//cup.setPrice(2000); //읽기만 > 읽기 전용 프로퍼티
		System.out.println(cup.getPrice());
		
		
		
		//계산된 프로퍼티
		//private String info;가 없지만 price에서 가져온 값으로 가공한 것
		System.out.println(cup.getInfo());
		
		// >> Getter, Setter의 역할
		//1. 멤버 보호 (멤버 변수에 유효하지 않은 값이 들어가는 것을 방지)
		//2. 쓰기 전용, 읽기 전용 가능
		//3. 계산된 멤버 생성 가능
		
		
		
		
		//TODO 모두 이해한 다음, 공부하고
		//객체지향에 관련된 책 찾아보기 - 토끼책
		
	} //main
} //Ex33



//정보 은닉화
//인터페이스
//캡슐화

//객체 > 내부에 여러가지 멤버 소유

//케이스(캡슐)로 감싸는 이유?
//- 외부로부터 내부 요소를 보호하기 위해서
//- 객체의 사용법을 단순화하기 위해서

class Book {
	
	public String title;	//도서명
	private String author; 	//저자
	
}


class Phone {
	
	//무조건 멤버 변수는 private를 지정한다.
	private String model;
	private String color;
	private int price;
	private int weight;
	
	//2. public 메소드를 생성한다. > 대리자 > 인터페이스 > 리모콘의 버튼들
	//						   > 객체의 사용법
	public void aaa(String a) {
		model = a;
	}
	
	public String bbb() {
		return model;
	}
	
	public void ccc(int c) {
		if (c >= 0 & c <= 1500000) {
			price = c;
		} else {
			System.out.println("에러");
		}
	}
	
	public int ddd() {
		return price;
	}
}



class SmartPhone {
	
	//1. 멤버 변수: 무조건 private로
	private String model;
	private String color;
	private int price;
	private int weight;
	
	
	//2. 인터페이스 역할을 할, 개방된 메소드 만들기

	//메소드 이름은 보통
	//set + 멤버변수명
	//Setter, 쓰기 메소드라고 부름
	public void setModel(String model) {
		//model = model; //매개변수(우선)와 멤버변수 이름이 같다!

		this.model = model;
		//this.멤버변수 = 매개변수(지역변수)
		//- this: 객체 접근 연산자
	}
	
	//get + 멤버변수명
	//Getter, 읽기 메소드
	public String getModel() {
		return this.model;
		//Getter에서는 this.붙여도 안 붙여도 충돌 X
		//가독성 때문에 붙이는 경우가 많다
		
	}
	
	
	public void setColor(String color) {
		if (color.equals("black")
				|| color.equals("white")
				|| color.equals("red")
				|| color.equals("yellow")
				|| color.equals("blue")) {
			this.color = color;
		} else {
			System.out.println("존재하지 않는 색상입니다.");
		}
	}
	
	public String getColor() {
		return this.color;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public void setWeight(int weight) {
		if (weight > 0) {
			this.weight = weight;
		}
	}
	
	public double getWeight() {
		return calWeight(this.weight);
	}
	
	//*** 이 메소드의 성격?
	// - Getter가 아님
	// - 내부 업무에 필요한 작업을 분리시키기 위해서 만듦
	// - Getter에서 코드가 길어질 경우 가독성을 높이기 위해 만듦

	//public double calWeight(int weight) {
	//	-> public으로 만들면 혼동 초래!
	
	private double calWeight(int weight) {	
		return weight / 1000.0;
	}
	
	
}


//***** 모든 상황에서 범위가 큰 요소와 범위가 작은 요소끼리 충돌이 발생
//		>> 무조건(100%) 범위가 작은 요소가 우선한다.
		   


//캡슐화 == 블랙 박스화
class Cup {

	private String color;
	private int weight;
	private int price = 1000;
	private String type;
	
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getPrice() {
		return price;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	
	public String getInfo() {
		
		if (this.price < 500) {
			return "저렴한 컵";
		} else if (this.price < 1000) {
			return "보통 컵";
		} else {
			return "비싼 컵";
		}
	}
	
}




