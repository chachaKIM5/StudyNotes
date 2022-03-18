package com.test.java;

public class Item30 {

	public static void main(String[] args) {
		
		//[SUMMARY] 다중for문, 별찍기 (2022. 3. 18. 오후 8:06:34)


			
		//별찍기!
		//TODO 다중for문(별찍기) 완전히 이해할 때까지 공부
		
		for (int i=0 ; i<5 ; i++) { 		//행 만들기
			for (int j=0 ; j<5 ; j++) {		// 열 만들기
				
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();

			
		for (int i=0 ; i<5 ; i++) {			//행(변화X)
			for (int j=i ; j<5 ; j++) {		//열(변화 O, 5 -> 1)
				
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
			
			
		for (int i=0 ; i<5 ; i++) { 		//행 만들기
			for (int j=0 ; j<=i ; j++) {	//열 (1 -> 5)
				
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
			
			
		for (int i=0 ; i<5 ; i++) {
				
			for (int j=0 ; j<(4-i) ; j++) {
				System.out.print(" ");
			}
				
			//행 만들기
			for (int j=0 ; j<=i ; j++) {		// 열 만들기
					
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
			
	} //main
		
	
}
