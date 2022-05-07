package com.project.cafe.order;

import java.util.Scanner;
import com.project.cafe.Data;
import com.project.cafe.FindData;
import com.project.cafe.Main;
import com.project.cafe.MenuCategory;
import com.project.cafe.Output;
import com.project.cafe.dataClass.CustomMenu;


public class FastOrder extends Payment {
//
//	for(CustomMenu cm : cmlist) {
//		String line = String.format("%s,%s,%s,%s,%s,%s,%s,%s\n"
//									,cm.getSeq()
//									,cm.getClientSeq()
//									,cm.getMenuSeq()
//									,cm.getIceSeq()
//									,cm.getSyrupSeq()
//									,cm.getShotSeq()
//									,cm.getWhippingSeq()
//									,cm.getToppingSeq());

	public static void work() {
		
		boolean loop = true;
		
		while (loop) {
			
			Scanner scan = new Scanner(System.in);
			printLetter();
			
			
			if (Main.currentLogin == null) {
				
				Output.toolEnd();
				System.out.print("\r\n휴대폰 번호를 입력해 주세요. (010-XXXX-XXXX) : ");
				String input = scan.nextLine();
				Main.customerLogin(input);
				
			}
			
			
			loadCustomMenu();
	
		}
		

	
	}
	
	
	
	private static void loadCustomMenu() {
	// cmlist(커스텀메뉴 arraylist)에서 currenetLogin에 저장된 고객의 커스텀 메뉴를 검색, 불러오는 메소드
		
		
		int index = 1;
		for (int i=0 ; i<Data.cmlist.size() ; i++) {
			
			if (i == 0) {
				System.out.printf("-----[%s] 님의 커스텀 메뉴 LIST-----", Main.currentLogin.getTel());
			}
			
			if (Data.cmlist.get(i).getSeq().equals(Main.currentLogin.getSeq())) {
				System.out.printf("[%d] printf로 커스텀 메뉴 정보 출력(추후 매끄럽게 수정)", index);
				index++;
			}
			
			if (i == Data.cmlist.size() - 1) {
				System.out.println("-------------------------------");
			}
		}
	
}



	private static void printLetter() {
		
		MenuCategory.printStart();
		System.out.println();
		System.out.println("\t ___             _     ___         _           \r\n"
				+ "| __> ___  ___ _| |_  | . | _ _  _| | ___  _ _ \r\n"
				+ "| _> <_> |<_-<  | |   | | || '_>/ . |/ ._>| '_>\r\n"
				+ "|_|  <___|/__/  |_|   `___'|_|  \\___|\\___.|_|  \r\n");
		
		String loginId = "";
		
		if (Main.currentLogin == null) {
			loginId = "로그인 정보가 없습니다.";
			
		} else {
			
			loginId = Main.currentLogin.getTel();
		}
		
		
		System.out.printf("\r\n\t\t  [LOGIN] %s", loginId);
		System.out.println("\r\n   •·············································•");
	}
	
}
