package com.test.java.question.iteration;

public class Q07_while {

	public static void main(String[] args) {
		
		int sum = 0;
		int num = 1;
		
		boolean loop = true;
		while (loop) {
			
			sum += num;
			
			if (sum >= 1000) {
				System.out.printf("%d = ", num);
				loop = false;
				
			} else {
				System.out.printf("%d + ", num);
				num++;
			}	
		}
		System.out.println(sum);

	
	} //main
}
