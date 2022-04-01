package com.test.java.question.collection;

public class MyQueue {

	private String[] list; 	
	private int index;
	
	public MyQueue() {
		this.index = 0;
	}

	public boolean add(String value) {
		

				
		try {
			//첫 add에만 배열을 생성 (index == 0)
			if (this.index == 0) {
				this.list = new String[4];
			}
			
			
			//배열 범위 밖
			if (this.index == this.list.length) {
				String[] listNew = new String[this.list.length * 2];
			
				for (int i=0 ; i<this.list.length ; i++) {
					listNew[i] = this.list[i];
				}
				this.list = listNew;				
			}
			
			//배열 범위 내
			this.list[this.index] = value;
			this.index++;
			return true;
			
		//입력 실패(boolean false 반환)
		} catch (Exception e) {
			return false;
		}
		
	}
	
	public String poll() {
		
		//Queue는 선입선출
		//매개변수 없고 앞에서부터 하나씩 자동으로 꺼낸다
		//꺼낸 후 left shift 발생
		
		if (this.list[0] == null) {
			throw new IndexOutOfBoundsException();

		} else {
			String result = this.list[0];
			
			for (int i=0 ; i<this.list.length-1 ; i++) {
				this.list[i] = this.list[i+1];
			}
			this.list[index-1] = null;
			
			index--;
			return result;
		}
	}
	
	public int size() {
		
		return this.index;
	}
	
	public String peek() {
		
		//가져올 값을 확인만 한다
		// = 가장 앞에 있는 요소 값을 반환한다
		return this.list[0];
	}
	
	public void clear() {
		
		this.index = 0;
		this.list = new String[this.index];
	}
	
	
	public void trimToSize() {
		
		String[] listTrim = new String[index];
		for (int i=0; i<index ; i++) {
			 listTrim[i] = this.list[i];
		}
		this.list = listTrim;
	}
}