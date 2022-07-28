package com.test.spring.di02;

public class Hong {
	
	private Pen pen;
	
	public Hong(Pen pen) { //생성자 주입
		this.pen = pen;
	}
	
	public void run() {
		
		//직접 생성 -> 의존 주입
//		Pen pen = new Pen();
		pen.write();
		
		
		
	}
}
