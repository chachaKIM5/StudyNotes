package com.test.java.obj.access;

public class Ex35 {

	public static void main(String[] args) {
		
		//Ex35
		
		CPU cpu = new CPU();
		cpu.setModel("Intel i5");
		cpu.setSpeed("1.8");
		
		MainBoard mainboard = new MainBoard();
		mainboard.setModel("M5000");

		Storage storage = new Storage();
		storage.setModel("SM");
		storage.setType("SSD");
		storage.setSize(500);
		
		
		Computer computer = new Computer();
		computer.setCpu(cpu);
		computer.setMainboard(mainboard);
		computer.setStorage(storage);
		
		
		Memory memory = new Memory();
		computer.setMemory(memory); //첫번쨰 메모리
		
		
		Memory memory2 = new Memory();
		computer.setMemory(memory2); //두번째 메모리
		
		
		Memory memory3 = new Memory();
		computer.setMemory(memory3);
		
		
		Memory memory4 = new Memory();
		computer.setMemory(memory4);
		
		
		computer.removeMemory();
		computer.removeMemory();
		computer.removeMemory();
		computer.removeMemory(); //i == 0
		//computer.removeMemory(); -> i가 -1이 되면서 "제거할 수 있는 메모리가 없습니다" 출력
		
		
		
//		Memory memory5 = new Memory();
//		computer.setMemory(memory5);
		
		
		
//		Memory[] mlist = new Memory[2]; //메모리를 2개 끼운다
//		
//		Memory m1 = new Memory();
//		mlist[0] = m1;
//		
//		mlist[1] = new Memory();
//		
//		
//		computer.setMemorylist(mlist);
		
		
		
		
		User hong = new User();
		
		hong.setNick(0, "강아지");
		hong.setNick(1, "천재");
		hong.setNick(2, "뚱보");
		
		System.out.println(hong.getNick(0));
		
	}
}


//컴퓨터
//- CPU
//- MainBoard
//- Memory
//- Storage

class Computer {
	private CPU cpu;
	private MainBoard mainboard;
	
	private int i = 0; //메모리 관리
	private Memory[] memorylist = new Memory[4]; //******* 클래스 멤버 변수에 배열이 들어간다면?
	
	private Storage storage;
	
	
	public CPU getCpu() {
		return cpu;
	}
	public void setCpu(CPU cpu) {
		this.cpu = cpu;
	}
	public MainBoard getMainboard() {
		return mainboard;
	}
	public void setMainboard(MainBoard mainboard) {
		this.mainboard = mainboard;
	}
	public Storage getStorage() {
		return storage;
	}
	public void setStorage(Storage storage) {
		this.storage = storage;
	}
	
	
	
	
	public void setMemory(Memory memory) { //메모리 1개~4개까지 마음대로 낄 수 있도록 만들기
	
		if (i == 4) {
			System.out.println("더 이상 남아있는 메모리 슬롯이 없습니다.");
			
			return; //빈 리턴문 > 반환 X, 메소드만 중지시킨다
		}
		
		this.memorylist[i] = memory;
		i++;
	}
	
	
	//마지막 방 메모리를 빼고 싶다 = 마지막 방은 i-1
	public void removeMemory() {
		
		if (i == 0) {
			System.out.println("제거할 수 있는 메모리가 없습니다.");
			return;
		}
		
		i--;
		this.memorylist[i] = null; //NULL상수, NULL 리터럴을 넣으면 주소값이 사라진다 -> 삭제
	}
	
	
//	public Memory[] getMemorylist() {
//		return memorylist;
//	}
//	public void setMemorylist(Memory[] memorylist) {
//		this.memorylist = memorylist;
//	}
	
	
}


class CPU {
	private String model;
	private String speed;
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getSpeed() {
		return speed;
	}
	public void setSpeed(String speed) {
		this.speed = speed;
	}	
	
}

class MainBoard {
	private String model;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
}


class Memory {
	private String model;
	private int size;
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
}


class Storage {
	private String model;
	private String type;
	private int size;
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
}




class User {
	
	private String name;
	private int age;
	
	private String[] nick = new String[10];
	
	
	public void setNick(int index, String value) {
		this.nick[index] = value;
	}
	
	
	public String getNick(int index) {
		return this.nick[index];
	}

}

