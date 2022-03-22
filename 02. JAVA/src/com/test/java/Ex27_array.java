package com.test.java;

import java.util.Arrays;

public class Ex27_array {

	public static void main(String[] args) {
		
		//Ex27_array.java
		
		//다차원 배열
		// - 배열의 n차원: 차원을 늘려서 더 복잡한 데이터를 담을 수 있다
		
		m1();
		//m2();
		//m3();
		//m4();
		//m5();
		//m6();
		//m7();
	}

	private static void m7() {

		//22/03/21 과제 설명
		//문제 모두 5x5 int 2차원 배열로
		//'성적 그래프'문제 빼고 int로
		
		int[][] nums = new int[5][5];
		
		
		//데이터 입력 > 문제의 요구사항에 따라서 고쳐보기
		int n = 1;
		
		for (int i=0 ; i<5 ; i++) {
			for (int j=4 ; j>=0 ; j--) {
				nums[i][j] = n;
				n++;
			}
		}
		
		
		//데이터 출력 > 절대 수정 금지!

		for (int i=0 ; i<5 ; i++) {
			for (int j=0 ; j<5 ; j++) {
				System.out.printf("%5d", nums[i][j]);
			}
			System.out.println();
		}
	}

	private static void m6() {	// 요소 검색, 단일화, 모듈화
		
		//집합에서 원하는 항목을 검색
		String[] member = { "홍길동", "유재석", "박나래", "정형돈", "박명수", "이광수", "김종국", "노홍철", "강호동", "하하" };
			//요소 검색 > 결과
		//1. boolean
		//2. index
		
	
		//변수값의 초기값 > 실패하거나 아무 일도 일어나지 않았을 때 가져야 할 값으로 초기화한다.
		//				 피해가 가장 적을 것 같다고 생각하는 값
		
		boolean result = false;
		String search = "강호동";
		
		for (int i=0; i<member.length; i++) {
			if (member[i].equals(search)) {
				result = true; //찾았다!!
				break; //불필요한 회전 중단
			}
		}
		
		if (result) {
			System.out.println(search + " 발견!!");
		} else {
			System.out.println(search + " 없음;;");
		}
		
		
		
		//index로 발견 위치까지 출력하자
		int index = -1; //발견 위치, 초기화값을 0으로 설정하면 나중에 오류가 났을 때 member[0]으로 표시될 수도..
		
		for (int i=0; i<member.length; i++) {
			if (member[i].equals(search)) {
				index = i; //찾았다!!
				break; //불필요한 회전 중단
			}
		}
		
		System.out.println(search + "의 위치: " + index);
		
		
		
		
		//코드를 메소드로 -> 단일화, 모듈화
		System.out.println();
		System.out.println(contains(member, search));
		System.out.println(indexOf(member, search));

			
	}

	public static boolean contains(String[] member, String search) { //검색: boolean 반환 모듈화
		
		for (int i=0; i<member.length; i++) {
			if (member[i].equals(search)) {
				return true;
			}
		}
		
		return false;
	}	
	
	public static int indexOf(String[] member, String search) { //검색: int(첨자) 반환 모듈화
		
		for (int i=0; i<member.length; i++) {
			if (member[i].equals(search)) {
				return i;
			}
		}
		
		return -1;
	}			

	private static void m5() {									//Left Shift -> 삭제 문제 (array.Q08)

		
		int[] nums = { 5, 6, 1, 3, 2, 8, 7, 4, 10, 9 }; 
		int index = 5; //삭제 위치
		
		for (int i=index ; i<nums.length-1 ; i++) {
			nums[i] = nums[i+1];	
		}
			
		nums[(nums.length)-1] = 0;
		System.out.println(Arrays.toString(nums));
		
	}
	
	private static void m4() { 									//Right shift -> 삽입 문제 (array.Q07)

		int[] nums = { 5, 6, 1, 3, 2, 0, 0, 0, 0, 0 };
		int index = 4; //삽입 위치
		int value = 100; //삽입 값
		
		
		for(int i=nums.length-2; i>=index ; i--) {
			nums[i+1] = nums[i];
		}
		
		
		nums[index] = value;
		
		System.out.println(Arrays.toString(nums));
	}

	private static void m3() {									//로또 문제 (array.Q06)
		
		//중복되지 않는 임의의 숫자 6개를 만드시오. (로또)
		
		int[] lotto = new int[6];
		boolean isDuplicate = false;
		
		for (int i=0 ; i<lotto.length ; i++) {
			int n = (int)(Math.random() * 45) + 1;
			
			for (int j=0 ; j<i ; j++) {
				if (lotto[j] == n) {
					isDuplicate = true;
					i--;
					break;
				}
			}
			
			if (!isDuplicate) {
				lotto[i] = n;
			}
			
			isDuplicate = false;
			
		}
		
		Arrays.sort(lotto);						   //정렬
		System.out.println(Arrays.toString(lotto)); //덤프


	}

	private static void m2() {				//다차원 배열의 초기화 리스트
		//1차원 배열의 초기화 리스트
		int[] nums1 = { 10, 20, 30 };
		
		//2차원 배열
		// = new int[2][3]
		int[][] nums2 = {{ 10, 20, 30 }, { 40, 50, 60 }};
		
		//3차원 배열
		// = new int[2][2][3]
		int[][][] nums3 = {{{ 10, 20, 30 } , { 40, 50, 60 }} , {{ 10, 20, 30 }, {40, 50, 60}}};
		int[][][] nums4 =
			{
				{
					{ 10, 20, 30 },
					{ 40, 50, 60 }
				},
				{
					{ 10, 20, 30 },
					{ 40, 50, 60 }
				}
			};
		
	}

	private static void m1() {				//다차원 배열의 생성, 탐색, for문

		//1차원 구조
		int[] nums1 = new int[3];			//3열의 배열
		
		
		//2차원 구조
		int[][] nums2 = new int[2][3]; 		//2행 3열의 배열
		
		
		//3차원 구조
		int[][][] nums3 = new int[2][2][3]; //2면 2행 3열의 배열
		
		
		//4차원, 5차원, 6차원, 7차원... 괄호 수만 늘리면 가능하지만 잘 사용하지 않는다
		
		
		//배열 요소 접근(방번호 매기기)
		
		nums1[0] = 100;
		nums1[1] = 200;
		nums1[2] = 300;
		
		
		//2차원 배열 > 차원 2개 > 첨자 2개
		nums2[0][0] = 100;
		nums2[0][1] = 200;
		nums2[0][2] = 300;
		nums2[1][0] = 400;
		nums2[1][1] = 500;
		nums2[1][2] = 600;
		
		
		//3차원 배열 > 차원 3개 > 첨자 3개
		nums3[0][0][0] = 100;
		nums3[0][0][1] = 200;
		nums3[0][0][2] = 300;
		
		nums3[0][1][0] = 400;
		nums3[0][1][1] = 500;
		nums3[0][1][2] = 600;
		
		nums3[1][0][0] = 700;
		nums3[1][0][1] = 800;
		nums3[1][0][2] = 900;

		nums3[1][1][0] = 1000;
		nums3[1][1][1] = 1100;
		nums3[1][1][2] = 1200;
		
		//배열 탐색(조직)
		//- 1차원 배열 > 단일 for문
		//- 2차원 배열 > 2중 for문
		//- 3차원 배열 > 3중 for문
		
		
		//1차원 배열
		
		for (int i=0 ; i<nums1.length ; i++) {
			System.out.printf("nums1[%d] = %d\n", i, nums1[i]);
		}
		System.out.println();
		
		for (int i=0 ; i<nums1.length ; i++) {
			System.out.printf("%5d", nums1[i]);
		} 
		System.out.println();
	
		
		//2차원 배열
		
		for (int i=0 ; i<2 ; i++) {
			for (int j=0 ; j<3 ; j++) {
				System.out.printf("nums2[%d][%d] = %d\n", i, j, nums2[i][j]);
			}
		} System.out.println();
		
		for (int i=0 ; i<nums2.length ; i++) {
			for (int j=0 ; j<nums2[0].length ; j++) {
				System.out.printf("%5d", nums2[i][j]);
			} System.out.println();
		} System.out.println();
		
		
		//3차원 배열
		System.out.println("3차원 배열");
		for (int i=0 ; i<2 ; i++) {
			for (int j=0 ; j<2 ; j++) {
				for (int k=0 ; k<3 ; k++) {
					System.out.printf("nums[%d][%d][%d] = %d\n", i, j, k, nums3[i][j][k]);					
				} System.out.println();
			}
		}
		
		for (int i=0 ; i<nums3.length ; i++) {
			for (int j=0 ; j<nums3[0].length ; j++) {
				for (int k=0 ; k<nums3[0][0].length ; k++) {
					System.out.printf("%5d", nums3[i][j][k]);					
				} System.out.println(); //행
			}System.out.println(); //면
		} System.out.println();
		
	
		
		//다차원 배열의 길이 (=방 개수)
		//면>행>열 상위 차원의 방으로 들어가서 length를 사용한다
		
		//1차원 배열 
		// = new int[3];
		System.out.println(nums1.length); 		
		System.out.println();
		
		//2차원 배열 
		// = new int[2][3];
		System.out.println(nums2.length); 		//2: 행의 개수		
		System.out.println(nums2[0].length);	//3: 열의 개수
		System.out.println();	
		
		//3차원 배열
		// = new int[2][2][3];
		System.out.println(nums3.length);		//2: 면의 개수
		System.out.println(nums3[0].length);	//2: 행의 개수
		System.out.println(nums3[0][0].length);	//3: 열의 개수
		System.out.println();
	}
}

