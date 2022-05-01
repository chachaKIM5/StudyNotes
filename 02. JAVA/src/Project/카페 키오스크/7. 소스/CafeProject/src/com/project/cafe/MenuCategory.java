package com.project.cafe;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

import com.project.cafe.dataClass.Menu;
import com.project.cafe.dataClass.Order;
import com.project.cafe.order.CartOrder;

/**
 * 공통으로 쓰이는 카테고리, 메뉴들 출력하고 입력받는 클래스입니다.
 * 
 * @author 고수경
 *
 */
public class MenuCategory {
	
	public static String chosenCategory;
	public static String chosenMenu;
	
	/**
	 * 카테고리 종류 출력하고 카테고리 번호 입력 받는 메소드입니다.
	 */
	public static void printCategory() {
		Scanner scan = new Scanner(System.in);
		boolean error = false;
		boolean loop = true;

		while (loop) {

			startCategory();

			if (error) {
				System.out.println(chosenCategory);
				error = false;
			}

			System.out.print("Select▶");
			chosenCategory = scan.nextLine();

			if (chosenCategory.equals("1")) {
				printCoffee();
			} else if (chosenCategory.equals("2")) {
				printBeverage();
			} else if (chosenCategory.equals("3")) {
				printTea();
			} else if (chosenCategory.equals("4")) {
				printAde();
			} else if (chosenCategory.equals("5")) {
				printSmoothe();
			} else {
				chosenCategory = "⚠️ " + chosenCategory + "은(는) 잘못된 접근입니다.";
				error = true;
			}

		}

	}

	private static void printCoffee() {
		Scanner scan = new Scanner(System.in);
		int cnt = 0;
		String name = null;

		printStart();
		System.out.println(
				  "\t _____          __   __             \r\n" 
				+ "\t/  __ \\        / _| / _|            \r\n"
				+ "\t| /  \\/  ___  | |_ | |_   ___   ___ \r\n" 
				+ "\t| |     / _ \\ |  _||  _| / _ \\ / _ \\\r\n"
				+ "\t| \\__/\\| (_) || |  | |  |  __/|  __/\r\n" 
				+ "\t \\____/ \\___/ |_|  |_|   \\___| \\___|\n");
		System.out.println("-----------------------------------------------------\n");

		for (Menu m : Data.mlist) {

			if (m.getCseq().equals("1")) {
				cnt++;
				name = m.getName();

				if (cnt % 2 == 0) {

					System.out.printf("\t%d.%s\n\n", cnt, name);
					System.out.println();
				} else {
					if (name.length() < 14) {
						System.out.printf("    %d.%s\t", cnt, name);
					} else {
						System.out.printf("    %d.%s", cnt, name);
					}
				}

			}
		}

		Output.toolEnd();

		System.out.print("Select▶");
		chosenMenu = scan.nextLine();

	}

	private static void printBeverage() {
		Scanner scan = new Scanner(System.in);
		int cnt = 0;
		String name = null;
		printStart();
		System.out.println(" ______                                              \r\n"
				+ " | ___ \\                                             \r\n"
				+ " | |_/ /  ___ __   __  ___  _ __   __ _   __ _   ___ \r\n"
				+ " | ___ \\ / _ \\\\ \\ / / / _ \\| '__| / _` | / _` | / _ \\\r\n"
				+ " | |_/ /|  __/ \\ V / |  __/| |   | (_| || (_| ||  __/\r\n"
				+ " \\____/  \\___|  \\_/   \\___||_|    \\__,_| \\__, | \\___|\r\n"
				+ "                                         __/ |      \r\n"
				+ "                                        |___/   \n");

		System.out.println("-----------------------------------------------------\n");
		for (Menu m : Data.mlist) {

			if (m.getCseq().equals("2")) {
				cnt++;
				name = m.getName();

				if (cnt % 2 == 0) {

					System.out.printf("\t%d.%s\n\n", cnt, name);
					System.out.println();
				} else {
					if (name.length() < 10) {
						System.out.printf("          %d.%s\t", cnt, name);
					} else {
						System.out.printf("          %d.%s", cnt, name);
					}
				}

			}

		}

		Output.toolEnd();

		System.out.print("Select▶");
		chosenMenu = scan.nextLine();
	}

	private static void printTea() {

		Scanner scan = new Scanner(System.in);
		int cnt = 0;
		String name = null;
		printStart();
		System.out.println("" 
				+ "\t\t _____              \r\n" 
				+ "\t\t|_   _|             \r\n"
				+ "\t\t  | |    ___   __ _ \r\n" 
				+ "\t\t  | |   / _ \\ / _` |\r\n" 
				+ "\t\t  | |  |  __/| (_| |\r\n"
				+ "\t\t  \\_/   \\___| \\__,_|\r\n");

		System.out.println("-----------------------------------------------------\n");
		for (Menu m : Data.mlist) {

			if (m.getCseq().equals("3")) {
				cnt++;
				name = m.getName();

				if (cnt % 2 == 0) {

					System.out.printf("\t%d.%s\n\n", cnt, name);
					System.out.println();
				} else {
					if (name.length() < 11) {
						System.out.printf("       %d.%s  \t", cnt, name);
					} else {

						System.out.printf("       %d.%s  ", cnt, name);

					}
				}

			}

		}

		Output.toolEnd();

		System.out.print("Select▶");
		chosenMenu = scan.nextLine();
	}

	private static void printAde() {
		Scanner scan = new Scanner(System.in);
		int cnt = 0;
		String name = null;
		printStart();
		System.out.println("" 
				+ "\t\t  ___       _       \r\n" 
				+ "\t\t / _ \\     | |      \r\n"
				+ "\t\t/ /_\\ \\  __| |  ___ \r\n" 
				+ "\t\t|  _  | / _` | / _ \\\r\n" 
				+ "\t\t| | | || (_| ||  __/\r\n"
				+ "\t\t\\_| |_/ \\__,_| \\___|\r\n" + "");

		System.out.println("-----------------------------------------------------\n");
		for (Menu m : Data.mlist) {

			if (m.getCseq().equals("4")) {
				cnt++;
				name = m.getName();

				if (cnt % 2 == 0) {

					System.out.printf("\t%d.%s\n", cnt, name);
					System.out.println();
				} else {
					if (name.length() < 9) {
						System.out.printf("           %d.%s\t", cnt, name);
					} else {
						System.out.printf("           %d.%s", cnt, name);
					}
				}

			}

		}

		System.out.println("\n\n\n\n\n\n\n\n\n");
		Output.toolEnd();

		System.out.print("Select▶");
		chosenMenu = scan.nextLine();
	}

	private static void printSmoothe() {

		Scanner scan = new Scanner(System.in);
		int cnt = 0;
		String name = null;
		printStart();
		System.out.println("" + "  _____                           _    _           \r\n"
				+ " /  ___|                         | |  | |          \r\n"
				+ " \\ `--.  _ __ ___    ___    ___  | |_ | |__    ___ \r\n"
				+ "  `--. \\| '_ ` _ \\  / _ \\  / _ \\ | __|| '_ \\  / _ \\\r\n"
				+ " /\\__/ /| | | | | || (_) || (_) || |_ | | | ||  __/\r\n"
				+ " \\____/ |_| |_| |_| \\___/  \\___/  \\__||_| |_| \\___|\r\n"
				+ "                                                  \r\n" + "");

		System.out.println("-----------------------------------------------------\n");
		for (Menu m : Data.mlist) {

			if (m.getCseq().equals("5")) {
				cnt++;
				name = m.getName();

				if (cnt % 2 == 0) {

					System.out.printf("\t%d.%s\n\n", cnt, name);
					System.out.println();
				} else {
					if (name.length() < 9) {
						System.out.printf("         %d.%s\t", cnt, name);
					} else {
						System.out.printf("         %d.%s", cnt, name);
					}
				}

			}

		}

		System.out.println("\n\n\n\n\n\n\n");
		Output.toolEnd();

		System.out.print("Select▶");
		chosenMenu = scan.nextLine();

	}

	/**
	 * Best 메뉴 5개와 카테고리 종류 출력하고 선택할 번호 입력받는 메소드입니다.
	 */
	public static void printBestMenuCategory() {

		Scanner scan = new Scanner(System.in);
		printStart();

		System.out.println("   ___             _                                \r\n"
				+ "  / __\\  ___  ___ | |_    /\\/\\    ___  _ __   _   _ \r\n"
				+ " /__\\// / _ \\/ __|| __|  /    \\  / _ \\| '_ \\ | | | |\r\n"
				+ "/ \\/  \\|  __/\\__ \\| |_  / /\\/\\ \\|  __/| | | || |_| |\r\n"
				+ "\\_____/ \\___||___/ \\__| \\/    \\/ \\___||_| |_| \\__,_|\n");
		System.out.println("-----------------------------------------------------\n");
		printBestMenu();//TODO 디자인 수정하기 BestMenu랑 Category 같이 출력해야하니까 좀 깔끔한 방법 생각해보기!!

		System.out.println("\r\n" 
				+ "   ___         _                                    \r\n"
				+ "  / __\\  __ _ | |_   ___   __ _   ___   _ __  _   _ \r\n"
				+ " / /    / _` || __| / _ \\ / _` | / _ \\ | '__|| | | |\r\n"
				+ "/ /___ | (_| || |_ |  __/| (_| || (_) || |   | |_| |\r\n"
				+ "\\____/  \\__,_| \\__| \\___| \\__, | \\___/ |_|    \\__, |\r\n"
				+ "                          |___/               |___/ \r\n" + "");

		System.out.println("-----------------------------------------------------");
		System.out.println();
		System.out.println("\t\t\tA.커피" + "\n\n\t\t\tB.음료" + "\n\n\t\t\tC.티" + "\n\n\t\t\tD.에이드" + "\n\n\t\t\tE.스무디");
		System.out.println();
		CartOrder co = new CartOrder();
		System.out.printf("\t\t\t\t\t  🛒장바구니(%d)\n",co.cart.size()); //TODO 장바구니 개수 출력하는거 맞는 ArrayList로 연결시키기.

		Output.toolEnd();
		System.out.println("🛒 장바구니 진입은 * 을 입력해주세요. ");
		System.out.print("Select▶");
		chosenCategory = scan.nextLine();

		if ((chosenCategory.equals("A")) || (chosenCategory.equals("a"))) {
			printCoffee();
		} else if ((chosenCategory.equals("B")) || (chosenCategory.equals("b"))) {
			printBeverage();
		} else if ((chosenCategory.equals("C")) || (chosenCategory.equals("c"))) {
			printTea();
		} else if ((chosenCategory.equals("D")) || (chosenCategory.equals("d"))) {
			printAde();
		} else if ((chosenCategory.equals("E")) || (chosenCategory.equals("b"))) {
			printSmoothe();
		} else if (chosenCategory.equals("*")) {
			CartOrder c = new CartOrder();
			c.main();
		}

	}

	private static void printBestMenu() {
		//TODO 주문내역에 지금으로부터 1주일의 내용이 없다면 제일 최근에 저장되어져 있던 베스트메뉴로 가져오게 처리하기
		Calendar weekago = Calendar.getInstance();
		weekago.add(Calendar.DATE, -7);
		weekago.set(Calendar.HOUR, 0);
		weekago.set(Calendar.MINUTE, 0);
		int i = 0;
		int[] menuSeq = new int[Data.mlist.size()];

		for (Order o : Data.olist) {

			if ((o.getOrderDate().compareTo(weekago) == 1) || (o.getOrderDate().compareTo(weekago) == 0)) {

				menuSeq[Integer.parseInt(o.getMenuSeq()) - 1] = menuSeq[Integer.parseInt(o.getMenuSeq()) - 1] + 1;
			}

		}
		
		int max = menuSeq[0];
		
		i = findMax(menuSeq, max);
		int bestOne = i+1;
		i = findMax(menuSeq, max);
		int bestTwo = i+1;
		i = findMax(menuSeq,max);
		int bestThree = i+1;
		i = findMax(menuSeq,max);
		int bestFour = i+1;
		i = findMax(menuSeq,max);
		int bestFive = i+1;
		
		int count = 1;
		for(Menu m : Data.mlist) {
			if((Integer.toString(bestOne).equals(m.getSeq()))
				||(Integer.toString(bestTwo).equals(m.getSeq())) 
				||(Integer.toString(bestThree).equals(m.getSeq())) 
				||(Integer.toString(bestFour).equals(m.getSeq())) 
				||(Integer.toString(bestFive).equals(m.getSeq()))) {
				
				System.out.printf("%d. %s  ",count, m.getName());
				count++;
				
			}
			
		}

	}

	private static int findMax(int[] menuSeq, int max) {
		int i;
		int num = 0;
		for(i = 0 ; i<menuSeq.length; i++) {
			if(menuSeq[i]>max) {
				max = menuSeq[i];
				num = i;
			}
			
		}
		menuSeq[num] = 0;
		return num;
	}

	private static void startCategory() {
		printStart();

		System.out.println("\r\n" 
				+ " _____         _                                    \r\n"
				+ "/  __ \\       | |                                   \r\n"
				+ "| /  \\/  __ _ | |_   ___   __ _   ___   _ __  _   _ \r\n"
				+ "| |     / _` || __| / _ \\ / _` | / _ \\ | '__|| | | |\r\n"
				+ "| \\__/\\| (_| || |_ |  __/| (_| || (_) || |   | |_| |\r\n"
				+ " \\____/ \\__,_| \\__| \\___| \\__, | \\___/ |_|    \\__, |\r\n"
				+ "                           __/ |               __/ |\r\n"
				+ "                          |___/               |___/ \r\n" + "");
		System.out.println("-----------------------------------------------------");
		System.out.println();
		System.out.println("\t\t\t1.커피" + "\n\n\t\t\t2.음료" + "\n\n\t\t\t3.티" + "\n\n\t\t\t4.에이드" + "\n\n\t\t\t5.스무디");
		System.out.println();
		System.out.println();

		Output.toolEnd();
	}

	public static void printStart() {
		Output.toolStart();
		Calendar now = Calendar.getInstance();
		System.out.print("\t\t\t\t");
		System.out.printf("%tF %s:%s %tA\n", now, now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE), now);

	}

}
