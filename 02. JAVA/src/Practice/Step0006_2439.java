package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Step0006_2439 {

	public static void main(String[] args) throws Exception {
		
		

	//문제 - 별찍기
	//첫번째 줄에 N을 입력하면 첫 번째 줄에는 별 1개, N번째 줄에는 별 N개가 찍힌다
	//이때 별이 정렬된 모양은 아래와 같다
	//    *
	//   **
	//  ***
	// ****
	//*****


		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("입력: ");
		int row = Integer.parseInt(reader.readLine());
		
		
		for (int i=0 ; i<row ; i++) {
			for (int j=0 ; j < row-i-1 ; j++) {
				System.out.print(" ");
			}
			
			for (int k=0 ; k<=i ; k++) {
				System.out.printf("*");

			} System.out.println();	
		}
		
		

	}
}
