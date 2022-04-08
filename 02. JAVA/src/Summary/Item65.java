package com.test.java;

import java.util.Arrays;
import java.util.Comparator;

public class Item65 {

	public static void main(String[] args) {
		
		//[SUMMARY] Comparator 정렬 (2022. 4. 8. 오후 10:34:37)

		//대표적인 익명 객체 활용 예시
		//Integer는 - 연산, String, Calendar 등 자료형은 compareTo를 사용한다
	
		Integer[] nums = { 5, 3, 2, 4, 1 };
		
		//오름차순
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums)); //[1, 2, 3, 4, 5]
		
		
		//내림차순(직접 구현)
		
		Arrays.sort(nums, new Comparator<Integer>() {
			
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		
		System.out.println(Arrays.toString(nums)); //[5, 4, 3, 2, 1]
		
	
	}
}
