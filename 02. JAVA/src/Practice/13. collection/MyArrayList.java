package com.test.java.question.collection;

//ArrayList와 동일한 동작을 하는 클래스를 선언하시오.
//제네릭 클래스(X) 일반 클래스(O) -> String
//모든 기능의 디테일은 실제 ArrayList로 Test해서 알아보기
//같은 오류가 발생하는지? 원래 ArrayList는 어떻게 동작하는지?

public class MyArrayList {

	private String[] list; 	//ArrayList의 내부 배열(*****)
	private int index;		//조작에 있어서 가장 중요한 역할 (**********)
	
	public MyArrayList() {
		this.index = 0;
	}
	
	public boolean add(String value) {
		
		//main의 list.add("홍길동")으로 쓰임
		//현재 배열의 길이보다 많은 데이터를 입력하려고 한다
		// -> 배열을 2배로 늘려 복사 + 교체
		
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
		
		} catch (Exception e) {
			
			//입력 실패(boolean false 반환)
			return false;
		}
	}
	
	public String get(int index) {
		
		//없는 방 번호를 요청하면? 어떻게 될까?
		//> IndexOutOfBoundsException 오류
		
		//ArrayList는 없는 방 번호를 요청하면 IndexOutOfBoundsException 오류
		//add()로 만든 list는 2배수 방이 생성되기 때문에
		//list 길이가 8, 값이 7까지만 있어도 8번 방은 null값이 나온다

		if (this.list[index] == null) {
			throw new IndexOutOfBoundsException();

		} else {
			return this.list[index];
		}

	}
	
	public int size() {
		
		//요소의 개수를 반환한다
		//요소를 추가할 때마다 index++ 했으므로 index 값을 반환
		return this.index;
	}
	
	public String set(int index, String value) {
		
		//원하는 위치의 요소를 다른 값으로 수정하고,
		//수정 전 요소 값을 반환한다
		
		//get()과 마찬가지로 ArrayList처럼
		//방 4개, 값 3개 있을 때 4번째 방에서 오류 나타나도록 예외 처리
		
		if (this.list[index] == null) {
			throw new IndexOutOfBoundsException();
		} else {
			String oldValue = this.list[index];
			this.list[index] = value;
			
			return oldValue;
		}
	
	}
	
	public String remove(int index) {
	
		//set, get()과 마찬가지로 ArrayList처럼
		//방 4개, 값 3개 있을 때 4번째 방을 지우려고 시도하면
		//null이 아니라 오류 나타나도록 예외 처리
		
		if (this.list[index] == null) {
			throw new IndexOutOfBoundsException();

		} else {
			String removeValue = this.list[index];
			
			for (int i=index ; i<this.list.length-1 ; i++) {
				this.list[i] = this.list[i+1];
			}
		
			this.index--;
			return removeValue;
		}		
	}

	public boolean add(int index, String value) {
		
		
		//insert mode
		//right shift 발생
	
		try {
			//이미 만들어 둔 add 메소드를 통해 지금 가장 마지막 요소를 복사해서 마지막 항 만들기
			//ex {0, 1, 2, 3} -> {0, 1, 2, 3, 3, null, null, null}
			add(this.list[this.index - 1]);
			
			//right shift, this.list[index]에는 value 값 넣기
			for (int i=this.index-2 ; ; i--) {
				this.list[i+1] = this.list[i];
				
				if (i == index) {
					this.list[index] = value;
					break;
				}
			} return true;	//성공
			
		} catch (Exception e) {
			return false;	//실패
		}
	}

	public int indexOf(String value) {
		
		//앞에서부터 value를 찾고 가장 먼저 만나는 value의 위치를 반환
		for (int i=0 ; i<this.index ; i++) {
			if (this.list[i].equals(value)) {
				return i; 
			}
		}
		return -1;
	}
	
	public int lastIndexOf(String value) {

		//뒤에서부터 value를 찾고 가장 먼저 만나는 value의 위치를 반환
		for (int i=this.index-1 ; i>=0 ; i--) {
			if (this.list[i].equals(value)) {
				return i; 
			}
		}
		return -1;
	}
	
	public void clear() {
		
		//ArrayList는 clear() 후 요소를 출력하면 IndexOutOfBoundsException 오류
		// => 아예 방이 없어지도록
		// => 길이 0짜리 배열을 새로 만들어서 초기화
		
		this.index = 0;
		this.list = new String[this.index];
	}
	
	public void trimToSize() {
		
		String[] listTrim = new String[this.index];
		for (int i=0; i<this.index ; i++) {
			 listTrim[i] = this.list[i];
		}
		this.list = listTrim;
	}
	
}
