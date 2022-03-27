package com.test.java.question.constructor;

public class Q03 {

	public static void main(String[] args) {
		
		
		//1. 클래스 5개 생성(Packer, Pencil, Eraser, BallPointPen, Ruler)
		//2. Packer에 static 변수 선언 (객체 개수 카운트)
		//3. 각 클래스에서 문구류 특성(진하기, 사이즈...등등) Setter로 설정, Getter 대신 info()로 String값 반환
		//4. Packer 클래스에서 문구류.info()로 정보 얻어온 후 조건에 맞는지 검사 -> 맞으면 포장, static 변수 카운트 ++ / 아니면 포장 X
		//5. static 변수 결과를 출력하는 Packer.countPacking 메소드 만들기 
		//6. main 메소드에서 호출
		
		
		
		//
		
		//포장하는 직원
		Packer packer = new Packer();

		//연필
		Pencil p1 = new Pencil();
		p1.setHardness("B");
		packer.packing(p1);

		Pencil p2 = new Pencil();
		p2.setHardness("2B");
		packer.packing(p2);

		//지우개
		Eraser e1 = new Eraser();
		e1.setSize("Large");
		packer.packing(e1);

		//볼펜
		BallPointPen b1 = new BallPointPen();
		b1.setThickness(0.3);
		b1.setColor("black");
		packer.packing(b1);

		BallPointPen b2 = new BallPointPen();
		b2.setThickness(1.5);
		b2.setColor("red");
		packer.packing(b2);

		//자
		Ruler r1 = new Ruler();
		r1.setLength(30);
		r1.setShape("줄자");
		packer.packing(r1);

		//결과 확인
		packer.countPacking(0);
		packer.countPacking(1);
		packer.countPacking(2);
		packer.countPacking(3);
		packer.countPacking(4);
		
		
		
		
		
		
	}//main
}//Q03



class Packer {
	
	private static int pencilCount;
	private static int eraserCount;
	private static int ballPointPenCount;
	private static int rulerCount;
	
	
	public void packing(Pencil pencil) {
		if (pencil.info() == null) {
			System.out.println("포장 전 검수: 포장할 수 없습니다.");
		} else {
			System.out.printf("포장 전 검수: %s입니다.\n", pencil.info());
			Packer.pencilCount++;
			System.out.println("포장을 완료했습니다.");
		}
	}
	
	public void packing(Eraser eraser) {
		if (eraser.info() == null) {
			System.out.println("포장 전 검수: 포장할 수 없습니다.");
		} else {
			System.out.printf("포장 전 검수: %s입니다.\n", eraser.info());
			Packer.eraserCount++;
			System.out.println("포장을 완료했습니다.");
		}
	}
	
	public void packing(BallPointPen ballPointPen) {
		if (ballPointPen.info() == null) {
			System.out.println("포장 전 검수: 포장할 수 없습니다.");
		} else {
			System.out.printf("포장 전 검수: %s입니다.\n", ballPointPen.info());
			Packer.ballPointPenCount++;
			System.out.println("포장을 완료했습니다.");
		}
	}
	
	public void packing(Ruler ruler) {
		if (ruler.info() == null) {
			System.out.println("포장 전 검수: 포장할 수 없습니다.");
		} else {
			
			System.out.printf("포장 전 검수: %s입니다.\n", ruler.info());
			Packer.rulerCount++;
			System.out.println("포장을 완료했습니다.");
		}
	}
	
	public void countPacking(int type) {
		System.out.println("\n=====================");
		System.out.println("포장 결과");
		System.out.println("=====================");
		
		if (type == 0) {
			System.out.printf("연필 %d회\n", Packer.pencilCount);
			System.out.printf("지우개 %d회\n", Packer.eraserCount);
			System.out.printf("볼펜 %d회\n", Packer.ballPointPenCount);
			System.out.printf("자 %d회\n", Packer.rulerCount);

		} else {
			switch (type) {
				case 1:
					System.out.printf("연필 %d회\n", Packer.pencilCount); break;
				case 2:
					System.out.printf("지우개 %d회\n", Packer.eraserCount); break;
				case 3:
					System.out.printf("볼펜 %d회\n", Packer.ballPointPenCount); break;
				case 4:
					System.out.printf("자 %d회\n", Packer.rulerCount); break;
		}
	}
}

}

class Pencil {
	private String hardness;

	public void setHardness(String hardness) {
		if (hardness.equals("4B") || hardness.equals("3B") ||
			hardness.equals("2B") || hardness.equals("B")  ||
			hardness.equals("HB") || hardness.equals("H")  ||
			hardness.equals("2H") || hardness.equals("3H") ||
			hardness.equals("4H")) {
			
			this.hardness = hardness;
		} else {
			System.out.println("연필 흑연 등급을 올바르게 입력하세요.");
		}
	}
	
	public String info() {
		if (this.hardness == null) { 
			return null;
		} else {
			return String.format("%s 진하기 연필", this.hardness);
		}
	}
}



class Eraser {
	private String size;
	
	public void setSize(String size) {
		if (size.equals("Large") || size.equals("Medium") || size.equals("Small")) {
			this.size = size;
		} else {
			System.out.println("지우개 크기를 올바르게 입력하세요.");
		}
	}
	
	public String info() {
		if (this.size == null) {
			return null;
		} else {
			return String.format("%s 사이즈 지우개", this.size);
		}
	}
	
}



class BallPointPen {
	private double thickness;
	private String color;
	
	public void setThickness(double thickness) {
		if ((thickness == 0.3) || (thickness == 0.5) ||
			(thickness == 0.7) || (thickness == 1)   ||
			(thickness == 1.5)) {
			this.thickness = thickness;
		} else {
			System.out.println("볼펜 심 두께를 올바르게 입력하세요.");
		}
	}

	public void setColor(String color) {
		if (color.equals("red")   || color.equals("blue") ||
			color.equals("green") || color.equals("black")) {
			this.color = color;
		} else {
			System.out.println("볼펜 색상을 올바르게 입력하세요.");
		}
	}


	public String info() {
		if ((this.color == null) || (this.thickness == 0)) {
			return null;
		} else {
			return String.format("%s 색상 %smm 볼펜", this.color, this.thickness);
		}
	}
	
}



class Ruler {
	private int length;
	private String shape;

	public void setLength(int length) {
		if ((length == 30) || (length == 50) || (length == 100)) {
			this.length = length;			
		} else {
			System.out.println("자 길이를 올바르게 입력하세요.");
		}
	}

	public void setShape(String shape) {
		if (shape.equals("줄자") || shape.equals("운형자") || shape.equals("삼각자")) {
			this.shape = shape;			
		} else {
			System.out.println("자 형태를 올바르게 입력하세요.");
		}
	}

	public String info() {
		if ((this.length == 0) || (this.shape == null)) {
			return null;
		} else {
			return String.format("%dcm %s", this.length, this.shape);
		}
	}
}