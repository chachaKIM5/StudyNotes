package com.test.java.question.FileIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Q05 {
	
	private static ArrayList<Person> list = new ArrayList<Person>();
	
	public static void main(String[] args) {
		
		//검색_주문의 마지막 번호가 검색_회원 첫 번째의 회원번호
		//7,키보드,14,2  //2,황길돈,서울시 중구 다동
		//황길돈은 키보드를 14개 시킨 사람
		//test: 길게무(많이 삼), 하재명(동명이인), 황명석(구매내역 없음)
		
		try {
			
			File member = new File("C:\\class\\java\\파일_입출력_문제\\검색_회원.dat");
			
			BufferedReader reader = new BufferedReader(new FileReader(member));

			
			Scanner scan = new Scanner(System.in);
			System.out.print("이름: ");
			String inputName = scan.next();
			String line = null;
			
			
			while ((line = reader.readLine()) != null) {
				
				if (line.contains(inputName)) {
					String[] data = line.split(",");
					addList(data);
				}
			}
			
	
				
			reader.close();
			scan.close();
			

			
			if (list.size() == 0) {
				System.out.println("구매 내역이 없습니다.");
			} else {
				System.out.println("==== 구매내역 ====");
				System.out.println("[번호]\t[이름]\t[상품명]\t[개수]\t[배송지]");

				for (int i=0 ; i<list.size() ; i++) {
					System.out.println(list.get(i));
				}
			}
			
		} catch (Exception e) {
			System.out.println("Q05.main");
			e.printStackTrace();
		}
		
		
		
		
	} 
	
	
	public static void addList(String[] data) {
	

		try {

			
			File order = new File("C:\\class\\java\\파일_입출력_문제\\검색_주문.dat");
			BufferedReader reader = new BufferedReader(new FileReader(order));
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				if (line.endsWith(data[0])) {
					String[] dataResult = line.split(",");
					list.add(new Person(data[0], data[1], data[2], dataResult[1], dataResult[2]));
				}
			}
		
			reader.close();
			
			
		} catch (Exception e) {
			System.out.println("Q05.addList");
			e.printStackTrace();
		}	
		
	}
	
	

	
	
}


class Person {
	
	private String num;
	private String name;
	private String adress;
	private String product;
	private String count;
	
	public Person(String num, String name, String adress, String product, String count) { 
		
		this.num = num;
		this.name = name;
		this.adress = adress;
		this.product = product;
		this.count = count;
	}
	
	public String getNum() {
		return num;
	}
	public String getName() {
		return name;
	}
	public String getProduct() {
		return product;
	}
	public String getCount() {
		return count;
	}
	public String getAdress() {
		return adress;
	}

	@Override
	public String toString() {
		return String.format("%4s\t%s\t %s\t%4s\t%s", this.num
												   , this.name
												   , this.product
												   , this.count
												   , this.adress);
	}
	
	


}