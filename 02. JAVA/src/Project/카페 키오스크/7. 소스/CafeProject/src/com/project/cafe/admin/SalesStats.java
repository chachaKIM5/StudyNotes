package com.project.cafe.admin;

import java.util.Calendar;
import java.util.Scanner;
import com.project.cafe.MenuCategory;
import com.project.cafe.Output;

public class SalesStats {
	
	public static String inputDate;
	public static String inputCate;
	public static Calendar[] dateList = new Calendar[8];

	public static void main() {
		
		chooseStatsDate();
		chooseStatsCate();
		printStats();
	}

	private static void chooseStatsDate() {

		boolean loop = true;
		
		while (loop) {
			
			MenuCategory.printStart();
			System.out.println();
			
			printLetter();
			
			System.out.println();
			Calendar now = Calendar.getInstance();
			System.out.printf("\r\n\r\n\t    오늘은 %d년 %d월 %d일 %s요일입니다.\r\n\r\n"
								, now.get(Calendar.YEAR)
								, now.get(Calendar.MONTH) + 1
								, now.get(Calendar.DAY_OF_MONTH)
								, getDayOfWeek(now.get(Calendar.DAY_OF_WEEK)));
			
			System.out.println("  •·············································•");
			
			
			//Calendar now를 현재와 가장 가까운 과거의 일요일로 설정하기 (오늘 제외 = do while문)
			do {
				now.add(Calendar.DATE, -1);
			} while (now.get(Calendar.DAY_OF_WEEK) != 1);
			
			System.out.println();
			System.out.println("\t\t<판매 통계 조회 기간 선택>\r\n");
			
			for (int i=7 ; i>=0 ; i--) {
				dateList[i] = Calendar.getInstance();
				
				if (i == 7) {
					dateList[i].set(now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DATE));
				
				} else if (i % 2 == 0) {
					dateList[i].set(dateList[i+1].get(Calendar.YEAR), dateList[i+1].get(Calendar.MONTH), dateList[i+1].get(Calendar.DATE));
					dateList[i].add(Calendar.DATE, -6);
					
				} else {
					dateList[i].set(dateList[i+1].get(Calendar.YEAR), dateList[i+1].get(Calendar.MONTH), dateList[i+1].get(Calendar.DATE));
					dateList[i].add(Calendar.DATE, -1);
				}
			}
			
	
			int index = 1;
			for (int i=0 ; i<7 ; i+=2) {
				
				System.out.printf("      [%d] %tF(%tA) ~ %tF(%tA)\r\n\r\n"
										, index, dateList[i], dateList[i], dateList[i+1], dateList[i+1]);
				index++;
			}
			
			System.out.println();
			Output.toolEnd();

			Scanner scan = new Scanner(System.in);
			System.out.print("\r\n통계 결과를 조회할 기간을 선택해 주세요. : ");
			inputDate = scan.nextLine();
			
			if (inputDate.equals("1") || inputDate.equals("2") ||
				inputDate.equals("2") || inputDate.equals("3")) {
				
				loop = false;
			
			} else {
				
				System.out.println("올바른 번호를 선택해 주세요. (1~4): ");
			}
		}
	}

	private static String getDayOfWeek(int i) {
		
		switch (i) {
			case 1: return "일";
			case 2: return "월";
			case 3: return "화";
			case 4: return "수";
			case 5: return "목";
			case 6: return "금";
			case 7: return "토";
		}
		
		return null;
		
	}

	private static void chooseStatsCate() {
		// TODO Auto-generated method stub
		
	}

	private static void printStats() {
		// TODO Auto-generated method stub
		
	}
	
	private static void printLetter() {
		
		System.out.println("   ____        __                 __              \r\n"
				+ "  /\\  _`\\     /\\ \\__             /\\ \\__           \r\n"
				+ "  \\ \\,\\L\\_\\   \\ \\ ,_\\     __     \\ \\ ,_\\    ____  \r\n"
				+ "   \\/_\\__ \\    \\ \\ \\/   /'__`\\    \\ \\ \\/   /',__\\ \r\n"
				+ "     /\\ \\L\\ \\   \\ \\ \\_ /\\ \\L\\.\\_   \\ \\ \\_ /\\__, `\\\r\n"
				+ "     \\ `\\____\\   \\ \\__\\\\ \\__/.\\_\\   \\ \\__\\\\/\\____/\r\n"
				+ "      \\/_____/    \\/__/ \\/__/\\/_/    \\/__/ \\/___/ ");
		
	}
}
