package com.test.java;

public class Ex02_DataType {

	public static void main(String[] args) {
	

		//주석 달기(필기에도 유용)
		//단일 주석 단축키: Ctrl+/
		//다중 주석 단축키: Ctrl+Shift+/, Ctrl+Shift+\

		//두 번째 예제입니다.
		
	
//		System.out.println();
//		System.out.println();
//		System.out.println();
//		System.out.println();
//		System.out.println();
		
		// Ctrl + Alt + 방향키(위, 아래) 복사 - 블럭 단위로도 가능
//		System.out.println(안녕하세요.);
//		System.out.println(홍길동입니다.);
//		System.out.println(반갑습니다.);
		
		// Alt + 방향키(위, 아래) 움직이기 - 블럭 단위로도 가능
//		System.out.println(안녕하세요.);
//		System.out.println(홍길동입니다.);
//		System.out.println(반갑습니다.);
		
		// Shift + Home, End - 한 줄만 선택
//		System.out.println(안녕하세요.);
//		System.out.println(홍길동입니다.);
//		System.out.println(반갑습니다.);		
		
		// Ctrl + D - 라인 단위 삭제
		
		// 새로운 언어(기술) > 자료형(Data Type)


		
/*
 
		자료형, Data Type
		 - 데이터(자료)의 형태
		 - 데이터의 길이(범위)와 생김새를 미리 정의하고 분류해 놓은 규칙 > 이름
		
		현실에서
		 - 100, 200, 300 > 숫자
		 - 10, 20, 30 > 정수
		 - 2.3, 43.53, 12.32 > 실수
		 - 홍길동, 자바, 컴퓨터 > 문자(열)
		
		
		Q. "자바의 값형에는 어떤 것이 있나요?"
		A. "정수형에 byte, short, int, long이 있고
		   실수형에 float, double이 있고,
		   문자형에 char가 있고,
		   논리형에 boolean이 있습니다."
		
		자바의 자료형 (언어마다 자료형이 다르다)
		1. 원시형(Primitive Type), 값형(Value Type)
			a. 숫자형 (자바의 정석 3.3 8진법과 16진법~3.6 음수의 2진 표현 - 2의 보수법 참고)
				1) 정수형 (정수형의 byte, short, int, long이 몇 byte를 뜻하는지 외울 것)
					a) byte
						- 1byte(=8bit)
						- 2^8
					 	 (1bit에 공간 1칸, 공간 1칸에 0 혹은 1 두 가지의 경우,
					 	  맨 앞칸은 부호 비트, 0양수 1음수를 뜻함.
					 	  나머지 7칸은 데이터 비트
					 	  8칸 있다 -> 경우의 수 2^8)
					 	- -128 ~ 127 저장 가능
					b) short
						- 2byte(=16bit)
						- 2^16
						- -32768 ~ 32767
					c) int
						- 4byte(=32bit)
						- 2^32
						- -21억 ~ 21억
					d) long: long보다 더 큰 자료는 Java를 쓰면 안 됨
						- 8byte(=64bit)
						- 2^64
						- -922경 ~ 922경
				2) 실수형
					a) float
						- 4byte
						- 무제한
						 (3.14를 저장한다고 했을 때 3.14를 314x10^-2로 표현
						  맨 앞 1비트는 부호비트, 8비트 지수부와 23비트 가수부
						  지수부에 2^8=256개 표현 가능, 즉 10^256 표현 가능해 거의 무제한
						  가수부에 표현할 수 있는 숫자가 제한적
						  314 표현 못하면 300으로 표현.. 버리는 숫자가 생김=오차 발생)
						- 단정도형(정밀도 > 유효한 숫자를 저장할 수 있는 범위)
					b) double
						- 8byte
						- 무제한
						- 배정도형(단정도에 비해 두 배 더 정밀하다는 뜻)
			b. 문자형
				1) 문자형
					a) char(캐릭터)
						- 2byte
						- 2byte를 쓴다 = 유니코드를 지원한다
						- 컴퓨터는 당연 글자를 못 알아듣고 0과 1만 알아들어서
						  00000000 = A, 00000001 = B
						  처럼 경우의 수에 따른 약속(규칙)을 정함 > 규칙=문자셋=문자코드
						- 이미 컴퓨터들은 이 '문자셋' 테이블을 내장하고 있음
						- 1byte는 2^8=256가지 경우의 수 지원
						  영문자(52자)+특수문자+숫자.. 처음에는 8bit로 충분했지만
						  비영어권의 문자들을 표현하려 하자 부족, 16bit(2byte)로 늘림=65535가지
						  지구상의 대부분의 문자를 등록(대략 4만 개)하고도 1/3이 남음
						  > 이걸 유니코드라고 부름!
						  > "유니코드를 사용합니다" = "한 문자를 표현하는 데 2byte를 사용합니다"
				
					cf) 한글 체계
						- 조합형
							: 초성, 중성, 종성 > 조합 > 한 글자가 됨
					 	- 완성형
					 		: 글자를 이미지화해 모든 문자를 등록
					 		  
			c. 논리형
				1) 논리형
					a) boolean
						- 1byte
						- 명제 > 참, 거짓
						- true, false
			
		2. 참조형(Reference Type)
			- 나중에 수업
		
*/
		
	}
	
}
