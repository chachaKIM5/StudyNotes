package com.test.java.question.Class;

import java.util.Calendar;

public class Q03 {

	public static void main(String[] args) {
		
		
		Bugles snack = new Bugles();
		
		snack.setWeight(500);
		snack.setCreationTime("2022-03-21");
		System.out.println("가격: " + snack.getPrice() + "원");
		System.out.println("유통 기한이 " + snack.getExpiration() + "일 남았습니다.");
		
		snack.eat();
		
		
		Bugles snack2 = new Bugles();
		
		snack2.setWeight(300);
		snack2.setCreationTime("2022-03-13");
		System.out.println("가격: " + snack2.getPrice() +"원");
		System.out.println("유통 기한이 " + snack2.getExpiration() + "일 남았습니다.");
		
		snack2.eat();
		

	} //main
} //class


class Bugles {
	
	private int price;
	private int weight;
	private Calendar creationTime;
	private int expiration;
	
	
	
	public int getPrice() {
		calPrice(this.weight);
		return this.price;
	}

	private void calPrice(int weight) {
		
		switch (weight) {
			case 300:
				this.price = 850;
				break;
			case 500:
				this.price = 1200;
				break;
			case 850:
				this.price = 1950;
				break;
				
		}
	}




	public void setWeight(int weight) {
		if (weight == 300
			|| weight == 500
			|| weight == 850) {
			
			this.weight = weight;
		} else {
			System.out.println("판매하지 않는 용량입니다.");
		}
	}




	public void setCreationTime(String str) {
	
		Calendar creationTime = Calendar.getInstance();
		
		int year = Integer.parseInt(str.substring(0, 4));
		int month = Integer.parseInt(str.substring(5, 7));
		int date = Integer.parseInt(str.substring(8, 10));

		creationTime.set(year, month-1, date);
		
		this.creationTime = creationTime;
	}
	

	public int getExpiration() {
		calDay();
		return expiration;
	}
	
	
	private void calDay() {
		
		
		int last = 0;
		
		switch (this.weight) {
			case 300:
				last = 7;
				break;
			case 500:
				last = 10;
				break;
			case 850:
				last = 15;
				break;
		}
		
		Calendar now = Calendar.getInstance();
		expiration = (int)((this.creationTime.getTimeInMillis() - now.getTimeInMillis())
						/ 1000 / 60 / 60 / 24) + last - 1;
		
	}

	
	public void eat() {
		
		if (this.expiration >= 0) {
			System.out.println("과자를 맛있게 먹습니다.");
		} else {
			System.out.println("유통기한이 지나 먹을 수 없습니다.");
		}
	}
}
