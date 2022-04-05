package com.test.java.question.FileIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class Q04 {

	private static HashMap<String, String> map = new HashMap<String, String>();
	
	public static void main(String[] args) {
	
		//이름을 입력받아 회원 정보를 검색 후 출력하시오.
		//C:\class\java\파일_입출력_문제\단일검색.dat
		//중복인 이름: 박돈게, 홍유길 등등.. 모두 출력되게 하자
		
		try {
			
			Scanner scan = new Scanner(System.in);
			System.out.print("이름: ");
			
			String name = scan.nextLine();
			String line = null;
			
			File file = new File("C:\\class\\java\\파일_입출력_문제\\단일검색.dat");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			
			while ((line = reader.readLine()) != null) {
				if (line.contains(name)) {
					getData(line);
					
					System.out.printf("\n[%s]\n", name);
					System.out.printf("번호: %s\n", map.get("번호"));
					System.out.printf("주소: %s\n", map.get("주소"));
					System.out.printf("전화:%s\n", map.get("전화"));
				}				
			}
			
			reader.close();
			scan.close();

			
		} catch (Exception e) {
			System.out.println("Q04.main");
			e.printStackTrace();
		}

		
		
	}

	private static void getData(String line) {

		String[] data = line.split(",");
		
		map.put("번호", data[data.length - 4]);
		map.put("주소", data[data.length - 2]);
		map.put("전화", data[data.length - 1]);
		
	}
}
