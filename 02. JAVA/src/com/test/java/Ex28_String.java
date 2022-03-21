package com.test.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex28_String {

	public static void main(String[] args) throws Exception {
		
		//Ex28_String.java
		
		//문자열, String
		// - JDK 제공 문자열 조작 기능
		// - 문자열의 실체?
		
		
		//m1();
		//m2();
		//m3();
		//m4();
		//m5();
		//m6();
		//m7();		
		//m8();
		m9();
		
		
	}

	private static void m9() { //문자열 대소문자 변경

		//문자열 대소문자 변경
		//- String toUpperCase() > 문자열의 모든 문자를 대문자로 변경
		//- String toLowerCase() > 문자열의 모든 문자를 소문자로 변경
		
		String content = "오늘 수업하는 과목은 JAVA입니다.";
		String word = "Java";
		
		System.out.println(content.toUpperCase());
		System.out.println(word.toUpperCase());
		
		
		//대소문자 구분(Case sensitive)
		//- 정확도 높음
		//- 검색율 낮음
		if (content.indexOf(word) > -1) {
			System.out.println("결과 있음");
		} else {
			System.out.println("결과 없음");
		}
		

		
		//대소문자 구분 X (Case insensitive) 
		//- 검색율 높음
		//- 정확도 낮음
		
		//메소드 체인
		//- 코딩 패턴 중 하나 > 패턴 > 패러다임 > 함수형 프로그래밍
		//문자열.메소드().메소드().메소드()
		if (content.toUpperCase().indexOf(word.toUpperCase()) > -1) {
			System.out.println("결과 있음");
		} else {
			System.out.println("결과 없음");
		}
	}

	private static void m8() { //문자열 검색 예제) 게시판에 금지어 설정

		//게시판 글쓰기 > 금지어
		
		String word = "바보"; //금지어
		String content = "안녕하세요. 멍청이 저는 자바를 배우는 학생입니다."; //글쓰기
		
		if (content.indexOf(word) > -1) {
			//금지어 발견
			System.out.println("금지어 발견!!");
		} else {
			System.out.println("글쓰기 진행...");
		}
		
		String[] words = {"바보", "멍청이", "메롱"};
		
		for (int i=0 ; i<words.length ; i++) {
			if (content.indexOf(words[i]) > -1) {
				System.out.println("금지어 발견!!");
				break;
			}
		}
		
		System.out.println("완료");
		
		
		
		//주민등록번호 '-' 검사, 
		
		String jumin = "960506-2013529";
		
		if (jumin.charAt(6) == '-') {
			System.out.println("O");
		} else {
			System.out.println("X");
		}
		
		
		if (jumin.indexOf('-') == 6) {
			System.out.println("O");
		} else {
			System.out.println("X");
		}
		
		
	}

	private static void m7() { //문자열 검색
		//문자열 검색 (**********)
		//- 문자열 내에서 원하는 문자(열)를 검색 > 발견한 위치(index) 반환
		//- 처음 만난 검색어의 위치를 반환한 뒤 종료 (뒤에 반복되는 검색어는 검색할 수 없음)
		//- int indexOf(char c)
		//- int indexOf(String s)
		
		//오버로딩 추가
		//- int indexOf(char c, int beginIndex)
		//- int indexOf(String s, int beginIndex)
		
		String txt = "안녕하세요. 홍길동입니다.";
		
		int index = -1;
		
		index = txt.indexOf('하');
		System.out.println(index); //2

		index = txt.indexOf('홍');
		System.out.println(index); //7
		
		index = txt.indexOf('강'); //-1
		System.out.println(index);
		
		index = txt.indexOf("홍길동"); //문자열이 오면? 첫 번째 문자의 위치를 반환
		System.out.println(index);
		
		
		txt = "안녕하세요. 홍길동입니다. 반갑습니다. 홍길동입니다. 네 홍길동입니다.";
		
		index = txt.indexOf("홍길동"); //첫번째 홍길동
		System.out.println(index);
		
		index = txt.indexOf("홍길동", index + "홍길동".length()); //첫번쨰 홍길동 다음 위치부터 찾은 두번째 홍길동
		System.out.println(index);

		index = txt.indexOf("홍길동", index + "홍길동".length()); //두번째 홍길동 다음 위치부터 찾은 세번째 홍길동
		System.out.println(index);

	}

	private static void m6() { //공백(엔터, 탭, 스페이스) 제거 메소드

		//문자열 공백 제거
		//- String trim()
		//- 문자열에 존재하는 공백(Whitespace > 스페이스, 탭, 개행)을 제거하는 메소드
		//- 문자열의 시작과 끝에 존재하는 공백 문자를 제거한다. (***)
		//- 불필요하거나 or 사용자 실수로 생긴 공백 제거 역할
		
		String txt = "     하나     둘     셋     ";
		System.out.printf("[%s]\n", txt);
		System.out.printf("[%s]\n", txt.trim());
		
		
		//"             자바               ".equals("자바")
		//"자바".equals("자바")
		
	}

	private static void m5() throws Exception { //예제: 주민등록번호 유효성 검사+남자, 여자 메인

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("주민등록번호: ");
		String jumin = reader.readLine();
		
		if (isValidJumin(jumin)) {
			System.out.println("올바른 주민등록번호");
			
			if (jumin.charAt(7) == '1' || jumin.charAt(7) == '3') {
				System.out.println("남자");
			} else {
				System.out.println("여자");
			}
		} else {
			System.out.println("올바르지 않은 주민등록번호");
		}
		
	}
	
	private static boolean isValidJumin(String jumin) { //예제: 주민등록번호 유효성 검사 // 메소드
		//하이픈이 없으면 잘못된 주민등록번호로 취급하기
		
		if (jumin.charAt(6) == '-') {
			return true;
		} else {
			return false;
		}
	}
	
	private static void m4() throws Exception { //예제: 회원가입 시 이름 유효성 검사 / 메인

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//회원 가입
		//- 이름 입력 > 길이 (2~5자) + 한글만 가능
		
		System.out.print("이름: ");
		String name = reader.readLine();
		
		if (isValid(name)) {
			System.out.println("올바른 이름");
		} else {
			System.out.println("올바르지 않은 이름");
		}
		
	}
	
	private static boolean isValid(String name) { //예시: 회원가입 시 이름 유효성 검사 / 메소드
		
		if (name.length() < 2 || name.length() > 5) {	// 첫 번째 검사
			return false;
		}
		
		for (int i=0 ; i<name.length() ; i++) {
			char c = name.charAt(i);
			
			if (c < '가' || c > '힣') { // 두 번째 검사
				return false;
			}
		}
		
		return true;
	}
	
	private static boolean isValid2(String name) { //잘못된 예시: 회원가입 시 이름 유효성 검사 / 메소드

		//1. 길이 검사
		//2. 한글 검사
		
		//if절로 올바르지 않은 걸 찾아야 하는데, 올바른 걸 찾으면 아래와 같이 if절에서 아무것도 못하고 탭+자리만 차지
		//코드 위상 > 들여쓰기
		
		//길이 검사
		if (name.length() >= 2 && name.length() <=5) {	//첫 번째 조건
			
			//한글 검사
			for (int i=0 ; i<name.length(); i++) { 		//두 번째 조건
				char c = name.charAt(i);
				
				if (c >= '가' && c <= '힣') {
					// return true 하면 안 됨!! 나머지 검사 안 하고 i=0에서 그냥 true 반환할 수도
					
				} else {
					return false;
				}
			}
			
			return true; //입력 문자가 모두 한글인 게 확인된 위치!
			
		} else {
			return false;
		}
		
	}

	private static void m3() throws Exception {	//아이디 입력 유효성 검사 예제
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//아이디 입력 > 올바른 아이디 검사
		//영어 소문자
		
		System.out.print("아이디: ");
		String id = reader.readLine();
		
		for (int i=0 ; i<id.length() ; i++) {
			
			char c = id.charAt(i);
			//System.out.println(c);
			
			//문자 코드값 비교: 영어 소문자가 아니라면~
			if (c < 'a' || c > 'z') {
				System.out.println("잘못된 문자가 발견되었습니다.");
				break;
			}
		}

		System.out.println("종료");
		
//		String a = "A";
//		char b = 'A';

//		System.out.println((int)a); //값형 <-> 참조형 형변환 불가능
//		System.out.println((int)b); //값형 형변환 > 가능
		
		
		
	
	}

	private static void m2() {					//문자열 추출 char charAt(int index)

		//문자열 추출
		//- char charAt(int index)
		//- 원하는 위치의 문자를 추출하는 메소드
		//- Zero-based Index
		
		String txt = "안녕하세요. 홍길동입니다.";
		
		char c = txt.charAt(3);
		System.out.println(c);
		
		c = txt.charAt(7);
		System.out.println(c);
		
		c = txt.charAt(13);
		System.out.println(c);
		
		//java.lang.StringIndexOutOfBoundsException: index 14,length 14
		//c = txt.charAt(14);
		//System.out.println(c);
		
		//마지막 문자
		c = txt.charAt(txt.length()-1);
		System.out.println(c);
		
		
	}

	private static void m1() throws Exception { //문자열 길이 int.length()
		
		//문자열 <=> 문자
		//String <=> char
		//문자열 = 문자의 집합
		
		//문자열 없는 언어 > 문자 배열 > String == char[]
		//문자열 조작 기능 == 배열 조작 기능 유사
		
		
		//문자열 길이
		//- 문자열을 구성하는 문자의 개수(글자수)
		//- int length()
		
		int[] nums = { 10, 20, 30 };
		System.out.println(nums.length);	//프로퍼티(변수)
		
		
		char[] clist = { '홍', '길', '동', '입', '니', '다', '.' };
		System.out.println(clist.length);
		
		String str = "홍길동입니다.";
		System.out.println(str.length()); 	//메소드
		
		System.out.println("아무개입니다".length());
		
		System.out.println("English, 한글, 01234567890, !@#$%".length());
		
		//요구사항] 사용자 입력 > 문자수?
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("문장 입력: ");
		String statement = reader.readLine();
		
		System.out.printf("입력한 문장은 %d개의 문자로 구성되었습니다.\n",
							statement.length());
		
		
		//유효성 검사
		//- 사용자의 이름 입력
		//- 2~5자 이내로 입력
		
		if (statement.length() >= 2 && statement.length() <= 5) {
			System.out.println("올바른 이름");
		} else {
			System.out.println("이름은 2자 ~ 5자 이내");
		}
		
		
	}
}
