package com.test.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import mylibrary.db.DBUtil;

public class Ex05_PreparedStatement {

	public static void main(String[] args) {
		
		//Ex05_PreparedStatement.java
		
		//m1();
		m2();
		
	} //main

	private static void m2() {

		Connection conn = null;
		Statement stat = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		
		
		try {
			
			conn = DBUtil.open();
			
			//정적 쿼리
			String sql = "select name from tblInsa where num = 1001";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				System.out.println(rs.getString("name"));
			}
			
			rs.close();
			stat.close();
			
			
			
			//동적 쿼리
			sql = "select name from tblInsa where num = ?";
			
			pstat = conn.prepareStatement(sql);
			
			//'?'에 값 넣는 과정 없이 그냥 실행하면? 에러 메시지
			//java.sql.SQLException: 인덱스에서 누락된 IN 또는 OUT 매개변수:: 1
			pstat.setString(1, "1001");
			//pstat.setInt(1,  1001);
			
			rs = pstat.executeQuery(sql);
			
			if (rs.next()) {
				System.out.println(rs.getString("name"));
			}
			
			rs.close();
			pstat.close();
			
			
			
			
			
			//인자가 없는 쿼리인데 pstat으로 한다면? 오류는 없지만... 개발자가 혼돈 겪을 수 있다
			sql = "select count(*) as cnt from tblInsa";
			
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			
			if(rs.next()) {
				System.out.println(rs.getString("cnt"));
			}
			
			rs.close();
			pstat.close();
			
			conn.close();
			
			
			
		} catch (Exception e) {
			System.out.println("Ex05_PreparedStatement.m2");
			e.printStackTrace();
		}
		
	}

	private static void m1() {
	
		//Statement vs PreparedStatement
		// - 목적은 동일하게 'SQL 실행'
		// - 차이: 매개변수 처리 지원 유무
		// - Statement > 정적 SQL
		// - PreparedStatement > 동적 쿼리
		
		//insert > 사용자 입력
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름: ");
		String name = scan.nextLine();		//하하하
		System.out.print("나이: ");
		String age = scan.nextLine();		//20
		System.out.print("전화번호: ");
		String tel = scan.nextLine();		//010-1111-2222
		System.out.print("성별: ");
		String gender = scan.nextLine();	//m
		String address = "서울시 동대문구 이문's동";
		
		//주소에 '가 들어가면 Statement는 오류가 일어남 -> replace로 escape 처리
		//address = address.replace("'", "''");
		
		Connection conn = null;
		Statement stat = null;
		PreparedStatement pstat = null;
		
		try {
			
			conn = DBUtil.open();
			
			String sql = String.format("insert into tblAddress (seq, name, age, gender, tel, address, regdate) values (seqAddress.nextVal, '%s', %s, '%s', '%s', '%s', default)", name, age, gender, tel, address);
			
			stat = conn.createStatement();			//A.
			int result = stat.executeUpdate(sql);	//A. 실행 시 SQL 대입
			System.out.println(result);
			
			
			
			
			//PreparedStatement
			//- ?: 오라클 매개변수
			//- SQL 작성이 용이하다
			//- 매개변수에 부적절한 값이 들어가도 자동으로 escape 시켜준다 (*****)
			sql = "insert into tblAddress (seq, name, age, gender, tel, address, regdate) values (seqAddress.nextVal, ?, ?, ?, ?, ?, default)";
			
			pstat = conn.prepareStatement(sql); //B. 객체를 만듦과 동시에 미리 SQL 대입
			
			//escape가 일어나는 곳 = 인자값에 대한 처리가 추가로 진행 (***)
			// -> 안정성이 높다!
			pstat.setString(1, name); 		//1번째 물음표에 name을 대입한다
			pstat.setString(2, age);		//2번째 물음표에 age를 대입한다
			pstat.setString(3, gender); 	//3번째 물음표에 gender를 대입한다
			pstat.setString(4, tel); 		//4번째 물음표에 tel을 대입한다
			pstat.setString(5, address);	//5번째 물음표에 address를 대입한다
			
			result = pstat.executeUpdate();		//B.
			System.out.println(result);
			
			
			pstat.close();
			stat.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("Ex05_PreparedStatement.m1");
			e.printStackTrace();
		}

		
		
	}
} //Ex05
