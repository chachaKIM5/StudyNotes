package com.test.java;

public class Item33 {

	public static void main(String[] args) {
		
		//[SUMMARY] 다차원 배열의 구조, 길이, 초기화 리스트 (2022. 3. 22. 오전 2:39:35)
		
		
		//1차원 구조
		int[] nums1 = new int[3];			//3열의 배열
		//1차원 길이
		System.out.println(nums1.length); 	
		
		
		//2차원 구조
		int[][] nums2 = new int[2][3]; 		//2행 3열의 배열
		//2차원 길이
		System.out.println(nums2.length); 		//2: 행의 개수		
		System.out.println(nums2[0].length);	//3: 열의 개수
		
		
		//3차원 구조
		int[][][] nums3 = new int[2][2][3]; //2면 2행 3열의 배열
		//3차원 길이
		System.out.println(nums3.length);		//2: 면의 개수
		System.out.println(nums3[0].length);	//2: 행의 개수
		System.out.println(nums3[0][0].length);	//3: 열의 개수
		
		//3차원 구조 배열의 초기화 리스트
		int[][][] nums4 = {{{ 10, 20, 30 } , { 40, 50, 60 }} , {{ 10, 20, 30 }, {40, 50, 60}}};
		
	}
}
