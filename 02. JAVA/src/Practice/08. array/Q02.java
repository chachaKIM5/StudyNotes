package com.test.java.question.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q02 {

	public static void main(String[] args) throws Exception {
	
	/*
	
	학생 이름은 원하는 만큼 입력받아 출력
	reader.readLine()만큼 배열 길이 정하기
	Arrays.sort 사용하지 않고 직접 정렬
		
	프로세스 설계
	
	 1. 문자열 배열 student[] 선언, BufferedReader로 학생 수 = 배열 길이를 입력받는다 
	 2. 반복문으로 student[]의 길이만큼 학생명을 입력받고 각 요소에 값(학생명)을 대입
	 3. String[] 반환하는 정렬 메소드 array 생성,
	    2중 for문과 compareTo 메소드 활용해 요소들을 가나다 순으로 정렬
	 4. 메인 메소드로 돌아와서 요구된 형식에 맞춰 출력
	 	
	 */
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.printf("학생 수: ");
		String[] student = new String[Integer.parseInt(reader.readLine())];
		
		
		
		//처음에 입력받은 학생 수만큼 학생명 입력받기
		for (int i=0 ; i<student.length ; i++) {

			System.out.printf("학생명: ");
			student[i] = reader.readLine();
		}
		
		
		//메소드 호출
		array(student);
		
		
		//결과 출력
		System.out.printf("입력한 학생은 총 %d명입니다.\n", student.length);
	
		for (int i=0 ; i<student.length ; i++) {
			System.out.printf("%d. %s\n", i+1, student[i]);
		}
		
		
	}

	
	
	public static String[] array(String[] student) {			//String 버블 정렬 메소드

		for (int i=0 ; i<student.length-1 ; i++) {
			for (int j=0 ; j<student.length-i-1 ; j++) {
				
				if (student[j].compareTo(student[j+1]) > 0) {
					
					//swap
					String temp = student[j];
					student[j] = student[j+1];
					student[j+1] = temp;
					
				}
			}
		}
		
		return student;
	}
}
