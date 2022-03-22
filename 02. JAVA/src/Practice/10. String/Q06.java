package com.test.java.question.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q06 {

	public static void main(String[] args) throws Exception {
		
		//너무 복잡하니까.. 뒷자리 공식만 적용하기
		
		// 주민등록번호 뒷자리 공식
		// (1) 각 자리에 234567 - 892345 곱하고 다 더함
		// (2) 11로 나눠서 나머지 구함, 나머지 0이거나 1이어서 11, 10 나오면 1, 0으로 결과
		// (3) 11-나머지 = 가장 뒷자리 숫자
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("주민등록번호: ");
		String juminStr = reader.readLine();
		int sum = 0;
		int endNum;
		
		//'-' 유무 상관없이 검사해야 하므로 제거하기
		juminStr = juminStr.replace("-", "");
		
		
		int[] juminNum = new int[juminStr.length()];
		
		for (int i=0 ; i<juminNum.length ; i++) {
			
			juminNum[i] = Integer.parseInt(juminStr.substring(i, i+1));
			
		}
		
		// 과정 (1)
		for (int i=0 ; i<juminNum.length-1 ; i++) {
			
			if (i+2 >= 10) {
				sum += juminNum[i] * (i-6);
			} else {
				sum += juminNum[i] * (i+2);
			}
		}
		
		// 과정 (2)
		if (sum % 11 == 0) {
			endNum = 1;
		} else if (sum % 11 == 1) {
			endNum = 0;
		} else {
			endNum = 11 - (sum % 11); //else = 과정 (3)
		}
		
		
		if (juminNum[juminNum.length-1] != endNum) {
			System.out.println("올바르지 않은 주민등록번호입니다.");
		} else {
			System.out.println("올바른 주민등록번호입니다.");
		}
		
		
		
		
		
	
	
	}
}
