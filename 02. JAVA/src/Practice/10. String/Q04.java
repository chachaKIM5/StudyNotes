package com.test.java.question.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q04 {

	public static void main(String[] args) throws Exception {
		
		//파일 이름 10개 -> 확장자별로 몇개인지
		//목록에 없는 확장자는 카운팅 X, 확장자는 총 5개로 제한
		//대소문자 구분없이 카운팅
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		
		int[] sum = new int[5];
		String[] extension = { "MP3", "JPG", "JAVA", "HWP", "DOC" };

		
		String[] files = new String[10];
		
		for (int i=0 ; i<10 ; i++) {
			System.out.print("파일명: ");
			files[i] = reader.readLine();
		}
		
		
		for (int i=0 ; i<10 ; i++) {
			for (int j=0 ; j<5 ; j++) {
				
				if (files[i].toUpperCase().endsWith(extension[j])) {
					sum[j]++;
				}
			}
		}

		System.out.println();
		System.out.println("mp3: " + sum[0] + "개");
		System.out.println("jpg: " + sum[1] + "개");
		System.out.println("java: " + sum[2] + "개");
		System.out.println("hwp: " + sum[3] + "개");
		System.out.println("doc: " + sum[4] + "개");
	
	}
}
