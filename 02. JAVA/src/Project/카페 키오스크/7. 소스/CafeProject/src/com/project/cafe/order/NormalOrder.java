package com.project.cafe.order;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import com.project.cafe.Data;
import com.project.cafe.FindData;
import com.project.cafe.MenuCategory;
import com.project.cafe.Output;
import com.project.cafe.dataClass.Cart;
import com.project.cafe.dataClass.CustomMenu;
import com.project.cafe.dataClass.Customer;
import com.project.cafe.Main;

public class NormalOrder extends Payment {
	public static boolean loop; 
	public static Cart currentMenu;
	public static String[] option = {"얼음량", "시럽", "샷추가", "휘핑", "토핑"};
	public static String inputIce, inputSyrup, inputShot, inputWhipping, inputTopping;
	//cart(장바구니번호, 메뉴번호, 얼음량옵션번호, 시럽옵션번호, 샷추가옵션번호, 휘핑크림옵션번호, 토핑추가옵션번호)
	
	//생성자로 currentMenu의 기본값 설정, 얼음량 기본값만 2 = 보통
	public NormalOrder() {
		loop = true;
		currentMenu = new Cart(null, "0", "2", "0", "0", "0", "0");
	}
	
	//핫 메뉴 얼음량 선택시 경고 메시지 선택 후 다시 입력하게 하기
	//각종 유효성검사 추가
	public static void work() {
	

		//BestMenu는 추후에...추가 어떤식으로 추가해야할지 모르겠다 ㅜ
		new NormalOrder();
		//while (loop) {			
			
			MenuCategory.printBestMenuCategory();
			
			if (MenuCategory.chosenCategory.equals("*")) { //장바구니 선택 시 메뉴선택과정 메소드 실행되지 못하도록
				loop = false;
				//continue;
				
			} else if (MenuCategory.chosenCategory.equals("1") || MenuCategory.chosenCategory.equals("2")
					 || MenuCategory.chosenCategory.equals("2") || MenuCategory.chosenCategory.equals("4")
					 || MenuCategory.chosenCategory.equals("5")) {
				//BestMenu 선택 시(12345)
				//bestMenu 메소드 만들면 연결
				
			} else { //ABCDEabcde 선택 시
			CategoryTrans();
			findMenu(MenuCategory.chosenCategory, MenuCategory.chosenMenu);
			addOption();
			saveOption();
			addCart();
			
			loop = false;
			
			}
		//}
			
	}
	

	private static void CategoryTrans() {
		
		switch (MenuCategory.chosenCategory) {
			case "A": case "a":
				MenuCategory.chosenCategory = "1"; break;
			case "B": case "b":
				MenuCategory.chosenCategory = "2"; break;
			case "C": case "c":
				MenuCategory.chosenCategory = "3"; break;
			case "D": case "d":
				MenuCategory.chosenCategory = "4"; break;
			case "E": case "e":
				MenuCategory.chosenCategory = "5"; break;
		}
	}
	private static void findMenu(String category, String menu) {
		
		//Cart currentMenu = 지금 현재 고르는 중인 메뉴의 속성을 임시저장할 카트 객체.
		//매개변수 = 사용자가 MenuCategory.java에서 입력한 카테고리 번호 및 메뉴 번호 (MenuCategory.java에 static 변수 추가함)
		//커피 1번 = 메뉴.txt 1번
		//음료 1번 = 메뉴.txt 13번
		//티 1번 = 메뉴.txt 23번...
		//사용자가 입력한 번호에 따라 메뉴.txt에서 음료번호를 찾은 후에 currentMenu의 MenuSeq에 넣어주는 메소드

		int temp = 0;
		
		for (int i=0 ; i<Data.mlist.size() ; i++) {
			if (Data.mlist.get(i).getCseq().equals(category)) {
				temp = i;
				break;
			}
		}
		
		System.out.println(temp);
		String menuResult = String.valueOf(temp + Integer.parseInt(menu)); 
		currentMenu.setMenuSeq(menuResult);
	}
	
	
	private static void addOption() {
		//currentMenu 객체에 얼음량, 시럽, 샷추가, 휘핑, 토핑 옵션을 사용자 선택으로 update
		
		chooseOption("얼음량");
		chooseOption("시럽");
		chooseOption("샷추가");
		chooseOption("휘핑");
		chooseOption("토핑");
		
	}

	private static void chooseOption(String optionName) {
		
		printLetter();
		
		
		if (optionName.equals(option[0])) {
			for (int i=0 ; i<option.length ; i++) {
				System.out.println(printOption(option[i]));
			}
		} else if (optionName.equals(option[1])) {
			System.out.println(printResult(option[0]));
			for (int i=1 ; i<option.length ; i++) {
				System.out.println(printOption(option[i]));
			}
		} else if (optionName.equals(option[2])) {
			for (int i=0 ; i<2 ; i++) {
				System.out.println(printResult(option[i]));
			}
			for (int i=2 ; i<option.length ; i++) {
				System.out.println(printOption(option[i]));
			}
		} else if (optionName.equals(option[3])) {
			for (int i=0 ; i<3 ; i++) {
				System.out.println(printResult(option[i]));
			}
			for (int i=3 ; i<option.length ; i++) {
				System.out.println(printOption(option[i]));
			}
		} else if (optionName.equals(option[4])) {
			for (int i=0 ; i<4 ; i++) {
				System.out.println(printResult(option[i]));
			}
			System.out.println(printOption(option[4]));
		}

		Scanner scan = new Scanner(System.in);
		
		System.out.println();
		Output.toolEnd();
		System.out.println();
		System.out.printf("   %s 옵션 번호를 입력하세요.: ", optionName);
		
		if (optionName.equals(option[0])) {
			inputIce = scan.nextLine();
			currentMenu.setIceSeq(inputIce);
			
		} else if (optionName.equals(option[1])) {
			inputSyrup = scan.nextLine();
			currentMenu.setSyrupSeq(inputSyrup);
			
		} else if (optionName.equals(option[2])) {
			inputShot = scan.nextLine(); 
			currentMenu.setShotSeq(inputShot);
			
		} else if (optionName.equals(option[3])) {
			inputWhipping = scan.nextLine(); 
			currentMenu.setWhippingSeq(inputWhipping);
			
		} else if (optionName.equals(option[4])) {
			inputTopping = scan.nextLine();
			currentMenu.setToppingSeq(inputTopping);
		}
	
	}
	
	
	private static String printOption(String option) {
		//얼음량, 시럽, 샷추가... arraylist에서 옵션명 및 가격 뽑아와서 출력하려 했으나 예쁘게 정렬이 어렵다...!
		
		if (option.equals("얼음량")) {
			return String.format("\t\t 얼음량 (기본값: 보통)\r\n\t     ０ 없음, １ 적게, ２ 보통, ３ 많이"
								  + "\r\n   •·············································•");
			
		} else if (option.equals("시럽")) {
			return String.format("\t     시럽 추가 (500원, 기본값: 없음)\r\n    ０ 없음, １ 설탕(무료), ２ 바닐라, ３ 헤이즐넛, ４ 카라멜"
								  + "\r\n   •·············································•");
			
		} else if (option.equals("샷추가")) {
			return String.format("\t   샷 추가 (1샷 당 500원, 기본값: 없음)\r\n      ０ 없음, １ 1샷, ２ 2샷, ３ 3샷, ４ 4샷, ５ 5샷\r\n\t      ６ 6샷, ７ 7샷, ８ 8샷, ９ 9샷"
								  + "\r\n   •·············································•");
			
		} else if (option.equals("휘핑")) {
			return String.format("\t   휘핑크림 추가 (500원, 기본값: 없음)\r\n\t ０ 없음, １ 일반 휘핑, ２ 에스프레소 휘핑"
								  + "\r\n   •·············································•");
			
		} else if (option.equals("토핑")) {
			return String.format("\t    토핑 추가 (500원, 기본값: 없음)\r\n       ０ 없음, １ 타피오카펄, ２ 알로에펄, ３ 코코넛펄"
								  + "\r\n   •·············································•");	
		
		} else {
			return "";
		}
		
		
	}
		
		
	
	private static String printResult(String option) {
		
		String[] num = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		String[] numTemp = { "０", "１", "２", "３", "４", "５", "６", "７", "８", "９" };
		String replace = "";
		


		if (option.equals("얼음량")) {
			for (int i=0 ; i<num.length ; i++) {
				if (num[i].equals(inputIce)) {
					replace = numTemp[i];
				}
			}
			return String.format("\t\t 얼음량 (기본값: 보통)\r\n\t     ０ 없음, １ 적게, ２ 보통, ３ 많이"
					+ "\r\n   •·············································•").replace(replace, "☑");
			
		} else if (option.equals("시럽")) {
			for (int i=0 ; i<num.length ; i++) {
				if (num[i].equals(inputSyrup)) {
					replace = numTemp[i];
				}
			}
			return String.format("\t     시럽 추가 (500원, 기본값: 없음)\r\n    ０ 없음, １ 설탕(무료), ２ 바닐라, ３ 헤이즐넛, ４ 카라멜"
								  + "\r\n   •·············································•").replace(replace, "☑");
			
		} else if (option.equals("샷추가")) {
			for (int i=0 ; i<num.length ; i++) {
				if (num[i].equals(inputShot)) {
					replace = numTemp[i];
				}
			}
			return String.format("\t   샷 추가 (1샷 당 500원, 기본값: 없음)\r\n      ０ 없음, １ 1샷, ２ 2샷, ３ 3샷, ４ 4샷, ５ 5샷\r\n\t      ６ 6샷, ７ 7샷, ８ 8샷, ９ 9샷"
								  + "\r\n   •·············································•").replace(replace, "☑");
			
		} else if (option.equals("휘핑")) {
			for (int i=0 ; i<num.length ; i++) {
				if (num[i].equals(inputWhipping)) {
					replace = numTemp[i];
				}
			}
			return String.format("\t   휘핑크림 추가 (500원, 기본값: 없음)\r\n\t ０ 없음, １ 일반 휘핑, ２ 에스프레소 휘핑"
								  + "\r\n   •·············································•").replace(replace, "☑");
			
		} else if (option.equals("토핑")) {
			for (int i=0 ; i<num.length ; i++) {
				if (num[i].equals(inputTopping)) {
					replace = numTemp[i];
				}
			}
			return String.format("\t    토핑 추가 (500원, 기본값: 없음)\r\n       ０ 없음, １ 타피오카펄, ２ 알로에펄, ３ 코코넛펄"
								  + "\r\n   •·············································•").replace(replace, "☑");	
		
		} else {
			return "";
		}
	}
	
	
	private static void saveOption() {
		
		boolean subLoop = true;
		while (subLoop) {
			
			printLetter();
			for (int i=0 ; i<option.length ; i++) {
				System.out.println(printResult(option[i]));
			}
			Output.toolEnd();
			System.out.print("\r\n커스텀 메뉴에 위 옵션을 저장하시겠습니까?(Y/N) : ");
			Scanner scan = new Scanner(System.in);
			String answer = scan.nextLine();
			
			if (answer.equals("Y") || answer.equals("y")) {
	
				boolean subsubLoop = true;
				while (subsubLoop) {
					
					printLetter();
					for (int i=0 ; i<option.length ; i++) {
						System.out.println(printResult(option[i]));
					}
					Output.toolEnd();
					
					System.out.print("\r\n휴대폰 번호를 입력해 주세요. (010-XXXX-XXXX) : ");
					String tel = scan.nextLine();
					if (Main.customerLogin(tel)) {
						CustomMenu m = new CustomMenu(findMaxSeq_cmlist(), Main.currentLogin.getSeq(),
													  currentMenu.getMenuSeq(),
													  inputIce, inputSyrup, inputShot, inputWhipping, inputTopping);
						//커스텀메뉴번호,고객번호,메뉴번호,얼음량번호,시럽번호,샷추가번호,휘핑번호,토핑번호
						Data.cmlist.add(m);
						System.out.printf("[%s](이)가 커스텀 메뉴에 저장되었습니다. ([Enter]: 다음으로)\r\n", FindData.findMenu(currentMenu.getMenuSeq()).getName());
						scan.nextLine();
						subLoop = false;
						subsubLoop = false;
					} else {
						System.out.print("올바른 형식으로 다시 입력해 주세요. ([Enter]: 계속)");
						scan.nextLine();
					};
					
				}
			} else if (answer.equals("N") || answer.equals("n")) {
				subLoop = false;
			} else {
				System.out.println("\"Y\" 혹은 \"N\" 형식으로 입력해 주세요.");
			}
		}
		
	}
	
	public static void addCart() {
		//CartOrder.addToCart와 연결해 currentMenu를 장바구니에 추가하는 메소드
		
		boolean subloop = true;
		
		while (subloop) {
			
			printLetter();
			for (int i=0 ; i<option.length ; i++) {
				System.out.println(printResult(option[i]));
			}
			Output.toolEnd();
			
			System.out.print("\r\n장바구니에 위 메뉴를 담으시겠습니까? (Y/N) : ");
			Scanner scan = new Scanner(System.in);
			String answer = scan.nextLine();
			
			if (answer.equals("Y") || answer.equals("y")) {
				int max = 0;
				
				for(Cart c : CartOrder.cart) {
					if(Integer.parseInt(c.getSeq()) > max) { 
						max = Integer.parseInt(c.getSeq());
					}
				}
				
				String CartSeq = "" + (max + 1);
				currentMenu.setSeq(CartSeq);
				
				if (CartOrder.addToCart(currentMenu)) {
					System.out.printf("[%s](이)가 장바구니에 저장되었습니다. ([Enter]: 초기화면)\r\n", FindData.findMenu(currentMenu.getMenuSeq()).getName());
					scan.nextLine();
					subloop = false;				
					
				} else {
					System.out.printf("장바구니가 가득 찼습니다. ([Enter]: 초기화면)");
					scan.nextLine();
					subloop = false;
				};
				
				

				
			} else if (answer.equals("N") || answer.equals("n")) {
				System.out.println("취소되었습니다. ([Enter]: 초기화면)");
				scan.nextLine();
				subloop = false;
				
			} else {
				System.out.println("\"Y\" 혹은 \"N\" 형식으로 입력해 주세요.");
			}
			
		}
		

	}
	


	private static String findMaxSeq_cmlist() {
	      int max = 0;
	      
	      for(CustomMenu c : Data.cmlist) {
	         if(Integer.parseInt(c.getSeq()) > max) { 
	            max = Integer.parseInt(c.getSeq());
	         }
	      }
	      return "" + (max + 1);
				
	}
	
	private static void printLetter() {
		
		MenuCategory.printStart();
		System.out.println();
		System.out.println("\t     _   ___  ___  _   _   _  _ \r\n" 
				+ "\t    / \\ | o \\|_ _|| | / \\ | \\| |\r\n"
				+ "\t   ( o )|  _/ | | | |( o )| \\\\ |\r\n"
				+ "\t    \\_/ |_|   |_| |_| \\_/ |_|\\_|");
		System.out.printf("\r\n\t\t  [%s]", FindData.findMenu(currentMenu.getMenuSeq()).getName());
		System.out.println("\r\n   •·············································•");
	}
}