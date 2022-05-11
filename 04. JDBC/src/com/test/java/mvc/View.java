package com.test.java.mvc;

import java.util.ArrayList;

public class View {

	public void menu() {

		System.out.println("====================");
		System.out.println("주소록 관리");		
		System.out.println("====================");
		System.out.println("1. 등록하기");
		System.out.println("2. 목록보기");
		System.out.println("3. 수정하기");
		System.out.println("4. 삭제하기");
		System.out.println("0. 돌아가기");
		
		System.out.print("선택: ");
		
	}

	public void list(ArrayList<Address> list) {

		//ArrayList<Address> list를 받아 출력해주는 메소드
		
		System.out.println("====================");
		System.out.println("주소록 목록 보기");		
		System.out.println("====================");
		System.out.println();
		
		System.out.println("[번호]\t[이름]\t[나이]\t[성별]\t[연락처]\t\t[등록일]\t\t[주소]");
	
		for (Address dto : list) {
			System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\t%s\r\n"
									, dto.getSeq()
									, dto.getName()
									, dto.getAge()
									, dto.getGender().equals("m") ? "남자" : "여자"
									, dto.getTel()
									, dto.getRegdate().substring(0, 10)
									, dto.getAddress());
			
		}
	}

	
}
