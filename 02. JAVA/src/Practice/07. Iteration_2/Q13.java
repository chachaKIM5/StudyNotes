package com.test.java.question.iteration2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q13 {

	public static void main(String[] args) throws Exception {
		
		
	/*
	 
	  문제: 숫자 2개 입력받아 각각의 약수와 공약수 구하기
	  프로세스
	  1. 메소드 2개 만들어 풀기(	(1)입력한 숫자의 약수 구하는 메소드
	             		 	(2)입력한 두 숫자의 공약수 구하는 메소드)
	  2. (2)에서는 둘 중 큰 숫자가 첫번째인지 두번째인지 주의하기 
	  
	 */
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("첫번째 숫자: ");
		int num1 = Integer.parseInt(reader.readLine());
		
		System.out.print("두번째 숫자: ");
		int num2 = Integer.parseInt(reader.readLine());
		
		String listNum1 = "";
		String listNum2 = "";
		String listCommon = "";

		
		
		listNum1 = getList(num1);
		listNum2 = getList(num2);
		
		listCommon = getCommon(num1, num2);
		
		System.out.printf("%d의 약수: %s\b\b\n", num1, listNum1);
		System.out.printf("%d의 약수: %s\b\b\n", num2, listNum2);
		System.out.printf("%d와 %d의 공약수: %s\b\b", num1, num2, listCommon);
	
	}

	public static String getCommon(int num1, int num2) {
		
		String listCommon = "";

		if (num1 <= num2) {
			for (int j=1 ; j<=num1 ; j++) {
				if (num1 % j == 0 && num2 % j == 0) {
					listCommon += j + ", ";
				}
			}
		} else {
			for (int k=1 ; k<=num2 ; k++) {
				if (num2 % k == 0 && num1 % k == 0) {
					listCommon += k + ", ";
				}
			}
		} return listCommon;
	}

	public static String getList(int num) {
		
		String listNum = "";
		
		for (int i=1 ; i<=num ; i++) {
			if (num % i == 0) {
				listNum += i + ", ";
			}
		} return listNum;	
	} 
}


/*
 
 풀었는데 짧은데 복잡하다..!
 
 			for (int i=1 ; i<=num1 ; i++) {
						
				listNum2 = "";
				
				if (num1 % i == 0) {
					listNum1 += i + ", ";
					
					for (int j=1 ; j<=num2 ; j++) {

						if (num2 % j == 0) {
							listNum2 += j + ", ";

							if (i == j) {
								listCommon += i + ", ";
								
							}
						}						
					}			
				}
			}
*/
