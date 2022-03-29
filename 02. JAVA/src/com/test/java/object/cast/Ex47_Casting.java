package com.test.java.obj.cast;

public class Ex47_Casting {

	public static void main(String[] args) {
		
		//Ex47_Casting.java
		
		//업캐스팅과 다운캐스팅은 언제/왜 쓸까?
		
		G304 m1 = new G304("광", 45000, 5, 12000);
		G304 m2 = new G304("광", 38000, 4, 8000);
		
		G102 m3 = new G102("광", 28000, 8000, "검정");
		G102 m4 = new G102("광", 25000, 5000, "노랑");
		G102 m5 = new G102("광", 26000, 7000, "파랑");
		
		M331 m6 = new M331("광", "검정", 33000, 10000);
		M331 m7 = new M331("광", "연두", 32000, 9000);
		
		
		
		G304[] mlist1 = new G304[2];
		mlist1[0] = m1;
		mlist1[1] = m2;
		
		G102[] mlist2 = new G102[] { m3, m4, m5 };
		
		M331[] mlist3 = new M331[] { m6, m7 };
		
		//마우스가 잘 있는지 확인? 마우스를 꺼내서 동작 테스트
		
		for (int i=0 ; i<mlist1.length ; i++) {
			mlist1[i].click();
			mlist1[i].clean();
		}
		
		System.out.println();
		
		for (int i=0 ; i<mlist2.length ; i++) {
			mlist2[i].click();
			mlist2[i].check();
			
		}
		
		System.out.println();
		
		for (int i=0 ; i<mlist3.length ; i++) {
			mlist3[i].click();
			mlist3[i].charge();
		}

		
		
		G304 m8 = new G304("광", 50000, 3, 5000);
		
		Mouse m9;
		//Mouse = G304
		//부모클래스 = 자식클래스
		//업캐스팅(100% 가능)
		
		m9 = m8;
		
		
		//위 3줄(업캐스팅)을 한 줄로 줄일 수 있는 방법
		Mouse m10 = new G304("", 0, 0, 0);
		Mouse m11 = new G102("", 0, 0, "");
		Mouse m12 = new M331("", "", 0, 0);
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		//마우스 7개를 관리	> 모델별 배열 ▲
		//				> 전체 배열 ▼ > 업캐스팅 활용!
		//서로 다른 자료형을 객체의 집합 하나에 넣어서 관리하기 위해 업캐스팅 사용
		Mouse[] mlist = new Mouse[7];
		
		mlist[0] = m1; //G304
		mlist[1] = m2; //G304
		
		mlist[2] = m3; //G102
		mlist[3] = m4; //G102
		mlist[4] = m5; //G102
		
		mlist[5] = m6; //M331
		mlist[6] = m7; //M331
		
		for (int i=0 ; i<mlist.length ; i++) {
			mlist[i].click();
			
			//공통된 기능은 공통적으로 쓰고, 개별 기능도 쓰고 싶다?
			//자식 고유의 기능을 사용해야 할 때
			//부모 참조 변수로는 접근 불가능(invisible), 이때에 한해 원래 자료형으로 되돌리기
			//G304 > clean(), G102 > check(), M331 > charge()
			
			//G304 a1 = (G304)mlist[i]; //다운 캐스팅
			//a1.clean(); 
			//mlist[0], mlist[1]까지 형변환 ok, mlist[2]부터 에러
			//> G304와 G102는 방계라 형변환 불가능
			
			
			//연산자 'instanceof'
			// - A instanceof B
			// - 2항 연산자
			// - A라는 객체가 B라는 자료형의 객체냐?
			// - A를 B로 형변환할 수 있는가?
			
			if (mlist[i] instanceof G304) {
				((G304)mlist[i]).clean();
				
			} else if (mlist[i] instanceof G102) {
				((G102)mlist[i]).check();
				
			} else {
				((M331)mlist[i]).charge();
			}
			
		}
		
	} //main
} //Ex47


class Mouse {
	public void click() {
		
	}
}


class G304 extends Mouse {
	
	private String type;
	private int price;
	private int buttons;
	private int dpi;
	
	public G304(String type, int price, int buttons, int dpi) {
		super();
		this.type = type;
		this.price = price;
		this.buttons = buttons;
		this.dpi = dpi;
	}

	@Override
	public String toString() {
		return "G304 [type=" + type + ", price=" + price + ", buttons=" + buttons + ", dpi=" + dpi + "]";
	}
	
	public void click() {
		System.out.printf("클릭합니다. %d, %d\n", this.price, this.dpi);
	
	}
	
	public void clean() {
		System.out.println("광센서를 자동으로 세척합니다.");
	}
	
}



class G102 extends Mouse {
	private String type;
	private int price;
	private int dpi;
	private String color;
	
	
	public G102(String type, int price, int dpi, String color) {
		super();
		this.type = type;
		this.price = price;
		this.dpi = dpi;
		this.color = color;
	}

	@Override
	public String toString() {
		return "G102 [type=" + type + ", price=" + price + ", dpi=" + dpi + ", color=" + color + "]";
	}
	
	public void click() {
		System.out.printf("Click~ %s\n", this.color);
	}
	
	public void check() {
		System.out.println("현재 DPI를 체크합니다.");
	}
}



class M331 extends Mouse {
	
	private String type;
	private String color;
	private int price;
	private int dpi;
	
	public M331(String type, String color, int price, int dpi) {
		super();
		this.type = type;
		this.color = color;
		this.price = price;
		this.dpi = dpi;
	}
	
	@Override
	public String toString() {
		return "M331 [type=" + type + ", color=" + color + ", price=" + price + ", dpi=" + dpi
				+ "]";
	}
	
	public void click() {
		System.out.printf("클릭!! %s\n", this.type);
	}
	
	public void charge() {
		System.out.println("충전합니다.");
	}
}