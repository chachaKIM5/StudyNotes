package com.test.java.question.method;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q06 {

	public static void main(String[] args) throws Exception {
		
	/*
	 
	 프로세스
	 1. String 값 반환하는 메소드 1개 선언 (메소드명 test,
	 								   매개변수 int kor, int eng, int math)
	 2. 조건 연산자와 && 연산자
	 	평균 60점 이상, 전 과목 40점 이상일 시 "합격입니다.",
	 	하나라도 False일 때 "불합격입니다."를 result에 대입하도록 코딩
	 3. 메인 메소드에 라벨 출력 x 3 (국어: ,영어:, 수학: )
	 4. Bufferedreader와 readLine() 이용해
	 	사용자에게 숫자 입력받은 후 int kor, eng, math 변수에 값 대입
	 5. result 출력
	 	 
	 */
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("국어: ");
		int kor = Integer.parseInt(reader.readLine());
		
		System.out.print("영어: ");
		int eng = Integer.parseInt(reader.readLine());
		
		System.out.print("수학: ");
		int math = Integer.parseInt(reader.readLine());
		
		String result = test(kor, eng, math);
		System.out.println(result);
		
	}
	
	public static String test(int kor, int eng, int math) {
		
		int average = (kor + eng + math) / 3;
		String result = average >= 60 && kor >= 40 && eng >= 40 && math >= 40
						? "합격입니다." : "불합격입니다.";
		
		return result;
		
	}
}
