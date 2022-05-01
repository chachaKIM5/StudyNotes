package com.project.cafe.order;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		
		if (test().equals("1")) {
			System.out.println("1 호출 성공");
		}
		
		
	}
	
	
	public static String test() {
		
		
		Scanner scan = new Scanner(System.in);
		System.out.print("값을 입력하세요.");
		String input = scan.nextLine();
		
		return input;
		
	}
}
