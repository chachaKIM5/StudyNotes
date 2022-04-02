package com.test.java.question.collection;

class MyHashMap {
	private String[] key;
	private String[] value;
	private int index;
	
	public MyHashMap() {
		this.index = 0;
	}

	
	
	public String put(String key, String value) {
		
		//처음 넣을 때
		if (this.index == 0) {
			this.key = new String[4];
			this.value = new String[4];
		}
		
		//index == 방의 길이일 때(방이 꽉 찼을 때) 방 2배
		if (checkLength()) {
			doubleList();
		}
		
		//Key는 중복될 수 없다 > key가 있는지 없는지 체크하는 메소드 checkKey()
		//Key가 이미 있다 -> value 요소 수정하고 수정 전 값 return
		//key를 넣으면 숨겨진 방번호를 찾아주는 메소드 findIndex()
		if (checkKey(key)) {

			String temp;
			temp = this.value[findIndex(key)];
			this.value[findIndex(key)] = value;

			return temp;

		//입력한 Key가 없다 -> key, value 새로 추가
		} else {			
			
			this.key[this.index] = key;
			this.value[this.index] = value;
			this.index++;			
			return null;
		}		
	}
	
	
	public boolean checkKey(String key) {
		
		//있다 > true, 없다 > false
		for (int i=0 ; i < this.index ; i++) {
			if (this.key[i].equals(key)) {
				return true;
			}
		}
		return false;
	}
	
	
	public void doubleList() {
		
		String[] listNew = new String[this.index * 2];
		
		for (int i=0 ; i<this.index ; i++) {
			listNew[i] = this.key[i];
		}
		this.key = listNew;
		
		for (int i=0 ; i<this.index ; i++) {
			listNew[i] = this.value[i];
		}
		this.value = listNew;
	}
	
	
	public boolean checkLength() {
		if (this.index == this.key.length
				&& this.index == this.value.length) {
			return true;
		}
		return false;
	}
	
	
	public int findIndex(String key) {
		for (int i=0 ; i<this.index ; i++) {
			if (this.key[i].equals(key)) {
				return i;
			}
		} 
		return -1;
	}

	
	

		
	public String get(String key) {
		if (checkKey(key)) {
			return this.value[findIndex(key)];

		} else {
			return null;
		}
	}
	
	public int size() {
		
		return this.index;
	}
	
	public String remove(String key) {
		
		String removeValue = this.value[findIndex(key)];
		for (int i=findIndex(key) ; i<this.index-1 ; i++) {
			this.key[i] = this.key[i+1];
			this.value[i] = this.value[i+1];
		}
		
		this.key[this.index-1] = null;
		this.value[this.index-1] = null;
		this.index--;

		return removeValue;
	}
		
	public boolean containsKey(String key) {
		if (findIndex(key) > -1) {
				return true;					
		}
		return false;
	}
	
	public boolean containsValue(String value) {
		for (int i=0 ; i<this.index ; i++) {
			if (this.value[i].equals(value)) {
				return true;
			}
		}
		return false;
	}
	
	public void clear() {
		this.index = 0;
		this.value = null;
		this.key = null;
	}
	
	public void trimToSize() {
		String[] tempKey = new String[this.index];
		String[] tempValue = new String[this.index];

		for (int i=0 ; i<this.index ; i++) {
			tempKey[i] = this.key[i];
			tempValue[i] = this.value[i];
		}
		this.key = tempKey;
		this.value = tempValue;
	}
	
	
	
	
	@Override
	public String toString() {
			
		String temp = "";
		
		temp += "\n";
		temp += String.format("length: %d\n", this.key.length); //배열의 실제 길이
		temp += String.format("index: %d\n", this.index); //현재 방번호
		temp += String.format("[\n");
		
		for (int i=0; i<this.key.length; i++) {
			temp += String.format("  %d: (%s, %s)\n", i, this.key[i], this.value[i]);
		}
		
		temp += String.format("]\n");
		
		return temp;		
	}
	
	
}

