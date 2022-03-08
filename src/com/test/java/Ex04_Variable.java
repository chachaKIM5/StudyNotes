package com.test.java;

public class Ex04_Variable {

	public static void main(String[] args) {
		
		//Ex04.Variable.java
		
		//요구사항]
		//- 성적 관리 프로그램
		//- 과목별 점수를 입력, 조작, 출력해야 함
		//- 국어 점수
		
		//1. 국어 점수 > 성질 분석 > 형태(정수) + 길이(0~100)
		//	 성질 분석: 형태를 말함. 숫자인지, 문자인지.. 결국 배웠던 자료형에서 어떤 자료형인지?
		//			  국어점수 소수점까지 관리하려면 실수형을 선택
		//	 길이: 데이터의 최소값과 최대값을 예측해야 미리 길이를 선택 가능함.
		//		  예측 불가능하면 프로그램 못 만듦. 정 안 되면 가상의 범위라도..
		//2. 1의 상황을 고려 > 자료형 중 하나를 선택 > byte형
		//3. 2의 자료형으로 > 변수 생성 ("자료형 변수명;")
		//4. 변수 입출력
	
		//변수 생성하기
		//자료형 변수명;
		
		byte 국어점수;
		
		//변수 초기화(=대입)
		//변수명 = 값;
	
		국어점수 = 100;
		
		//변수 사용하기
		System.out.println(국어점수);
		//공간 출력(X), 공간을 찾아가 그 안의 값을 가져와 출력
		
		
		//**변수 생성하기 - 영어점수, 학생이 두 명이라면?
		//영어점수 > 변수명은 중복될 수 없다. 자료형이 달라도 X!
		byte eng;
		//byte eng; // Duplicate local variable eng
		byte eng1;
		
		//short eng;, char eng; (X)
		
		//수학점수
		byte math;
		
		//The value of the local variable eng1 is not used
		// > 메모리만 차지하고 써먹지 않아서 경고
		
		//**변수명 생성 규칙 > 명명법
		//1. 영문자 사용 + 숫자 사용 + 특수문자(_) > 권장사항
		//2. 숫자로 시작 불가 (byte 3eng;(X) byte _3eng;(O))
		//3. 예약어 사용 불가능, 이미 의미를 가지고 있는 단어 (byte byte; (X))
		//	 (테마 따라 다르지만, 예약어들은 같은 색으로 표시되므로 알 수 있음)
		//4. 의미 있게 (*************) (a, b, c(X) kor, eng, math(O))
		//   byte korscore;, kor_score;, korScore;
		
		//프로그래밍 기술의 발전 방향 > 코드의 재사용!
		
		//math1, math2, math3
		byte math1;
		byte math2;
		byte math3;
		
		byte math4, math5, math6;
		//생산성 높음, 유지보수성 높음. 만점이 100점에서 300점으로 늘어난다면? byte 못 쓰기 때문에
		
		byte math7; //변수 선언
		math7 = 100; //변수 초기화
		
		byte math8 = 100; //변수 선언+초기화
		
		byte math9 = 100, math10 = 90, math11 = 80;
		
		byte math12, math13 = 100, math14;
		
		byte kor1;
		kor1 = 90;
		System.out.println(kor1);
		//kor1 출력 > 90
		
		kor1 = 80; //변수값 수정(=치환, 덮어쓰기)
		System.out.println(kor1);
		//kor1 출력 > 80
		
		//*** 표현식은 동일함(kor1), 값만 바뀜 > "변수"라고 부르는 이유
		//*** 표현식은 동일한데(90) 값이 안 바뀐다 > 상수 > 데이터(값) > 리터럴(Literal)
		
		//데이터 취급
		//1. 변수 > 의미 부여
		//2. 상수
		
		//상수는 값이 불변, 변수는 값이 가변
		
		//final 변수 = 한 번 값을 초기화하면 더 이상 변경을 할 수 없는 변수 = 상수
		//상수를 사용하고 싶지만 리터럴은 의미가 없어서, 의미 있는 상수를 사용하기 위해서
		//대표적인 것 = 파이값!
		
		final byte kor3 = 70;
		System.out.println(kor3);
		//kor3 = 65; > error
		
		final double PI = 3.14;
		System.out.println(PI * 20);
		
		//pi = 5.20;
		//그래서 그냥 숫자는 리터럴, final 사용한 숫자는 상수라고 말하는 경우가 많음
		//******** final 변수(=상수)명은 대문자로 작성한다. > 변수와 구분하기 위해 (가독성)
		//		   자바는 (식별자의) 대소문자를 구분한다.
		
		byte KOR;
		byte Kor;
		byte kOr;
		byte koR;
		// 전부 다른 변수!
		
		
		
		//식별자 명명법 패턴
		//1. 헝가리언 표기법
		//2. 파스칼 표기법
		//3. 캐멀 표기법
		//4. 스네이크 표기법
		//5. 케밥 표기법
		
		
		//1. 헝가리안 표기법
		// - 식별자를 만들 때 식별자의 접두어로 해당 자료형을 표시하는 방법
		
		//int age;
		//> int intAge; int int_age; int i_age; int iage;(가장 많이 씀)
		//하지만 요즘은 잘 안 씀. 왜냐? age = nn; 적어놓고 마우스 올리면 무슨 자료형인지 이클립스가 알려줌
		
		int age;
		age = 00;
		
		
		//2. 파스칼 표기법 (UpperCamelCase)
		// - 식별자 단어의 첫문자를 대문자로 표기 + 나머지 문자를 소문자로 표기
		// - 2개 이상의 단어로 만든 합성어 > 각 단어의 첫문자를 대문자로 표기
		// - 사용) 클래스명
		
		int englishscore;
		int EnglishScore; //파스칼 표기법
		int English; //파스칼 표기법
		
		
		//3. 캐멀 표기법 (lowerCamelCase)
		// - 식별자 단어의 첫문자를 소문자로 표기 + 나머지 문자를 소문자로 표기
		// - 2개 이상의 단어로 만든 합성어 > 각 단어의 첫문자를 대문자로 표기
		// - 사용) 변수명, 메소드명
		
		int enlishScore; //캐멀 표기법
		int enlish; //캐멀 표기법
		
		
		//4. 스네이크 표기법
		// - 전부 소문자로 표기
		// - 합성어 > 각 단어를 '_'로 연결
		// - 사용) 마음대로. 정해지지 않음
		
		int english_score;
		
		
		//5. 케밥 표기법
		// - 전부 소문자로 표기
		// - 합성어 > 각 단어를 '-'로 연결
		// - 사용) 자바 불가능, 자바는 변수 이름이나 식별자에게 '-' 기호 사용 불가, 나중 과목에서 사용
		
		//int english-score;
		
		
		int MathScore;  // 파스칼 (X)
		int mathScore;  // 캐멀 (O)
		int math_score; // 스네이크 (O)
		//int math-score; // 케밥 (X)
		
		//'자바 코딩 컨벤션' 검색해서 읽어 보기
	
		
		
	}
}
