package com.test.java.obj.constructor;

public class Ex36_Constructor {

	public static void main(String[] args) {
		
	//Ex36_Constructor.java
		
	/*
	 
	  생성자, Constructor
	  - (특수한 목적을 가지는) 메소드
	  - 객체 멤버(변수)를 초기화하는 역할을 가지는 메소드
	  - 일반 메소드처럼 마음대로 호출이 불가능하다	> 객체가 생성될 때 딱 1번만 호출된다
	  									  	> 그 이후로는 호출 불가능
	  									  	> 1회용 메소드
	  - 클래스 이름과 동일한 이름을 가진다
	  - //선생님 설명: 우리가 찍어낼 객체의 초기값을 설정하기 위한 용도로 생성한 메소드
	  
	  new, 객체 생성 연산자
	  
	   (3)  (4) (1)(2)  (5)
	  Cup c1 = new Cup();
	  
	  (1) 객체 생성 연산자 new 실행 : 메모리 heap 어딘가에 color, owner라는 (멤버)변수가 함께 들어있는 인스턴스가 만들어진다
	  							  이때 멤버 변수의 값은 null, 비어 있다
	  (2) 생성자 Cup() 실행: 초기값을 세팅한다 (color에 "white", owner에 "미정"..)
	  
	 */
		
		
		User u1 = new User();
		
		System.out.println(u1.getName());
		System.out.println(u1.getAge());
		System.out.println(u1.isFlag());
		
		
		Cup c1 = new Cup();
		
		//생성자와는 다른 Setter 역할 > 객체 정보 수정
		c1.setColor("yellow");
		c1.setOwner("홍길동");
		
		
		
		Cup c2 = new Cup();
		
		//컵의 기본값을 컬러 흰색, 주인 미정으로 하고 싶다면?
		//생성자를 설정할 수 없었다면 c1.setColor... ~ c2.setOwner 각 컵마다 하나씩 설정해 줘야 함 
		//반복업무는 실수를 유발하기 때문에 위험하다! 생성자 > 안정성을 높인다
		
		
		c1.info();
		c2.info();
		
		
		
		
	}//main
}//class


class Cup {
	
	private String color;
	private String owner;
	
	
	public Cup() {
		this.color = "white";
		this.owner = "미정";
	}
	
	
	public void setColor(String color) {
		this.color = color;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public void info() {
		System.out.printf("색상: %s, 소유주: %s\n", this.color, this.owner);
	}
	
	
}





class User {
	
	private String name;
	private String id;
	private int age;
	private boolean flag;
	//멤버변수를 boolean 타입으로 넣을 때 한해서, Getter 메소드 이름이 isFlag로 생성
	//생성자의 실제 모습!
	
	//기본 생성자
	//1. 메소드명 = 클래스명
	//2. 반환값 명시 X
	//3. return문 가질 수 없다.
	//4. 구현부는 해당 클래스의 멤버를 초기화하는 코드를 작성한다. (*****)
	//5. 없으면 자동으로(=기본 생성자), 적으면 자동 생성 되지 않고 개발자가 적은 게 사용됨 
	//6. 하지만 생성자 수동 생성 후 일부 멤버만 초기화하지 않으면 그 멤버에 한해서는 자동으로 초기화
	// >> 결국, 객체의 멤버 변수는 반드시 초기화된다
	//			cf) 지역 변수는 선언하고 초기화를 안 하면 값이 없는 상태


	public User() {
		
//		this.name = null;
//		this.id = null;
//		this.age = 0;
//		this.flag = false;

		this.name = "익명";
		this.id = "none";
		this.age = -1;
		this.flag = true;
	
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	
}
