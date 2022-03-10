package com.test.java;

public class Ex11_Operator {

	public static void main(String[] args) {
		
		//Ex11_Operator.java 220310
		
		
		/*
		 
		 연산자, Operator
		 - 수학 연산자와 동일
		 - 피연산자를 대상으로 미리 정해진 연산(행동)을 한 후에 연산(행동)의 결과를 반환하는 요소
		 - 주로 기호를 사용 + 단어도 많이 사용
		 
		 1. 문장, Statement
		 2. 표현식, Expression
		 3. 연산자, Operatior
		 4. 피연산자, Operand
		 5. 연산자 우선순위
		 6. 연산자 연산방향
		 
		 문장, Statement
		 - int sum = 10 + 20;
		 
		 표현식, Expression
		 - 문장을 구성하는 최소 단위
		 - 더 이상 쪼개지지 않는 표현
		 - int sum
		 - 10 + 20
		 - sum = 30
		 - 10
		 - 20
		 
		 연산자, Operator
		 - +
		 - =
		 
		 피연산자, Operand
		 - +의 피연산자: 10, 20
		 - =의 피연산자: 30, sum
		 
		 
		 
		 연산자 종류
		 1. 행동
		 	a. 산술 연산자
		 	b. 비교 연산자
		 	c. 논리 연산자
		 	d. 대입 연산자
		 	e. 증감 연산자
		 	f. 조건 연산자
		 	g. 비트 연산자
		 	
		 2. 형태(피연산자의 개수)
		 	a. 1항 연산자
		 	b. 2항 연산자
		 	c. 3항 연산자
		 	
		 
		 
		 	a. 산술 연산자
		 		- +, -, *, /, %(mod, 나머지 연산자)
		 		- 2항 연산자
		 		- 숫자형 피연산자를 가진다. (정수, 실수, char 자료형)
		 				 		
		 */
		
		
		int a = 10;
		int b = 3;
		
		System.out.printf("%d + %d = %d\n", a, b, a + b); //10 + 3 = 13
		System.out.printf("%d - %d = %d\n", a, b, a - b); //10 - 3 = 7 
		System.out.printf("%d * %d = %d\n", a, b, a * b); //10 * 3 = 30
		System.out.printf("%d / %d = %d\n", a, b, a / b); //10 / 3 = 3
		System.out.printf("%d %% %d = %d\n", a, b, a % b);//10 % 3 = 1
		//*** printf 사용할 때만: %를 mod로 인식시키기 위해 %%로 적어 줘야 에러가 없음
		
		
		//나누기 연산자 주의!
		//***** 모든 산술 연산자의 결과 자료형은 두 피연산자 중 더 크기가 큰 자료형으로 반환된다.
		// +, -, * 자료형 신경 쓰며 계산할 것
		
		System.out.println(10 / 3);			//정수/정수 > 3
		System.out.println(10.0 / 3.0);		//실수/실수 > 3.3333333333 
		System.out.println(10.0 / 3);		//실수/정수 > 3.3333333333
		System.out.println(10 / 3.0);		//정수/실수 > 3.3333333333
		System.out.println(10 / 6);
		
		System.out.println(10 / 3); 		// int / int = int
		System.out.println(10.0 / 3.0);		// double / double = double
		System.out.println(10.0 / 3);		// double / int = double
		System.out.println(10 / 3.0);		// int / double = double
		
		int c = 1000000000;
		int d = 2000000000;
		
		System.out.println(c + d); 			// int + int = int
		System.out.println((long)c + d);	// long + int = long
		System.out.println();
		
		
		//byte, short
		byte b1 = 10;
		byte b2 = 20;
		
		//*** byte, short 연산의 결과는 무조건 int형이다. > CPU 처리 단위(int)
		System.out.println(b1 + b2); // byte + byte = int
		byte b3 = (byte)(b1 + b2); //불편함 > byte, short 사용 안 함
		
		
		System.out.println();
		System.out.println();
		
		
		
			/*
			
			b. 비교 연산자
				- >, >=, <, <=, ==(equal), !=(not equal, 수학에서는 <>)
				- 2항 연산자
				- 피연산자들의 우위(동등) 비교하는 연산자
				- 피연산자는 숫자형을 가진다.
				- 연산의 결과가 boolean(true/false)이다.
				
			a = 10;
			b = 3;
			
			*/
		
			System.out.printf("%d > %d = %b\n", a, b, a > b);		
			System.out.printf("%d >= %d = %b\n", a, b, a >= b);		
			
			System.out.printf("%d < %d = %b\n", a, b, a < b);		
			System.out.printf("%d <= %d = %b\n", a, b, a <= b);	
			
			System.out.printf("%d == %d = %b\n", a, b, a == b);	
			System.out.printf("%d != %d = %b\n", a, b, a != b);
		
			
			//요구사항] 사용자 나이 입력 > 19세 이상이면 통과
			int age = 25; //사용자 나이 입력 결과가 25일 때
			
			System.out.println(age >= 19); // 권장 표현
			System.out.println(19 <= age); // 비권장 표현
			//A >= B
			//주체는 A, 비교 대상은 B
			
			
			
			/*
			 
			c. 논리 연산자
			  - &&(and), ||(or), !(not, 부정 연산자)
			  - 2항 연산자(&&, ||), 1항 연산자(!)
			  - 피연산자의 자료형이 boolean이다.
			  - 연산의 결과가 boolean이다.
			  - 피연산자를 대상으로 정해진 규칙에 따라 정해진 값을 반환하는 연산자
			  			  
			  - A && B = ?
			  - T && T = T
			  - T && F = F
			  - F && T = F
			  - F && F = F
			  
			  - A || B = ?
			  - T || T = T
			  - T || F = T
			  - F || T = T
			  - F || F = F
			  
  
			 */

			  boolean f1 = true;
			  boolean f2 = false;
			  
			  System.out.println(f1 && f2); //false
			  System.out.println(f1 || f2); //true
			  System.out.println(!true); 	//false
			  System.out.println(!false); 	//true
			  
			  
			  
			  
			  /*
			  
			  d. 대입 연산자, 할당 연산자 
			  	- =
			  	- +=, -=, *=, /=, %=
			  	- LValue(변수) = RValue(상수, 변수) 
			  	- LValue와 RValue는 자료형이 동일해야 한다. > 형변환
			  	- 대입 연산자는 모든 연산자들 중 연산자 우선 순위가 가장 낮다.
			  	
			  	* 연산자 우선 순위
			  	  - 하나의 문장에 속한 모든 연산자들은 실행 순서를 가진다.
			  	  - 산술 연산자 > 비교 연산자 > 논리 연산자 > 대입 연산자
			  	  
			  	* 연산자 연산 방향
			  	  - 하나의 문장에 속한 동일한 종류의 연산자들은 실행 순서를 가진다.
			  	  - 대입 연산자, 증감 연산자: 오른쪽 -> 왼쪽
			  	  - 나머지 연산자: 왼쪽 -> 오른쪽
			 
			  */
			  
			  
			  int sum = 10 + 20 + 30;
			  System.out.println(sum); //60
			  
			  //연산자 3개
			  
			  
			  int n = 10;
			  
			  //n이 가지는 값에 1을 더한다. > 누적 (*****)
			  n = n + 1;
			  System.out.println(n); //11
			  
			  n += 1; // n = n + 1
			  System.out.println(n); //12
			  
			  n += 2; 
			  System.out.println(n); //14
			  
			  n += 10;
			  System.out.println(n); //24
			  
			  
			  n = n - 2;
			  System.out.println(n); //22
 			  
			  n -= 2;
			  System.out.println(n); //20
			  
			  n -= 7;
			  System.out.println(n); //13
			  
			  
			  n = n * 2;
			  System.out.println(n); //26
			  
			  n *= 2;
			  System.out.println(n); //52
			  
			  
			  n = n / 3;
			  System.out.println(n); //17
			  
			  n /= 3;
			  System.out.println(n); //5
			  
			  
			  n = n % 3;
			  System.out.println(n); //2
			  
			  n %= 2;
			  System.out.println(n); //0
			  
			  
			  //***** 주의)
			  //n = 5 - n;와 n -= 5;는 다르다  
			  
			  
			  
			  //문자열 연산자 (+)
			  //- 2항 연산자
			  //- 피연산자로 문자열을 가진다.
			  //- 연산 결과로 두 문자열을 합친 문자열을 반환하는 연산자
			  
			  //- 문자열 + 문자열 = 문자열
			  //- 문자열 + 비문자열 = 문자열
			  //- 비문자열 + 문자열 = 문자열
			  
			  //- 비문자열 + 비문자열 => 산술 연산자
			  
			  
			  //연산자 연산방향, 문자열 연산자, 산술 연산자
			  System.out.println(100 + 200 + 300); //600
			  System.out.println(100 + 200 + "300"); //300300
			  System.out.println(100 + "200" + 300); //100200300
			  System.out.println("100" + 200 + 300); //100200300
			  System.out.println("100" + (200 + 300)); //100500
			  
			  
			  
			  //비교 연산자
			  //- ==, !=
			  
			  int num1 = 100;
			  int num2 = 100;
			  int num3 = 200;
			  int num4 = 50;
			  num4 = num4 + 50;
			  
			  System.out.println(num1 == num2);
			  System.out.println(num1 == num3);
			  System.out.println(num1 == num4);
			  System.out.println();
			  
			  String txt1 = "홍길동";
			  String txt2 = "홍길동";
			  String txt3 = "김승연";
			  String txt4 = "홍";
			  txt4 = txt4 + "길동";
			  
			  System.out.println(txt1 == txt2);
			  System.out.println(txt1 == txt3);
			  System.out.println(txt4); //홍길동
			  System.out.println(txt1 == txt4); //false ****************
			  System.out.println();             
			  
			  //"홍길동" == "홍길동" > true
			  //"홍길동" == "홍" + "길동" > false
			  //********** 자바는 문자열을 대상으로 ==, != 연산자를 사용할 수 없다. 절대!
			  //글자 자체만 비교하기 위해서는 아래의 메소드를 이용
			  
			  System.out.println(txt1.equals(txt2)); //true
			  System.out.println(txt1.equals(txt4)); //true
			  System.out.println(!txt1.equals(txt4)); //false
	
			  
			  /*
			   
			  e. 증감 연산자
			   - ++, --
			   - 1항 연산자, 단항 연산자
			   - 피연산자로 숫자형을 가진다.
			   - 누적 연산을 한다. = 기존의 값에 1을 더하거나, 1을 뺀다.
			   - 연산자와 피연산자의 위치를 바꿀 수 있다. > 연산자 우선 순위가 달라진다.
			     	a. ++n: 전위 배치(전치 연산자) > 연산자 우선 순위가 가장 높음, 소괄호 다음으로
			     	b. n++: 후위 배치(후치 연산자) > 연산자 우선 순위가 가장 낮음
			    
			  */
			  
			  n = 10;
			   
			  //3개의 같은 표현, 하지만 ++는 무조건 '1'만!
			  ++n;
			  n = n + 1;
			  n += 1;
			   
			  --n;
			  n = n - 1;
			  n -= 1;
			  
			  System.out.println(n);
			  
			  
			  //전위 배치와 후위 배치의 차이
			  n = 10;
			  int result = 0;
			  
			  result = 10 + ++n;
			  // 1순위 ++, 2순위 +, 3순위 =
			  System.out.println(result); //21
			 
			  
			  n = 10;
			  result = 0;
			  
			  result = 10 + n++;
			  // 1순위 +, 2순위 =, 3순위 ++
			  System.out.println(result); //20
			  
			  
			  // ->  증감 연산자는 가독성이 낮고 복잡해 한 문장에 다른 연산과 함께 사용하지 않는 것을 권장
			  // ++n;
			  // result = 10 + n;
			  
			  // result = 10 + n;
			  // n++;
			  
			  
			  int o = 10;
			  
			  System.out.println(--o - o--); 
			  System.out.println();
			  
			  /*
			  
			  f. 조건 연산자
			   - A ? B : C
			   - ?:
			   - A, B, C 피연산자
			   - 3항 연산자
			   - A: boolean
			   - B, C: 상수, 변수, 연산식, 메소드
			
 
			  */

			   boolean flag = true;
			   
			   String fresult = flag ? "참" : "거짓";
			   System.out.println(fresult);
			   
			   
			   
			   age = 15;
			   
			   fresult = age >= 19 ? "통과" : "거절";
			   System.out.println(fresult);
			   
			   
			   
			   //요청사항] 쇼핑몰의 티셔츠 구매 > 색상 선택 (검정, 노랑, 파랑)
			   
			   String color = "주황"; //색상 입력 요청 결과
			   
			   fresult = (color.equals("검정") || color.equals("노랑") || color.equals("파랑")) ? "재고있음" : "재고없음";
			   System.out.println(fresult);
			   
			   
			   
			   //요청사항] 입력한 수의 짝수/홀수 여부 나타내기
			   
			   n = 10;
			   System.out.println((n % 2 == 0) ? "짝수" : "홀수");
			   
			   
			   
			   //반드시 B와 C의 자료형이 동일해야 한다.
			   //int num = true ? 10 : "홍길동"; > error
			   
			   
			   
			   //문제 > 문제 풀이 > 
			   
			   
			 
	}
	
}
