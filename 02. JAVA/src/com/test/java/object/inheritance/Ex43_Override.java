package com.test.java.obj.inheritance;

public class Ex43_Override {

	public static void main(String[] args) {
		
		//Ex43_Override.java
		
		/*
		 
		 
		 메소드 오버로딩, Method Overloading
		 - 메소드 이름 동일 x N 생성 > 인자 리스트
		 
		 메소드 오버라이드, Method Override
		 - 클래스 상속 시에 발생
		 - 메소드 재정의
		 
		 포인트
		 1. 자식 클래스가 상속받은 부모의 메소드를 그대로 사용하고 싶지 않을 때
		 	- 상속은 거부할 수 없다. 무조건 100% 진행
		 2. 상속 관계에 있는 클래스의 객체들은 대부분 공통된 사용법을 가지고 있다고 생각한다.
		 	- 스스로 다른 형식의 메소드 생성 > 규칙 파괴!
		 3. 겉으로 보기엔 부모와 동일한 메소드지만, 내용물이 바뀐 메소드를 만들어낸다.
		  
		  
		 면접 질문
		 - 메소드 오버로딩 vs 메소드 오버라이딩?
		  
		  
		 */
		
		
		//** 상속 관계에 있는 클래스 > 같은 목적을 가지는 메소드 구현 > 반드시(***) 메소드 시그너처를 동일하게 만드는 게 좋다!
		//인사하는 메소드: 아빠가 hello, 아들은 hi? (X) 아들도 hello
		
		
		OverrideParent p1 = new OverrideParent();
		p1.name = "홍길동";
		p1.hello();
		
		
		OverrideChild c1 = new OverrideChild();
		c1.name = "홍아들";
		//c1.hi();
		c1.hello(); //부모와 자식의 hello 중에 선택할 수도 있나? > X, 무조건 자식의 hello()가 호출된다 (선택 불가능)
		
		//외부에서 보면, 부모의 hello()와 자식의 hello()는 구분할 수 없다
		//결론 > 무조건 자식의 hello()가 호출된다. (선택 불가능!)
		//외부에서 보면 같은 메소드의 행동이 바뀐 것처럼 보인다 -> 메소드 재정의, 메소드 오버라이딩
		//오버라이드의 목적: 시대에 맞게 내용을 업그레이드 + 사용법은 유지
		
		
		
	}
}


class OverrideParent {
	
	public String name;
	public void hello() {
		System.out.printf("안녕하세요, 좋은 아침입니다. 저는 %s입니다.\n"
								,this.name);
	}
}


class OverrideChild extends OverrideParent {
	//시간이 흘러.. > 홍아들 중2학년, 자기 방식대로 인사를 하고 싶어진 홍아들
	//부모로부터 물려받은 메소드는 버려두고(안 쓰고) 자신만의 메소드를 선언(hi)
	
//	public void hi()  {
//		System.out.printf("하이~ 난 %s야\n", this.name);
//	}
	
	
	//메소드 오버라이드 > 메소드 재정의
	//- 부모로부터 물려받은 메소드와 동일한 메소드를 자식 클래스에서 다시 선언하는 행동
	//- 부모 메소드와 자식 메소드가 동일하게 2개 존재하게 된다.
	
//	@Override //주석의 일종(프로그래밍 기능 O: 아래가 Override한 메소드인지 체크해주는 기능) > Annotation
//	public void hello()  {
//		System.out.printf("하이~ 난 %s야\n", this.name);
//	}
	
	@Override
	public void hello() {
		System.out.println("자기만의 스타일 구현.");
	}
	
}
