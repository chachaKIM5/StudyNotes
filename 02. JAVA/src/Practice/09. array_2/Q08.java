package com.test.java.question.array2;

public class Q08 {
	
	public static void main(String[] args) {
		
	
		//어려워서 구글링 통해 풀이 본 후에 풀었음..! 혼자 더 연습해볼 것
		
		
		int[][] nums = new int[5][5];
		
		int max = 8;
		int n = 1;
		
		for (int i=0; i<=max ; i++) {
			
			for (int j=0 ; j<5 ; j++) {
				
				for (int k=0 ; k<5 ; k++) {
					
					if (j+k == i) {
						nums[j][k] = n;
						n++;
						
					}
				}
			}
		}

	
		
		//출력(고정)
		for (int i=0 ; i<nums.length ; i++) {
			for (int j=0 ; j<nums[0].length ; j++) {
		
				System.out.printf("%5d", nums[i][j]);
			}
			System.out.println();
		}
		
		
	}//main
	
}



/*
i,j
0,0 = 1

0,1 = 2
1,0 = 3

0,2 = 4
1,1 = 5
2,0 = 6 

0,3 = 7
1,2 = 8
2,1 = 9 
3,0 = 10

0,4 = 11
1,3 = 12
2,2 = 13
3,1 = 14
4,0 = 15

1,4 = 16
2,3 = 17
3,2 = 18
4,1 = 19

2,4 = 20
3,3 = 21
4,2 = 22

3,4 = 23
4,3 = 24

4,4 = 25

*/