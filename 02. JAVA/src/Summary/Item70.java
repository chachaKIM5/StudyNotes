package com.test.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Item70 {

	public static void main(String[] args) {
		
		//[SUMMARY] 스트림(stream), 람다식 (2022. 4. 13. 오전 1:02:23)
		
		/*
		 
		 배열, 컬렉션의 탐색 방법
		 
			1) for문 (루프변수)
			2) 향상된 for문
			3) iterator
			4) stream
		  
		 */
		
		
		//배열, 컬렉션, 숫자 범위... 다양한 곳에서 stream을 얻어와 짧은 코딩으로 출력
		
		//배열
		int[] nums1 = { 10, 20, 30, 40 };
		Arrays.stream(nums1).forEach(num -> System.out.println(num));
	
		
		//컬렉션
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(100);
		list.add(200);
		list.add(300);
		
		list.stream().forEach(num -> System.out.println(num));
		
	
		//숫자 범위
		//Stream<Integer> : 범용 제네릭 스트림 > forEach > Consumer<T>
		//IntStream		  : 전용 스트림	   > forEach > IntConsumer
			//range(1, 10) -> 1 이상 ~ 10 미만
		IntStream.range(1, 10).forEach(num -> System.out.println(num));
		
	}
}
