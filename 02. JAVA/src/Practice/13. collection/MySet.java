package com.test.java.question.collection;

public class MySet {
	private String[] mySet;
	private int index;
	private int next;
	
	public MySet() {
		index = 0;
		next = 0;
	}
	
	
	public boolean add(String value) {
		
		//index == 0이면(처음) 배열 생성
		if (this.index == 0) {
			this.mySet = new String[4];
		}
		
		//중복되는지 확인하는 메소드, 중복되면 false
		if (isDuplicate(value)) {
			return false;
		}
		
		
		//중복되지 않을 경우
		//배열 꽉 찼을 때 2배 늘려주기
		if (checkLength()) {
			doubleList();	
		}
		
		
		//추가하고 true 반환
		this.mySet[this.index] = value; 
		index++;
		return true;
		
	}
	
	
	public boolean isDuplicate(String value) {
		
		//중복 확인 메소드, 중복값 있으면 true 반환
		for (int i=0 ; i<this.index ; i++) {
			if (this.mySet[i].equals(value)) {
				return true;
			}
		}
		return false;
	}
	
	
	public boolean checkLength() {
		
		//index == 배열 실제 길이 > 배열이 꽉 찼을 때
		if (this.index == this.mySet.length) {
			return true;
		}
		return false;
	}
	
	public void doubleList() {
		
		//2배 배열 생성, 깊은 복사, 교체
		String[] newMySet = new String[this.index * 2];
		
		for (int i=0 ; i<this.index ; i++) {
			newMySet[i] = this.mySet[i];
		}
		this.mySet = newMySet;
	}
	
	
	public int size() {
		
		return this.index;
	}
	
	public boolean remove(String value) {
		
		int removeIndex = -1;
		
		//배열 안에 값이 있으면 removeIndex에 방 번호를 대입
		for (int i=0 ; i<this.index ; i++) {
			if (this.mySet[i].equals(value)) {
				removeIndex = i;
				break;
			}
		}
		
		//배열에 없으면 false 반환
		if (removeIndex == -1) {
			return false;
		}
		
		//left shift
		for (int i=removeIndex; i<this.mySet.length-1 ; i++) {
			this.mySet[i] = this.mySet[i+1];
		}
		
		this.index--;
		return true;
		
	}

	public void clear() {
		
		this.index = 0;
	}
	
	public boolean hasNext() {
		
		//다음 요소를 나타내는 int값 this.next
		if (this.next < this.index) {
			return true;
		} else {
			return false;
		}
	}
	
	public String next() {
		
		//다음 요소를 반환한다
		this.next++;
		return mySet[this.next - 1];
	}

	
	@Override
	public String toString() {
			
		String temp = "";
		
		temp += "\n";
		temp += String.format("length: %d\n", this.mySet.length); //배열의 실제 길이
		temp += String.format("index: %d\n", this.index); //현재 방번호 (요소 개수)
		temp += String.format("next: %d\n", this.next); //다음 요소 번호
		temp += String.format("[\n");
		
		for (int i=0; i<this.mySet.length; i++) {
			temp += String.format("%s\n", this.mySet[i]);
		}
		
		temp += String.format("]\n");
		
		return temp;		
	}
	
}
