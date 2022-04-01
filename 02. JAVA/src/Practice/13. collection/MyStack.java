package com.test.java.question.collection;

public class MyStack {

	private String[] list; 	
	private int index;
	
	public MyStack() {
		this.index = 0;
	}

	public boolean push(String value) {
		
		try {
			if (this.index == 0) {
				this.list = new String[4];
			}
			
			if (this.index == this.list.length) {
				String[] listNew = new String[this.list.length * 2];
				
				for (int i=0 ; i<this.list.length ; i++) {
					listNew[i] = this.list[i];
				}	
				this.list = listNew;
			}
				
			this.list[this.index] = value;
			this.index++;
			return true;
	
		} catch (Exception e) {
			return false;
		}
		
	}
	
	public String pop() {
		
		//stack은 후입선출
		//MyArrayList의 get()과 비슷하지만, 매개변수 없고 뒤에서부터 하나씩 자동으로 꺼낸다
		

		if (this.list[this.index - 1] == null) {
			throw new IndexOutOfBoundsException();

		} else {
			String result = this.list[index - 1];
			index--;
			return result;
		}

	
	}
	
	public int size() {
		
		return this.index;
	}
	
	public String peek() {
		
		//가져올 값을 확인만 한다
		// = 가장 뒤에 있는 요소 값을 반환한다
		return this.list[this.index-1];
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
