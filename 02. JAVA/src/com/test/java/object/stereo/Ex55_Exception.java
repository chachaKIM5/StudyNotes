package com.test.java.obj.stereo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ex55_Exception {

	public static void main(String[] args) {
		
		//Ex55_Exception.java
		
		/*
		
		 예외, Exception
		 - 컴파일 발견 X > 실행 중 발견 O
		 - 런타임 오류
		 - 개발자 미리 예측 O, X
		 
		 
		 예외 처리, Exception Handling
		 1. 전통적인 방식
		 	- 제어문 사용 (조건문)
		 
		 2. 전용 처리 방식(권장)
			- try catch (finally)문 사용
		  
		  
		  
		 if문 vs try문
		 - if문: 사전에 미리 검사해서 사고가 안 나도록 처리
		 - try문: 일단 실행하고 감시, 사고가 터지면 그때 처리
		 - 참고) '감시'해야 하므로 try가 감싸는 범위가 넓어질수록 프로그램이 무거워진다!
		        *** try의 영역을 필요한 만큼 최소화해야 한다 ***
		       		예외가 발생할 것 같다고 예측 가능한 영역에만.
		 */
		
		
		//왜 자동 생성된 메소드는 이렇게 만들어질까?
		//private => 안정성
		//static
		//void  => 호출부에서 결정됨
		//()	=> 호출부에서 결정됨
		
		//m1의 'static' 지우고 this.m1();로 호출? 그래도 에러
		// > main 메소드가 static이기 때문에, 공용 static 영역에서 non-static 메소드 호출 X
		// > 꼭 static 키워드를 뺀 m1을 사용하고 싶다?
		// > Ex55_Exception ex = new Ex55_Exception(); 객체 생성 후 ex.m1(); 호출
		
		
		
		//Ex55_Exception.m1(); //FM
		//m1();
		//m2();
		//m3();
		try {
			m4();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			m5();
		} catch (Exception e) {
			System.out.println("본사에서 처리");
		}
		
		
	} //main
	

	private static void m5() {

		//예외 던지기
		
		//요구사항] 숫자 입력 > 처리 > 조건: 반드시 짝수만 입력
		// 		  홀수 입력 시 에러 처리
		
		int num = 5;
		
		if (num % 2 == 0) {
			System.out.println("업무 코드 진행");
		} else {
			System.out.println("예외 처리1");
		}
		
	
		
		//이 예제에 try-catch 구문 적용하기: 강제로 에러를 낸다
		try {
			if (num % 2 == 1) {
				throw new Exception("홀수를 입력했습니다!");
				//예외 객체를 만들어서 던진다 -> 강제로 에러를 발생시킨다
				//생성자 오버로딩으로 '에러 메시지' 입력, catch절에서 getMessage()로 출력
			}
			
			System.out.println("업무 코드 진행");	
		} catch (Exception e) {
			System.out.println("예외 처리2");
			System.out.println(e.getMessage());
			
		}
		
	}


	private static void m4() throws Exception {

		//예외 미루기
		// - 에러를 방치
		// - 해당 영역에서 예외 처리를 할 만한 상황이 되지 않으면 다른 곳으로 예외 처리의 책임을 떠넘길 수 있다
		// - throws Exception
		// - 메소드에서 throws Exception 할 경우, 메인 메소드에서라도 try-catch 구문 써야 함
		// - 메인 메소드를 try-catch로 감싸서 한꺼번에 에러를 해결하는 방식에 적합
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		//Unhandled exception type IOException
		
		String input = reader.readLine();
	}


	private static void m3() {  //다중 catch문
		
		//내용물 = m2()와 같지만
		//다중catch문!
		
		try {
			
			int num = 10;
			System.out.println(100 / num); 	//A 상황. ArithmeticException
			
			//에러가 나는 순간? 자동으로
			//throw new ArithmeticException 실행
			
			int[] nums = { 10, 20, 30 };
			System.out.println(nums[0]); 	//B 상황. ArrayIndexOutOfBoundsException
			
			
			Parent p = new Parent();
			Child c;
			//c = (Child)p; 					//C 상황. ClassCastException
			
			
			Parent p2 = null;
			System.out.println(p2.toString()); //NullReferenceException
			
		} catch (ArithmeticException e) {
			System.out.println("0으로 나누기");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 첨자 오류");
		} catch (ClassCastException e) {
			System.out.println("형변환 오류");			
		} catch (Exception e) {
			//Exception > 모든 OOOException의 부모 클래스
			// > 내가 예측한 것 외에 모든 오류, '기타 등등'을 처리
			// > 모든 오류를 처리하므로 무조건 맨 끝에 둘 것
			System.out.println("예외 처리");
			e.printStackTrace();
		}
		
		
		
		
		
//		catch (Exception e) {
//			
//			System.out.println("예외 처리");
//			System.out.println(e.getMessage());
//			
//		}
	}


	private static void m2() {  

		//Exception 객체의 역할
		
		int num = 0;
		
		try {
			System.out.println(100 / num); 	//A 상황
		} catch(Exception e) {
			System.out.println("0으로 나눌 수 없습니다.");
		}
		
		int[] nums = { 10, 20, 30 };
		
		try {
			System.out.println(nums[5]); 	//B 상황
		} catch (Exception e) {
			System.out.println("배열 첨자 오류");
		}
		
		
		Parent p = new Parent();
		Child c;
		
		try {
			c = (Child)p; 					//C 상황
		} catch (Exception e) {
			System.out.println("형변환 오류");
		}
		
		
		//잦은 try-catch문은 코드 가독성을 떨어뜨린다
	}


	
	

	
	
	private static void m1() {
		
		//요구사항] 숫자를 입력받아 연산을 하시오.
				
		System.out.print("숫자: ");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt(); //버퍼드리더 쓰면? Integer.parseInt(reader.readLine());
		
		
		//입력할 수 있는 약 42억 개 숫자 중 유일한 오류값: 0
		
		//전통적인 방식의 예외 처리 ▼
		
		//권장
		if (num != 0) {
			//비즈니스 코드(=업무 코드) > 주 목적!
			System.out.printf("100 / %d = %d\n", num, 100 / num);
		
		} else {
			//예외 처리 코드
			System.out.println("0을 입력할 수 없습니다.");
		}
		
		
		//비권장
		//if (조건)에 예외 처리가 오면 > 가독성 낮음! 비즈니스 코드 넣을 것
		if (num == 0) {
			System.out.println("0을 입력할 수 없습니다.");
			
		} else {
			System.out.printf("100 / %d = %d\n", num, 100 / num);
		}
		
		
		
		//전용 처리 방식: try문
		// - try문: 비즈니스 코드 작성 (꼭!)
		// - catch: 예외 처리 코드 작성 (꼭!)
		
		//조건이 없다!!
		
		//작동 과정
		//1. try를 만나면 무조건 try 안에 있는 코드를 실행
		//	2-1. 아무 문제가 없었음
		//		3. 빠져나감 (catch 실행 X)
		//	2-2. 에러 발생?
		//		3. 남아있는 try 업무코드를 무시하고 실행 중단
		//		4. 즉시 catch로 이동, catch절을 실행하고 빠져나감
		//
		try {
			
			System.out.printf("100 / %d = %d\n", num, 100 / num);
			
		} catch (Exception e) {
			
			System.out.println("0을 입력할 수 없습니다.");
			System.out.println();
			
			//System.out.println(e.getMessage());
			//e.printStackTrace();
			
		}
		
		
		//Exception e
		// - 예외 객체
		// - 예외가 발생한 상황에 대한 정보를 알려 준다
		

		
		
		
		
	} //m1
} //Ex55


class Parent {
	
}

class Child extends Parent {
	
}
