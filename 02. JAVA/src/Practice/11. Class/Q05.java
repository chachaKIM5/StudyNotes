package com.test.java.question.Class;

public class Q05 {

	public static void main(String[] args) {
		
	//색상을 랜덤으로?
	//String[] color = new String[8];
	//color[(int)(Math.random() * 8)]
	
	Box box1 = new Box();
	box1.cook();
	box1.check();
	box1.list();
	
	}// main
	
} //class


class Box {
	
	private Macaron[] list = new Macaron[10];
	
	public void cook() {
	

		for (int i=0 ; i<list.length ; i++) {
			list[i] = new Macaron();			
			list[i].setColor();
			list[i].setSize();
			list[i].setThickness();
		}
		
		System.out.printf("마카롱을 %d개 만들었습니다.\n", list.length);
		
		
	}
	
	public void check() {
		
		int pass = 0;
		int fail = 0;
		
		for (int i=0 ; i<list.length ; i++) {
			if ((list[i].getSize() >= 8 && list[i].getSize() <= 14)
				&& (!list[i].getColor().equals("black"))
				&& (list[i].getThickness() >= 3 && list[i].getThickness() <= 18)) {
				
				list[i].setPass(true);
				pass++;
				
			} else {
				list[i].setPass(false);
				fail++;
			}
		}
		
		System.out.printf("\n[박스 체크 결과]\n");
		System.out.printf("QC 합격 개수: %d개\n", pass);
		System.out.printf("QC 불합격 개수: %d개\n", fail);
	}
	
	public void list() {
		
		System.out.printf("\n[마카롱 목록]\n");
		
		for (int i=0 ; i<list.length ; i++) {
			System.out.printf("%d번 마카롱 : %dcm(%s, %dmm) : "
								, i+1
								, list[i].getSize()
								, list[i].getColor()
								, list[i].getThickness());
			if (list[i].getPass().equals("O")) {
				System.out.print("합격\n");
			} else {
				System.out.print("불합격\n");
			}
		}
	}
}

class Macaron {
	private int size;
	private String color;
	private int thickness;
	private String pass;
	
	
	//Getter, Setter에서는 최소한의 유효성 검사만 하는 것이 좋다
	//코드에는 문제가 없지만 웬만하면 비즈니스코드(업무 코드)는 Getter, Setter에서 X
	public void setSize() {
		this.size = (int)(Math.random() * 11 + 5);
	}
	
	public int getSize() {
		return size;
	}
	
	public void setColor() {
		String color[] = {"red", "blue", "yellow", "white", "pink", "purple", "green", "black"};
		this.color = color[(int)(Math.random() * 8)];
	}
	
	public String getColor() {
		return color;
	}
	
	public void setThickness() {
		this.thickness = (int)(Math.random() * 20 + 1);
	}
	
	public int getThickness() {
		return thickness;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(boolean pass) {
		if (pass) {
			this.pass = "O";
		} else {
			this.pass = "X";
		}

	}
	

}
