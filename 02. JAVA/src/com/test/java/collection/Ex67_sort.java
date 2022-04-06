package com.test.java.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;

public class Ex67_sort {

	public static void main(String[] args) {
		
		//Ext67_sort.java
		
		//m1();
		m2();
		
		

		
	}

	private static void m2() {			//배열 > Arrays.sort, 컬렉션 > Collections.sort, 자체 메소드 sort

		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		nums.add(1);
		nums.add(5);
		nums.add(2);
		nums.add(4);
		nums.add(3);
		
		System.out.println(nums); 	//[1, 5, 2, 4, 3]
		
		//Collestions의 sort (오름차순)
		Collections.sort(nums);		
		System.out.println(nums);	//[1, 2, 3, 4, 5]
		
		
		
		//Collestions의 sort (내림차순)
		Collections.sort(nums, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}			
		});
		
		System.out.println(nums);	//[5, 4, 3, 2, 1]
		
		
		
		//자체 메소드 sort
		nums.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		
		System.out.println(nums);
	}

	private static void m1() {
		// TODO Auto-generated method stub
		
		
		//문자열 정렬하기 
		
				System.out.println("A".compareTo("A")); //0
				System.out.println("A".compareTo("B")); //-1
				System.out.println("A".compareTo("C")); //-2
				System.out.println("C".compareTo("A")); //2
				System.out.println("C".compareTo("B")); //1
				
				
				String[] names = { "홍길동", "아무개", "하하하", "호호호", "테스트" };
				
				//오름차순
				Arrays.sort(names);
				
				System.out.println(Arrays.toString(names));
				
				
				
				//내림차순은 직접 구현
				Arrays.sort(names, new Comparator<String>() {

					@Override
					public int compare(String o1, String o2) {

						//o1-o2?
						//문자열끼리는 뺄 수 없음! compareTo 활용
						return o2.compareTo(o1);
					}
				});
				
				System.out.println(Arrays.toString(names));
				
				
				
				
				
				
				
				//2 캘린더 배열 정렬하기
				Calendar[] dates = new Calendar[5];

				for (int i=0 ; i<dates.length ; i++) {
					dates[i] = Calendar.getInstance();
				}
				
				dates[0].add(Calendar.DATE, 7);
				dates[1].add(Calendar.DATE, 2);
				dates[2].add(Calendar.DATE, 5);
				dates[3].add(Calendar.DATE, 1);
				dates[4].add(Calendar.DATE, 4);
				
				for (int i=0 ; i<dates.length ; i++) {
					System.out.printf("%tF\n", dates[i]);
				}
				System.out.println();

				
				//오름차순
				Arrays.sort(dates);
				
				for (int i=0 ; i<dates.length ; i++) {
					System.out.printf("%tF\n", dates[i]);
				}
				System.out.println();
				
				//내림차순
				Arrays.sort(dates, new Comparator<Calendar>() {

					@Override
					public int compare(Calendar o1, Calendar o2) {

						//long자료형인 getTimeInMillis = tick값을 int로 형변환해서 사용해도 되지만,
						//차이가 매우 커질 경우 int범위를 벗어나 값의 손실을 일으킬 수 있다
						//불안하니까 compareTo로 사용하기
						//return (int)(o2.getTimeInMillis() - o1.getTimeInMillis());
						return o2.compareTo(o1);
					}		
				});
				
				for (int i=0 ; i<dates.length ; i++) {
					System.out.printf("%tF\n", dates[i]);
				}
				System.out.println();
				
	}
}
