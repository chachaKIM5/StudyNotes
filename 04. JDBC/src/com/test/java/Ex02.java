package com.test.java;

import java.sql.Connection;
import mylibrary.db.DBUtil;

public class Ex02 {

	public static void main(String[] args) {
		
		//Ex02.java
		
		try {
		
			Connection conn = DBUtil.open();
	
			System.out.println(conn.isClosed() ? "연결 실패" : "연결 성공");
			
			DBUtil.close();
			
			//오류 알아보기
			//1. 서버 주소를 틀렸을 때
			//IO 오류: The Network Adapter could not establish the connection
			
			//2. 계정 id 틀렸을 때, 암호 틀렸을 때
			//ORA-01017: invalid username/password; logon denied
			
			//3. 오라클 서버가 죽어 있을 때
			//Listener refused the connection with the following error:
			
			//4. 연결 문자열 오류
			//부적합한 Oracle URL이 지정되었습니다
			
			//5. 포트번호 X
			//IO 오류: The Network Adapter could not establish the connection
			//1과 같다... 이유가 다르지만 같은 에러 메시지
			
			//6. 서비스 id 틀리게 적었을 때 (xe -> xi)
			//ORA-12505, TNS:listener does not currently know of SID given in connect 
			
			//7. 드라이브 X
			//java.lang.ClassNotFoundException: 틀린 드라이버 이름
			
			
			conn = DBUtil.open("localhost", "hr", "java1234");
			
			System.out.println(conn.isClosed() ? "연결 실패" : "연결 성공");
			
			DBUtil.close();
			
		} catch (Exception e) {
			System.out.println("Ex02.main");
			e.printStackTrace();
		}
	}
}
