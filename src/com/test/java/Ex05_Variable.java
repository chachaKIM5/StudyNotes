package com.test.java;

public class Ex05_Variable {

	public static void main(String[] args) {
		
		//Ex05_Variable.java
		
		//1. 각 자료형별로 변수 만들기
		//2. 각 자료형별 리터럴 만드는 방법
		
		
		//정수형
		byte b1;
		b1 = 10; //10 > "정수형 리터럴"
		System.out.println(b1);
		
		b1 = 127;
		System.out.println(b1);
		
		//b1 = 128;
		//System.out.println(b1);
		
		b1 = -128;
		System.out.println(b1);
		
		//b1 = -129;
		//System.out.println(b1);
		
		b1 = Byte.MAX_VALUE; //JDK가 기본 제공해 주는 대문자로 된 final 변수 = 상수
							 // 최대, 최소값을 알 수 있도록 (외울 필요 X)
		System.out.println(b1);
		
		b1 = Byte.MIN_VALUE;
		System.out.println(b1);
		
		
		short s1;
		s1 = 3000;
		System.out.println(s1);
		
		s1 = -3000;
		System.out.println(s1);
		
		s1 = Short.MAX_VALUE;
		System.out.println(s1);
		
		
		int n1;
		n1 = 1000000000;
		System.out.println(n1);
		
		n1 = Integer.MAX_VALUE;
		System.out.println(n1); //2147483647
		
		
		long l1;
		l1 = 1000000000;
		System.out.println(l1);
		
		//l1 = 2300000000; //The literal 2300000000 of type int is out of range
		//System.out.println(l1); // error
		
		l1 = Long.MAX_VALUE;
		System.out.println(l1); //9223372036854775807
		
		//왜 long을 사용했는데 int 범위를 벗어났다고 하면서 오류가 났을까?
		//그리고 max값 구해 보면 int 범위보다 훨씬 큰 수가 나옴. 엥?
		
		byte  b2 = 10;
		short s2 = 10;
		int   n2 = 10;
		long  l2 = 10;
		
		System.out.println(b2); //10 > byte
		System.out.println(s2);
		System.out.println(n2);
		System.out.println(l2);
		System.out.println(10); //이 10이라는 리터럴은 어떤 자료형? > int
		
		//변수만 자료형이 있는 게 아니라, 모든 리터럴도 자료형이 있다.
		//** 정수형 리터럴은 무조건! int이다
		//   왜냐하면 CPU + 운영체제 때문에.
		//	 불과 몇 년 전만 해도 32bit 운영체제를 사용하고 있었음
		//	 64bit, 32bit 운영체제의 뜻 -> CPU가 한번에 메모리로부터 처리할 수 있는 데이터의 양
		//	 예로부터 프로그래밍 언어의 'int' 자료형은 운영체제의 bit와 동일했다
		//	 데이터를 CPU가 바로 가져다 쓸 수 있게 하려면, 데이터가 int가 되면 됨

		byte b3;  //1byte -> + 3byte -> 4byte
		short s3; //2byte -> + 2byte -> 4byte
		long l3;  //8byte -> + 1/2 -> 4byte + 4byte
		int n3;   //4byte -> 4byte
		
		//	 결론적으로 int 말고 다른 정수형 자료형은 처리 과정이 생겨 int가 가장 빠름
		//	 따라서 정수형 자료형 4개 중 거의 int만 사용함, int 범위 밖의 수에 가끔 long형 사용
		
		//4Byte int형을 거쳐 변수의 자료형 범위에 들어가기 때문에,
		//정수형 리터럴은 int 범위를 벗어나 표현할 수 없다
		//표현하고 싶으면? 접미어(L)를 붙여 8Byte를 거치는 'long형 상수'로 만들어 주자
		
		l1 = 2300000000L;
		System.out.println(l1);
		l1 = 10L; // 이 경우 자유. (int 범위 내에서 접미어 자유롭게)
		System.out.println(l1);
		
		
		// --------------- ▲정수 ▼ 실수 ------------------
		
		//**정수형 리터럴(상수)는 int이다.
		
		//실수형 리터럴(상수)는 float인가? double인가?
		//**실수형 리터럴은 double이다. > 정밀도가 높아 손실분이 덜 생기기 위해 무조건 double로
		
		//float > 단정도형
		float f1;
		// f1 = 3.14; > error
		f1 = 3.14F; //실수형 리터럴 표기법 접미어(F)
		System.out.println(f1);
		
		
		//double > 배정도형: 정밀도가 높다
		double d1;
		d1 = 3.14; // d1 = 3.14D;도 가능. 사실 이게 정석
		System.out.println(d1);
		
		f1 = 123.1234567890123456789012345678901234567890F;
			//123.12346 -> 소수 이하 5자리까지 반올림.. float의 손실분 많음
		d1 = 123.1234567890123456789012345678901234567890D;
			//123.12345678901235 -> 소수 이하 14자리까지. float의 2-3배 기억
		
		System.out.println(f1);
		System.out.println(d1);
		
		// 소수 이하 없이 정수만?
		f1 = 123456789012345678901234567890123456789F; //1.2345679E38
		d1 = 123456789012345678901234567890123456789D; //1.2345678901234568E38
	          //정수형 long의 최대치 9223372036854775807
		System.out.println(f1);
		System.out.println(d1);
		
		//결론
		//정수형: 손실이 없이 정확히 표현
		//실수형: 표현은 가능하지만 손실분 존재
		//실수형을 잘 사용하지 않게 됨. 반드시 필요한 경우 및 손실분이 미미한 경우에만 사용
		
		
		//문자형
		char c1;
		//c1 = 문자; > error
		//컴파일러는 기본적으로 어떤 단어가 오면, 무언가의 식별자나 예약된 키워드라고 판단함(변수명 등)
		
		c1 = 'A';  //문자형 상수(리터럴) 표기법
		System.out.println(c1);
	
		char c2 = '가';
		System.out.println(c2);
		
		char c3 = '@';
		System.out.println(c3);
		
		char c4 = '1'; // '1'은 숫자가 아니라 문자로서의 '1'임. 더하기 빼기 등등.. X
		System.out.println(c4);
		
		//Invalid character constant
		//c1 = '홍길동'; > error
		//char형은 반드시 1개의 문자만을 저장할 수 있다
		
		char name1 = '홍';
		char name2 = '길';
		char name3 = '동';


		
		
		//논리형
		// - 상수의 종류: 2개
		boolean flag;
		
		flag = true;  //논리형 리터럴(true)
		flag = false; //논리형 리터럴(flase)

		System.out.println(flag);
		
		
		//10
		//10L
		//3.14F
		//3.14
		//3.14D
		//'A'
		//true
		
		
		//- 문자열, String
		//- 추가 자료형: 참조형에 속함, 0개 이상의 문자
		//- 문자의 열: 문자들이 열을 지어 있는 형태 > 문자의 집합 > char가 여러 개 모인 형태
		
		String name;
		name = "홍길동"; //문자열 리터럴(상수) 표기법
		System.out.println(name);
		
		
		//A 저장
		char m1 = 'A';
		String m2 = "A";
		
		//ABC 저장
		//char m3 = 'ABC';
		String m4 = "ABC";
		
		//보통 char보다 String을 더 많이 사용한다.
		
		String m5 = ""; //0개의 문자열 > 빈문자열(=Empty String)
		
		//char m6 = '';   빈문자? (X)
		char m7 = '\0'; //빈문자(Null 문자)
		
		//9개의 자료형
		//값형(8개) + 참조형(1개)
		
		//똑같은 값을 가지는 변수 2개 필요
		//int age = 20;
		//int copy = 20; -> 이렇게 하면 age만 수정하고 copy는 수정 안 하는 실수 할 가능성
		
		int age = 20;   //변수 = 값;
		int copy = age; //변수 = 변수; > 변수 = 변수가 가지는 값
						//*** 변수끼리 값을 복사할 수 있다.
		
		//연산자 -> =(대입), +
		
		int a1 = 10;
		int a2 = 20;
		int a3 = a1 + a2; //산술 연산
		System.out.println(a3);
		
		String str1 = "홍길동";
		String str2 = "안녕하세요.";
		String str3 = str1 + str2; //산술 연산(X), 문자열 연산자(O) > Concat
		System.out.println(str3); //홍길동안녕하세요.
		
		
		a1 = 100;
		a2 = 200;
		a3 = a1 + a2;
		
		//화면에 출력 > 연산과정과 함께 결과를 출력하시오.
		// > 100 + 200 = 300
		
		System.out.println("100 + 200 = 300");
		System.out.println("100 + 200 = " + a3); //한쪽은 문자, 한쪽은 숫자? > 문자열 연산
		// + 연산자는 피연산자 중 하나라도 문자가 있을 경우 다 문자로 취급
		
		System.out.println(a1 + " + 200 = 300");
		System.out.println(a1 + " + " + a2 + " = " + a3);
		
		
		
		age = 27;
		
		//안녕하세요. 저는 27살입니다.
		System.out.println("안녕하세요. 저는 " + age + "살입니다.");
		
		
		
		//숫자형 데이터를 저장할 변수를 만들 때 주의할 점 (자료형 선택)
		//- 수치로서의 데이터 > 더하기 빼기 가능
		//- 수치가 아닌 데이터 > 문자열로 취급
		
		//1. 몸무게
		int weight;
		weight = 70;
		
		//2. 주민등록번호 앞자리 (생년월일) > 표기만 숫자일 뿐 수치가 아님! 
		int jumin; //절대 금지!!
		jumin = 951205;
		System.out.println(jumin);
		
		//3. 상품번호
		int productNo;
		productNo = 123;
		System.out.println(productNo);
		
		//2000년에 태어난 아기
		//- 2000년 3월 7일
		jumin = 000307;
		
		System.out.println(jumin); //199.. 307도 아니고 왜 199가 나왔을까?
		
		//자바의 기수 표기법
		// - 데이터 표시는 아래와 같이 3개의 기수법을 제공
		//	 그러나 출력은 기수법과 상관없이 항상 10진수로 출력됨.
		
		//1. 10진수 > 100
		//2. 8진수  > 0100  > 010  > 8
		//3. 16진수 > 0x100 > 0x10 > 16
		
		String jumin1 = "000307";
		
		
		
		//과제 (220307)
		//- 구글드라이브 날짜별 폴더에 개인 이름으로 폴더 만들어서 제출
		//- 문자열 포함 9개 각 자료형별로 변수 10개씩 만들기 > 문장으로 출력하시오.
		//- 자료형 + 변수 + 리터럴 + 출력 연습

		//1. 주변의 데이터 검색! 아무거나. 손가락 발가락 개수, 나이, 몸무게, 키, 친구 몇 명..
		//2. 1의 데이터가 자바의 어떤 자료형에 적합한지? > 매칭 > 정수 vs 실수 + 길이 고려
		//	 > 9개 자료형 중 하나 선택
		//3. 2의 자료형 사용해 변수 선언하기 > 변수명 의미 있게 짓는 연습
		//4. 3의 변수 > 데이터 대입(자료형에 맞는 리터럴 표기법 연습)
		//5. 출력 > 문장으로 만들어서 출력
		
		//자료형마다 아래의 예제 10번씩
		double height = 168.7;
		System.out.println("제 키는 " + height + "cm입니다.");
		
		
		
		
		
		
		
	
	
	
	}
}

