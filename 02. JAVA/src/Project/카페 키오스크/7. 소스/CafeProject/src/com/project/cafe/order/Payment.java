package com.project.cafe.order;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.project.cafe.Data;
import com.project.cafe.DataPath;
import com.project.cafe.Main;
import com.project.cafe.Output;
import com.project.cafe.dataClass.Cart;
import com.project.cafe.dataClass.Order;
import com.project.cafe.dataClass.Stamp;

public class Payment {

	private ArrayList<ArrayList<String>> print;
	private ArrayList<String> temp;
	private int totalPrice;
	private int discount;
	private boolean stamp;
	
	public Payment() {
		this.print = new ArrayList<ArrayList<String>>();
		this.temp = new ArrayList<String>();
		this.totalPrice = 0;
		for(Cart c : CartOrder.cart) { totalPrice += c.getTotalPrice(); }
		this.discount = 0;
		this.stamp = false;
	}

	public void main() {
		
		loadOrderPage();
		
		if(Main.currentLogin == null) { 
			getPhoneNum();
		} 
		
		if(Main.currentLogin != null) { 
			stamp = useStamp();
		}
		
		payby();
		
		Output.pause();
	
	}

	private void loadOrderPage() {
	
		temp.add(0, "┌───────────────────────────────────────────────────┐\n");
		temp.add(1, "\t\t\t주문정보\n");
		temp.add(2, "\n");
		temp.add(3, "\t-----------------------------------------\n");
		print.add(0,temp);
		
		
		temp = new ArrayList<String>();
		temp.add(0, "\t▷ ");
		temp.add(1, "1. 적립 및 스탬프 사용하기\n");
		temp.add(2, "\n");
		temp.add(3, "\n");
		temp.add(4, "\t-----------------------------------------\n");
		print.add(1,temp);
		
		temp = new ArrayList<String>();
		temp.add(0, "\t▷ ");
		temp.add(1, "2. 결제 수단 선택하기\n");
		temp.add(2, "\n");
		temp.add(3, "\n");
		temp.add(4, "\t-----------------------------------------\n");
		print.add(2,temp);

		temp = new ArrayList<String>();
		temp.add(0, "\t▷ ");
		temp.add(1, "3. 결제하기\n");
		temp.add(2, "\n");
		temp.add(3, "\n");
		temp.add(4, "\t  [결제 정보]\n");
		temp.add(5, "\t  ────────────────────────────────────\n");
		
		temp.add(6, String.format("\t   총 주문금액\t\t%,d원\n", totalPrice));
		temp.add(7, "\t   할인\t\t\t\t");
		temp.add(8, "0원\n");
		temp.add(9, "\t  ────────────────────────────────────\n");
		temp.add(10, "\t   최종 결제금액\t\t");
		temp.add(11, String.format("%,d원\n", totalPrice));
		temp.add(12, "\n");
		temp.add(13, "└───────────────────────────────────────────────────┘\n");
		temp.add(14, "\n");
		print.add(3,temp);
		
	}

	private boolean getPhoneNum() {
		
		temp = print.get(1);
		temp.set(0, "\t▶ ");
		
		boolean error = false;
		
		while(true) {
			
			printOrderPage();
			
			System.out.println("1. 적립 및 스탬프 사용");
			System.out.println("-→ 전화번호를 입력해주세요.(넘어가기: enter)");
			System.out.println();
			System.out.println();
			
			if(error == true) {
				System.out.println("⚠️ 존재하지 않는 전화번호입니다.");
				error = false;
			}else {
				System.out.println();
			}
			System.out.println();

			Scanner scan = new Scanner(System.in);
			System.out.print("전화번호 ▶");
			String input = scan.nextLine();
	
			if(input.equals("")) {
				temp.set(0, "\t▷ ");
				return false;
			}
			
			if(Main.customerLogin(input)) {
				temp.set(0, "\t▷ ");
				return true;
			} 
			
			error = true;
		}
	}

	private void printOrderPage() {
		for(ArrayList<String> p : print) {
			for(String s : p) {
				System.out.print(s);
			}
		}
	}

	private boolean useStamp() {
		
		int stampNum = 0;
		temp = print.get(1);
		temp.set(0, "\t▶ ");
		temp.set(2, String.format("\t  - 전화번호 : %s\n", Main.currentLogin.getTel()));
		
		for(Stamp s : Data.slist) {
			if(s.getCumstomerSeq().equals(Main.currentLogin.getSeq())) { stampNum = Integer.parseInt(s.getStamp()); }
		}
		
		if(stampNum < 10) {
			temp.set(3, String.format("\t  - 스탬프수 : %d개 → (적립이후) %d개\n"
												, stampNum
												, stampNum + CartOrder.cart.size()));
			temp.set(0, "\t▷ ");
			return false;
		}
		
		
		boolean error = false;
		
		while(true) {
			
			printOrderPage();
		
			System.out.println("1. 스탬프 사용");
			System.out.printf("-→ 현재 스탬프 : %d개\n", stampNum);
			System.out.println("-→ 스탬프 10개 차감하여 음료 1잔을 무료로 교환시겠습니까?");
			System.out.println();
			System.out.println();
			
			if(error == true) {
				System.out.println("⚠️ 올바르지 않은 입력입니다.");
				error = false;
			}else {
				System.out.println();
			}
			System.out.println();
			
			
			Scanner scan = new Scanner(System.in);
			System.out.print("Select[ y | n ]▶ ");
			String input = scan.nextLine();
			
			if(input.toLowerCase().equals("y")) {
				temp.set(0, "\t▷ ");
				temp.set(3, String.format("\t  - 스탬프수 : %d개 → (사용 및 적립이후) %d개\n"
						, stampNum
						, stampNum -11 + CartOrder.cart.size()));
				return true;
			} else if (input.toLowerCase().equals("n")) {
				temp.set(0, "\t▷ ");
				temp.set(3, String.format("\t  - 스탬프수 : %d개 → (적립이후) %d개\n"
						, stampNum
						, stampNum + CartOrder.cart.size()));
				return false;
			} else {
				error = true;
			}
		}
	
	}
		

	private void payby() {
		
		boolean error = false;
		temp = print.get(2);
		temp.set(0, "\t▶ ");
		
		if(stamp) {
			temp.set(2, "\t  - 할인 : 스탬프 사용\n");
			
			temp = print.get(3);
			
			for(Cart c : CartOrder.cart) {
				if(c.getTotalPrice() > discount) {
					discount = c.getTotalPrice();
				}
			}
			
			temp.set(8, discount + "원\n");
			temp.set(11, (totalPrice - discount) + "원\n");
			
		} else {
			temp.set(2, "\t  - 할인 : 없음\n");
			
		}
		while(true) {
			
			printOrderPage();
			
			System.out.println("2. 결제 수단 선택");
			System.out.println("-> 현금은 1, 카드는 2를 입력해주세요.");
			System.out.println();
			System.out.println();
			
			if(error == true) {
				System.out.println("⚠️ 올바르지 않은 입력입니다.");
				error = false;
			}else {
				System.out.println();
			}
			System.out.println();
			
			Scanner scan = new Scanner(System.in);
			System.out.print("결제수단 ▶ ");
			String input = scan.nextLine();
			
			temp = print.get(2);
			if(input.equals("1")) {
				temp.set(0, "\t▷ ");
				temp.set(3, "\t  - 결제수단 : 현금\n");
				paybyMoney();
				return;
			} else if (input.equals("2")) {
				temp.set(0, "\t▷ ");
				temp.set(3, "\t  - 결제수단 : 카드\n");
				paybyCard();
				return;
			} else { 
				error = true;
			}
		}
	
	}

	private void paybyCard() {
		
		boolean completePay = false;
		boolean error = false;
		temp = print.get(3);
		temp.set(0, "\t▶ ");
		
		while(true) {
			
			printOrderPage();
			
			System.out.println("3. 결제하기");
			System.out.println("-> 카드를 아래에 삽입해주세요.");
			System.out.println();
			 
			if(error) {
				System.out.println("⚠️ 올바르지 않은 입력입니다.");
				error = false;
			} else {
				System.out.println();
			}
			System.out.println();
			
			if(!completePay) {
				Scanner scan = new Scanner(System.in);
				System.out.println("(카드 삽입: Enter / 결제 취소: 0)");
				System.out.print("카드 삽입 ▶");
				String input = scan.nextLine();
	
				if(input.equals("")) { 
					completePay = true; 
				} else if (input.equals("0")) {
					return;
				} else {
					error = true;
				}
			
			} else {
				System.out.println("결제가 완료되었습니다. 이용해주셔서 감사합니다😊");
				afterPay();
				return;
			}
		}	
	}
	
	
	private void afterPay() {

		if(Main.currentLogin != null) {
			
			Stamp st = null;
			
			for(Stamp s : Data.slist) {
				if(Main.currentLogin.getSeq().equals(s.getCumstomerSeq())){ st = s; }
			}
			
			if(stamp) {
				st.setStamp(Integer.parseInt(st.getStamp()) + CartOrder.cart.size() - 11 + "");
			} else {
				st.setStamp(Integer.parseInt(st.getStamp()) + CartOrder.cart.size() + "");
			}
			
		}
		
		Calendar now = Calendar.getInstance();
		String orderDate = now.get(Calendar.YEAR) + "-" 
						+ (now.get(Calendar.MONTH) + 1) + "-" 
						+ now.get(Calendar.DATE);
		
		for(Cart c : CartOrder.cart) {
			Data.olist.add(new Order(findMaxSeq_olist()
										, c.getMenuSeq()
										, orderDate
										, Main.currentLogin==null? "-1" : Main.currentLogin.getSeq()));	
		}
		
		CartOrder.cart.clear();
		
		Data.save(DataPath.적립);
		Data.save(DataPath.주문내역);
	
	} 
	

	private static String findMaxSeq_olist() {
	      int max = 0;
	      
	      for(Order o : Data.olist) {
	         if(Integer.parseInt(o.getSeq()) > max) { 
	            max = Integer.parseInt(o.getSeq());
	         }
	      }
	      return "" + (max + 1);
	}



	private void paybyMoney() {
		
		temp = print.get(3);
		temp.set(0, "\t▶ ");

		boolean completePay = false;
		boolean error = false;
		String message = " ";
		int money = 0;
		
		while(true) {
			
			printOrderPage();
			
			System.out.println("3. 결제하기");
			System.out.print(String.format("-> 현금을 넣어주세요 [현재 투입금액: %d원]\n", money));
			System.out.println();
			System.out.println();
			
			if(error) {
				System.out.println(message);
				error = false;
			} else {
				System.out.println();
			}
			
			
			//현금 선택시 넣을 금액을 입력받고 결제해야할 금액보다 초과하면 거스름돈을 계산하여 출력하고, 
			//결제할 금액과 일치하면 결제완료를 출력하고, 부족하면 돈을 더 입력받는다.		
			
			if(!completePay) {
				Scanner scan = new Scanner(System.in);
				System.out.println("(결제취소: 0)");
				System.out.print("현금 ▶  ₩");
				
				try {
					int input = scan.nextInt();
					
					if(input == 0) {
						return;
					}
					
					if(input < 0) {
						throw new Exception();
					} else if(input > 200000) {
						throw new InputMismatchException();
					}
					
					money += input;
					
					if(money >= totalPrice - discount) {
						completePay = true;
						error = true;
						message = String.format("⚠️ 거스름돈 %,d원이 반환되었습니다.",  money - (totalPrice - discount));
					} else {
						error = true;
						message = "⚠️ " + (totalPrice - discount - money) + "원을 더 투입해주세요.";
					}
	
				} catch (InputMismatchException e) {
					error = true;
					message = "⚠️ 과도한 현금은 투입할 수 없습니다.";
				} catch (Exception e) {
					error = true;
					message = "⚠️ 현금만 넣어주세요.";
				}
			} else {
				System.out.println("결제가 완료되었습니다. 이용해주셔서 감사합니다😊");
				afterPay();
				return;
			}
		
		}
		
	}


}
