package com.test.spring.di01;

public class Ex01 {

	public static void main(String[] args) {
		
		
		//Ex01과 Pen의 관계!!
		// - Ex01이 Pen을 의존(사용)한다
		// - Pen을 Ex01의 의존 객체라고 부른다
		
		//Ex01이 자신의 업무를 구현하기 위해서 Pen을 사용했다
		// > Pen이 없으면 Ex01은 업무를 진행할 수 없다
		Pen pen = new Pen();
		pen.write();
		
		//Brush는 의존객체이다.
		Brush brush = new Brush();
		brush.draw();
		
		
		//방법 A
		//Ex01 > (의존관계) > Hong(의존객체) > (의존관계) > Pen(의존객체)
		Hong hong = new Hong();
		hong.run(); // > Pen > 글씨
		
		
		//방법 B
		//Ex01 > Lee > Brush
		Brush b = new Brush();
		
		Lee lee = new Lee(b); //의존 객체 주입(DI)
		lee.run();
		
		
		//방법 A vs 방법 B
		// - 관리 업무의 중심이 어디인지에 차이점이 있다
		
		
	}
}
