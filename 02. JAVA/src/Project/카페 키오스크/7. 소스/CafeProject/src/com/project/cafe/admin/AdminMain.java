package com.project.cafe.admin;

import java.util.Calendar;
import java.util.Scanner;
import com.project.cafe.order.CartOrder;

public class AdminMain {

	public void main() {

		
		String input = null; 
		boolean error = false;
		boolean loop = true;
		
		while(loop) {
			
			printMenu();
			
			Scanner scan = new Scanner(System.in);
			System.out.println();
			
			if(error) {
				System.out.println(input);
				error = false;
			}
			
			System.out.println();
			System.out.print("Select ▶ ");

			input = scan.nextLine();
		
			
		
			if(input.equals("1")) {//TODO 메뉴관리
				
//				SetMenu m = new SetMenu();
//				m.main();
				
			} else if (input.equals("2")) {//TODO 품절관리
				
//				SoldoutMenu o = new SoldoutMenu();
//				o.main();
				
			} else if (input.equals("3")) { //TODO 판매통계
				
				SalesStats s = new SalesStats();
				s.main();
				
			} else if (input.equals("4")) { //TODO 암호변경
				
//				ResetPW r = new ResetPW();
//				r.main();
			
			} else if (input.equals("0")) {
			
				loop = false; //메인화면으로
			} else {
				input = "⚠️ " + input + "은(는) 잘못된 접근입니다.";
				error = true;
			}
				
		}
	}
	
	
	/**
	 * 관리자 모드의 메뉴화면을 출력하는 메소드입니다.
	 */
	private static void printMenu() {
		
		System.out.println("┌───────────────────────────────────────────────────┐");
		
		Calendar now = Calendar.getInstance();
		System.out.print("\t\t\t");
		System.out.printf("%tF %s:%s %tA [*.종료]\n", 
							now, now.get(Calendar.HOUR_OF_DAY),now.get(Calendar.MINUTE), now);
		System.out.println();
	
		
		System.out.println("\r\n"
				+ "\t  ______    ______   ________  ________ \r\n"
				+ "\t /      \\  /      \\ /        |/        |\r\n"
				+ "\t/$$$$$$  |/$$$$$$  |$$$$$$$$/ $$$$$$$$/ \r\n"
				+ "\t \r\n"
				+ "\t$$ |          관리자 모드 입니다      $$    |   \r\n"
				+ "\t\r\n"
				+ "\t$$ \\__/  |$$ |  $$ |$$ |      $$ |_____ \r\n"
				+ "\t$$    $$/ $$ |  $$ |$$ |      $$       |\r\n"
				+ "\t $$$$$$/  $$/   $$/ $$/       $$$$$$$$/ \r\n"
				+ "");
		System.out.println();
		System.out.println();
		System.out.println("\t1. 메뉴관리");
		System.out.println();
		System.out.println("\t2. 품절관리");
		System.out.println();
		System.out.println("\t3. 판매통계");
		System.out.println();
		System.out.println("\t4. 암호변경🔒");
		System.out.println();
		System.out.println("\t0. 메인화면");
		System.out.println();
		System.out.println("└───────────────────────────────────────────────────┘");
		
	}

}
