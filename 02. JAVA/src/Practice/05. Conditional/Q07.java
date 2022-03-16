package com.test.java.question.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q07 {

	public static void main(String[] args) throws Exception {
		
	/*
		 
	프로세스
	1. 입력받은 숫자가 짝수면 +1을 누적해 반환하는 메소드 1개 생성
	2. 메인 메소드에서 BufferedReader로 정수 5개 입력받기
	3. int input 1~5 = Integer.parseInt(reader.readLine())으로 입력받은 숫자 대입
	4. 홀수 개수 = 5 - 짝수 개수, if문 통해 짝수, 홀수 개수 및 차이 계산 후 출력
	 
	 */

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("숫자 입력: ");
		int input1 = Integer.parseInt(reader.readLine());
	
		System.out.print("숫자 입력: ");
		int input2 = Integer.parseInt(reader.readLine());
		
		System.out.print("숫자 입력: ");
		int input3 = Integer.parseInt(reader.readLine());
		
		System.out.print("숫자 입력: ");
		int input4 = Integer.parseInt(reader.readLine());
		
		System.out.print("숫자 입력: ");
		int input5 = Integer.parseInt(reader.readLine());
		
		int even = 0;
		
		even = getEven(input1, even);
		even = getEven(input2, even);
		even = getEven(input3, even);
		even = getEven(input4, even);
		even = getEven(input5, even);

		int odd = 5 - even;
		
		if (even > odd) {
			System.out.printf("짝수는 %d개 홀수는 %d개 입력했습니다.\n", even, odd);
			System.out.printf("짝수가 홀수보다 %d개 더 많습니다.\n", even - odd);

		} else {
			System.out.printf("짝수는 %d개 홀수는 %d개 입력했습니다.\n", even, odd);
			System.out.printf("홀수가 짝수보다 %d개 더 많습니다.\n", odd - even);
		}
		
	}//main
	
	
	public static int getEven(int input, int even) {
			
		
		if (input % 2 == 0) {
			even += 1;
		} 
		
	return even;

	
	} //getEven
}







//메소드 없이 푸는 방법


//if (input1 % 2 == 0) {
//	even += 1;
//} else { 
//		odd += 1;
//}
//
//if (input2 % 2 == 0) {
//	even += 1;
//} else {
//	odd += 1;
//}
//
//if (input3 % 2 == 0) {
//	even += 1;
//} else {
//	odd += 1;
//}
//
//if (input4 % 2 == 0) {
//	even += 1;
//} else {
//	odd += 1;
//}
//
//if (input5 % 2 == 0) {
//	even += 1;
//} else {
//	odd += 1;
//}
