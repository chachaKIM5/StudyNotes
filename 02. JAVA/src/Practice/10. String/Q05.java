package com.test.java.question.String;

public class Q05 {

	public static void main(String[] args) {
		
		// replace 쓰면 쉽게 풀리지만 되도록 indexOf, substring로 풀길
		// indexOf는 위치를 찾는데? loop 일단 찾고. 지금 찾은 거 + 또 찾고.. 또 찾고 ~ 더는 없다고(-1) 할 때까지
		// 횟수를 찾아 출력해라.
		// 3개, 4개, 5개... 
		
		String content = "안녕~ 길동아~ 잘가~ 길동아~";
		String word = "길동";
		int sum = 0;
		int index = 0;
		
		while (true) {
			
			if (content.indexOf(word, index) > -1) {
				sum++;
				index = content.indexOf(word, index) + word.length() ;
			
			} else {
				break;
			}
		}
		
		System.out.printf("\'%s\'을 총 %d회 발견했습니다.", word, sum);
		
	}
}
