package com.test.java;

public class Item28 {

	public static void main(String[] args) {
		
	//[SUMMARY] 난수(랜덤) 생성 Math.random() (2022. 3. 16. 오후 11:30:38)

	/*
	 
	 난수 생성 공식: (int)(Math.random() * B) + A
	 최솟값: A
	 최댓값: A+B-1
	 
	 */
		
	int n1 = (int)(Math.random() * 7); 		// 0에서 6 사이의 난수를 생성한다
	int n2 = (int)(Math.random() * 7) + 2; 	// 2에서 8 사이의 난수를 생성한다
	
	System.out.println(n1);
	System.out.println(n2);
	
	}
}
