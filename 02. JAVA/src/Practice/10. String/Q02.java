package com.test.java.question.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q02 {
	
	public static void main(String[] args) throws Exception {
	
	//아이디와 도메인 분리
	//substring 과 split 둘 다 풀어 보기

				
		substring();
		//split();

		
		
	}

	private static void substring() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("이메일: ");
		String email = reader.readLine();
		
		System.out.println("아이디: " + email.substring(0, email.indexOf("@")));
		System.out.println("도메인: " + email.substring(email.indexOf("@")+1));
		
		
	}

	private static void split() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("이메일: ");
		String email = reader.readLine();
		
		System.out.println("아이디: " + email.split("@")[0]);
		System.out.println("도메인: " + email.split("@")[1]);
	}
}
