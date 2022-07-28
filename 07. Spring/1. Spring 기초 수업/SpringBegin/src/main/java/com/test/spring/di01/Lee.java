package com.test.spring.di01;

public class Lee {

	//의존 객체
	private Brush brush;
	
	//DI 구현
	//1. 생성자
	//2. Setter
	
	//다른 사람(외부)이 만들어서 제공 > 생성자(******) > 생성자 덕분에 의존 객체를 주입받을 수 있음 > 의존 주입 도구
	//의존 주입 도구는 항상 생성자일 필요는 없다
	public Lee(Brush brush) {
		this.brush = brush;
	}
	
	public void setBrush(Brush brush) { //Setter도 의존 주입 도구!
		this.brush = brush;
	}
	
	public void run() {

		//의존 객체 생성 X
		//Brush brush = new Brush(); //직접 생성
		brush.draw();
	}
}
