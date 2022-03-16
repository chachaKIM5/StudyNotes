package com.test.java;

public class Item27 {
	
	public static void main(String[] args) {
		
		//[SUMMARY] break, continue (2022. 3. 16. 오후 11:19:07)

	
		//무한 루프에서 break로 탈출
		
			for (int i=0; true; i++) {
				System.out.println(i);
				
				if (i>100000) {
					break;
				}
			}
			
			
		//루프 중간에서 break로 탈출
			for (int i=1 ; i<=10 ; i++) {
				System.out.println(i);
				
				if (i == 5) {
					break;
				}
			}
			
		//루프 중간에 continue로 이번만 실행하지 않고 처음으로 돌아가기 (예외)
			for (int i=1; i<=10; i++) {
				
				if (i == 5) {
					continue; 
				}
					
				System.out.println(i);
			}
		
		
		//break는 for문 밖으로 탈출, continue는 다시 for문으로 돌아간다
			
	}
}
