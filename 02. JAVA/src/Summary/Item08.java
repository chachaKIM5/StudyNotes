package com.test.java;

public class Item08 {

	public static void main(String[] args) {
		
		//[SUMMARY] 값형(원시형) 형변환 (2022. 3. 12. 오후 10:14:02)

		
		//큰형 = 작은형 (암시적 형변환)
		int n1 = 10; //원본
		long l1;
		
		l1 = n1;
		
		
		//작은형 = 큰형 (명시적 형변환)
		byte b1;
		short s1 = 30000;
		
		//b1 = s1; > error
		b1 = (byte)s1; //b1 출력 = 48

		//손실분 생기지만 형변환 완료
		
	}
}

