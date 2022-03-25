package com.test.java.question.constructor;

public class Q02 {

	public static void main(String[] args) {
		
		//시간1
		Time t1 = new Time();
		System.out.println(t1.info());

		//시간2
		Time t2 = new Time(2, 30, 45);
		System.out.println(t2.info());

		//시간3
		Time t3 = new Time(1, 70, 30);
		System.out.println(t3.info());
		
		//시간4
		Time t4 = new Time(30, 10);
		System.out.println(t4.info());

		//시간5
		Time t5 = new Time(90, 10);
		System.out.println(t5.info());
		
		//시간6
		Time t6 = new Time(50);
		System.out.println(t6.info());
		
		
		Time t7 = new Time(10000);
		System.out.println(t7.info());
		
		
		
		
	}//main
}//class Q02


class Time {
	
	private int hour;
	private int minute;
	private int second;

	

	public Time() {
		this(0, 0, 0);
	}
	
	
	public Time(int second) {
		this(0, 0, second);
	}
	
	
	public Time(int minute, int second) {
		this(0, minute, second);
	}
	
	
	public Time(int hour, int minute, int second) {
		
		if (second >= 0 && second <= 60) {
			this.second = second;

		} else if (second > 60) {
			this.second = (second % 60);
			minute += (second / 60);
		}
		
		
		if (minute >= 0 && minute <= 60) {
			this.minute = minute;
		
		} else if (minute > 60) {
			this.minute = (minute % 60);
			hour += (minute / 60);
		}
		
		
		this.hour = hour;
		
	}

	public String info() {
		
		String output = String.format("%02d:%02d:%02d", this.hour
													  , this.minute
													  , this.second);
			
		return output;
		
	}


}

