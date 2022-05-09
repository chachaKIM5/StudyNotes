package com.test.java;

import java.sql.Connection;
import java.sql.DriverManager;

public class Ex01 {

	public static void main(String[] args) {
		
		//Ex01.java

		/*
		 
		  	JDBC 설정
		  	- 각 데이터베이스별로 관련 클래스 제공 > *.jar
		  	- DBMS 회사에서 배포(***) or Oracle에서 배포
		  	- Oracle 설치 > 그 안에 같이 배포 > "ojdbc6.jar"
		  	  'C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib'
		  	
		  	1. JDBCTest > "lib" 폴더 만들기 > ojdbc6.jar 복사본 붙여넣기
		  	2. 이클립스 내 package explorer 새로고침, 프로젝트 오른쪽마우스 - Build path - configure build path
		  	3. libarary 탭에서 classpath 선택, add jar 누르고 1에서 붙여넣기한 lib 폴더의 jar파일 선택, 추가
		  
		  
		  JDBC, Java Database Connectivity
		  1. JDBC
		  2. Spring-JDBC
		  3. MyBatis
		  
		  [사람 + SQL Developer <- SQL -> Oracle Server]
		  1. 클라이언트 툴 실행
		  2. DB 서버 접속
		  	2.1 호스트명: 서버 IP or 도메인 주소 > localhost
		  	2.2 포트번호: 1521
		  	2.3 SID: xe
		  	2.4 드라이버: thin
		  	2.5 사용명: hr
		  	2.6 암호: java1234
		  3. 질의
		  	3.1 SQL 사용
		  	3.2 반환값이 없는 쿼리
		  		- select를 제외한 모든 쿼리
		  	3.3 반환값이 있는 쿼리
		  		- select
		  		- 결과셋을 반환하는 쿼리
		  		- 결과셋을 업무에 사용 (*****)
		  4. 접속 종료
		  	4.1 commit/rollback
		  	4.2 접속 종료
		  	
		  	
		  [자바프로그램 + JDBC <- SQL -> Oracle Server]
		  1. 자바 응용 프로그램 실행 (+JDBC)
		  2. DB 서버 접속
		  	2.1 호스트명: 서버 IP or 도메인 주소 > localhost
		  	2.2 포트번호: 1521
		  	2.3 SID: xe
		  	2.4 드라이버: thin
		  	2.5 사용명: hr
		  	2.6 암호: java1234
		  3. 질의
		  	- JDBC > Statement 클래스 사용
		  	3.1 SQL 사용
		  	3.2 반환값이 없는 쿼리
		  		- select를 제외한 모든 쿼리
		  	3.3 반환값이 있는 쿼리
		  		- select
		  		- 결과셋을 반환하는 쿼리
		  		- 결과셋을 업무에 사용 (*****)
		  		- 결과셋으로 ResultSet 클래스를 사용해서 반환
		  			> ResultSet 탐색 (= select 결과셋을 탐색)
		  4. 접속 종료
		  	- JDBC > Connection 클래스 사용
		  	4.1 commit/rollback
		  	4.2 접속 종료
		  	
		  	
		  	
		  JDBC 라이브러리 클래스
		  	- Connection, Statement, ResultSet 클래스
		  	
		 
		 */
		
		
		System.out.println("[데이터베이스 접속하기]");
		
//		  1. 자바 응용 프로그램 실행 (+JDBC)
//		  2. DB 서버 접속
//		  	2.1 호스트명: 서버 IP or 도메인 주소 > localhost
//		  	2.2 포트번호: 1521
//		  	2.3 SID: xe
//		  	2.4 드라이버: thin
//		  	2.5 사용명: hr
//		  	2.6 암호: java1234
		
		//java.sql 안에 들어있는 connection import
		Connection conn = null;
		
		//연결 문자열, Connection String > 접속 정보 문자열
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "hr";
		String pw = "java1234";
		
		//JDBC 작업 > 외부 입출력 > 예외 처리 필수
				
		try {
		
			//JDBC 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//Connection 객체 생성 (*****)
			// > 오라클에 접속된 정보를 conn 객체가 가지고 있다. (*****)
			conn = DriverManager.getConnection(url, id, pw);
			
			System.out.println(conn.isClosed()); // 접속 상태 확인
			
			//업무 진행~ Query
			// *** 항상 conn.isClose()가 false 일 때만 SQL을 처리
			System.out.println("업무 진행");
			
			//접속 종료
			conn.close();
			System.out.println(conn.isClosed()); // 접속 상태 확인
			
		} catch (Exception e) {
			System.out.println("Ex01.main");
			e.printStackTrace();
		}
		
		
	} //main
} //Ex01
