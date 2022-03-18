package com.test.java;

import java.util.Arrays;

public class Item32 {

	public static void main(String[] args) {
		
		//[SUMMARY] 배열 Array 메소드 기능 (2022. 3. 18. 오후 8:12:59)
		
		String[] name = { "유재석", "정형돈", "박나래", "하하", "박명수" };
		int[] nums = new int[5];
		nums[0] = 3;
		nums[1] = 2;
		nums[2] = 1;
		nums[3] = 4;
		nums[4] = 5;
		
		
		System.out.println(nums.length);
		// integer 배열 kors의 길이를 나타낸다 //결과: 5

		System.out.println(Arrays.toString(nums));
		// 배열 안의 상태를 확인할 수 있다
		
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		// 배열을 오름차순으로 정렬한다 -> 실행 후 변수를 출력하기
		// 한글도 가능
		
		
	
		System.out.println(name[0].compareTo(name[1]));
		
		// name[0]이 name[1]보다 큰지 비교한다
		// 크다 = 가나다순 오름차순으로 뒤쪽이다! 가 < 하
		// (참이면 양수, 거짓이면 음수, 같으면 0으로 표현)
		  
		  
		 

		//Ex_예제! 이름을 가나다 순으로 정렬
	
		System.out.println(Arrays.toString(name)); //정렬 전
	
		for (int i=0 ; i<name.length-1 ; i++) {
			for (int j=0 ; j<name.length-1-i ; j++) {
			
				//** 비교?
				if (name[j].compareTo(name[j+1]) > 0) {
				
					String temp = name[j];
					name[j] = name[j+1];
					name[j+1] = temp;
				}
			}
		}
	
		System.out.println(Arrays.toString(name));
	
	}
}
