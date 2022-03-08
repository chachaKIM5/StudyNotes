package com.test.java;

public class Ex06_Escape {

	public static void main(String[] args) {
		
		//Ex06_Escape.java
		//특수 문자(Escape Sequence), Null
		
		//특수 문자 > Escape Sequence
		//- 컴파일러가 번역을 할 때, 미리 약속된 표현을 만나면 그 표현을 바로 출력하지 않고,
		//  약속에 따라 처리를 한 후에 출력하는 구성 요소
		//- 자료형 > char
		
		
		//1. \n = new line = line feed = 개행 문자
		char c1 = '\n';
		String str = "\n";
		
		//요구사항 > "안녕하세요, 홍길동입니다." 출력해주세요.
		//수정사항 > "안녕하세요.", "홍길동입니다." 각각 다른 라인에 출력
		String msg = "안녕하세요, 홍길동입니다.";
		System.out.println(msg);
		
		String msg1 = "안녕하세요.";
		String msg2 = "홍길동입니다.";
		
		System.out.println(msg1);
		System.out.println(msg2);
		//되긴 되는데 귀찮음
		
		msg = "안녕하세요.\n홍길동입니다.";
		System.out.println(msg);
		
		System.out.println();
		
		//2. \r
		//- carriage return
		//- 커서(캐럿)의 위치를 현재 라인의 맨앞(첫번째 열)으로 이동
		//- 키보드 > Home 키
		//- 이클립스 콘솔에서는 제대로 동작 X
		msg = "안녕하세요.\r홍길동";
		
		System.out.println(msg);
		
		
		//운영체제(OS) 개행문자
		//1. 윈도우: \r\n
		//2. 맥OS: \r
		//3. 리눅스: \n
		
		
		System.out.println("하나\r\n둘");
		System.out.println("하나\n둘");
		//\r\n=\n 같아 보이지만 나중에 달라질 때가 옴,,,
		
		//3. \t
		//- 탭문자, tab
		//- 탭? 4칸 띄기
		//- 탭 > 행동 (X) 지표(O) > 이미 정해져 있는 위치를 표시한 
		//- 서식 작업(열 맞추기)
		
		msg = "하나\t둘\t셋\t넷";  // 확인 쉬움 > 이 방식을 사용
		System.out.println(msg);
		
		msg = "하나	둘	셋	넷"; // 편집기상에서 탭 여부 확인이 불편함 > 잘 사용 안 함
		System.out.println(msg);

		
		//4. \b
		//- Backspace
		//- 콘솔에서 동작, 이클립스에서 동작 X
		
		msg = "홍길동\b입니다.";
		System.out.println(msg); //홍길입니다.
		
		
		
		//5. \", \', \\
		//- 이미 무언가를 하는 문자들을 의미없게 만드는 역할
		
		//요구사항 > 화면에 출력 > 홍길동: "안녕하세요."
		
		//msg = "홍길동: "안녕하세요."";
		//쌍따옴표 다음 가장 먼저 나오는 쌍따옴표를 짝으로 인식해 error

		msg = "홍길동: \"안녕하세요.\"";
		System.out.println(msg);
		
		//요구사항 > 수업 폴더의 경로를 출력하세요.
		//String path = "C:\class\java";
		//컴파일러는 문자열 안에 \를 Escape Sequence로 인식해서 error
		
		//Invalid escape sequence (valid ones are \b \t \n \f \r \" \' \\ )
		String path = "C:\\class\\java";
		System.out.println(path);
	
		
		
		//요구사항 > 변수 2개, 숫자 대입, 더하기 연산 > 연산과정과 결과를 함께 출력해 주세요.
		
		//10 + 20 = 30
		int a = 10;
		int b = 20;
		
		//System.out.println(a + b);
		
		//연산 방향(왼쪽 -> 오른쪽)
		System.out.println(a + " + " + b + " = " + a + b);   //10 + 20 = 1020
		System.out.println(a + " + " + b + " = " + (a + b)); //10 + 20 = 30
		
		
		int num; //NULL 상태
		//System.out.println("숫자: " + num); > error
		//The local variable num may not have been initialized
		
		//현재 num은 null 상태입니다.
		//현재 num은 null값을 가집니다.
		//현재 num은 초기화되어 있지 않습니다.
		
		//int result = num + 100; //100 + 무언가?
		
	}
}
