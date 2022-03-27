package com.test.java.question.Class;

public class Q02 {

	public static void main(String[] args) {
		

		Note note = new Note();
		
		note.setSize("B5");
		note.setColor("노란색");
		note.setPage(25);
		note.setOwner("홍길동");
		
		System.out.println(note.info());
		
		
		Note note2 = new Note();
		
		note2.setSize("A4");
		note2.setColor("검정색");
		note2.setPage(100);
		
		System.out.println(note2.info());
		
		
		
		
		
		
	} //main
} //class



class Note {
	
	private String size;
	private String color;
	private int page;
	private String owner;
	private int price=500;
	
	
	
	public void setSize(String size) {
		if (size.equals("A3") || size.equals("A4") ||
			size.equals("A5") || size.equals("B3") ||
			size.equals("B4") || size.equals("B5")) {
			
			this.size = size;
			
		} else {
			
			System.out.println("잘못된 크기를 입력했습니다.");
		}
		
	}

	public void setColor(String color) {
		if (color.equals("검정색") || color.equals("흰색")
				||
			color.equals("노란색") || color.equals("파란색")) {
			
			this.color = color;
		
		} else {
			
			System.out.println("잘못된 색상을 입력했습니다.");
			
		}
	}
	

	public void setPage(int page) {
		if (page >= 10 && page <= 200) {
			this.page = page;
		} else {
			System.out.println("잘못된 페이지 수를 입력했습니다.");
			return;
		}
	}
	

	public void setOwner(String owner) {
		
		if (checkOwner(owner)) {
			this.owner = owner;
		} else {
			System.out.println("잘못된 소유자 이름입니다.");
		}
	}
	
	
	private boolean checkOwner(String owner) {
		
		if (owner.length() < 2 || owner.length() > 5) {
			return false;
		}
		
		for (int i=0 ; i<owner.length() ; i++) {
			if (owner.charAt(i) < '가' || owner.charAt(i) > '힣') {
				return false;
			}
		}
				
		return true;
		
	}
	
	
	private String howThick() {
		if (this.page >= 10 && this.page <= 50) {
			return "얇은";
		} else if (this.page >= 51 && this.page <= 100) {
			return "보통";
		} else {
			return "두꺼운";
		}
	}
	
	
	
	//-------------- 추가금 계산 ▼
	private int pageAdd() {
	
		return (this.page-10) * 10;
	}
	
	
	private int colorAdd() {
		
		switch (this.color) {
			case "검정색":
				return 100;
			case "노란색":
				return 200;
			case "파란색":
				return 200;
		}
		
		return 0;
	}
			
	
	private int sizeAdd() {
		
		switch (this.size) {
			case "A3":
				return 400;
			case "A4":
				return 200;
			case "B3":
				return 500;
			case "B4":
				return 300;
			case "B5":
				return 100;
		}
		
		return 0;
	} 
		
	//-------------- 추가금 계산 ▲		
	
	
	public String info() {
		
		String result;
		
		if (this.owner == null) {
			result = String.format("■■■■■■ 노트 정보 ■■■■■■\n")
					 + String.format("주인 없는 노트\n")
					 + String.format("■■■■■■■■■■■■■■■■■■■■■■■");
			
		} else {
			result = String.format("■■■■■■ 노트 정보 ■■■■■■\n")
					+ String.format("소유자: %s\n", this.owner)
					+ String.format("특성: %s %s %s노트\n", this.color
														, howThick()
														, this.size)
					+ String.format("가격: %,d원\n", this.price
												 + pageAdd()
												 + colorAdd()
												 + sizeAdd())
					+ String.format("■■■■■■■■■■■■■■■■■■■■■■■");
		}
		
		return result;
	
	}
}	



