package com.test.java;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import mylibrary.db.DBUtil;

public class Ex04_select {

	public static void main(String[] args) {
		
		//Ex04_select.java
		
		//m1();
		//m2();
		//m3();
		//m4();
		//m5();
		//m6();
		//m7();
		//m8();
		m9();
	}

	private static void m9() {

		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.open();
			stat = conn.createStatement();
			
			//tblAddress 출력
			String sql = "select * from tblAddress order by seq asc";
			
			rs = stat.executeQuery(sql);
			
			while (rs.next()) {
				System.out.println(rs.getString("name"));
				
			}
			
			
			//자원 해제 코드, Clean-up Code
			//rs.close();
			//stat.close();
			//conn.close();
			
		} catch (Exception e) {
			System.out.println("Ex04_select.m9");
			e.printStackTrace();
		}
		
	}

	private static void m8() {

		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.open();
			stat = conn.createStatement();
			
			//요구사항] 영업부 직원 수와 영업부 직원 명단을 출력하시오.
			//		  영업부 직원 명단을 출력한 후 영업부 직원 수를 출력하시오.
			
			String sql = "select * from tblInsa where buseo = '영업부'";
			
			rs = stat.executeQuery(sql);
			
			System.out.println("[직원번호]\t[직원이름]\t[부서]");			
			int n = 0;
			
			while (rs.next()) {
				System.out.printf("%s\t\t%s\t\t%s\r\n", rs.getString("num")
											  , rs.getString("name")
											  , rs.getString("buseo"));
				n++;
			}
			
			//select count문을 다시 한 번 가져오는 것 말고도, while문을 이용해 직원 수 구할 수 있다!
			System.out.println("직원 수: " + n);
			rs.close();
			
			
//			
//			sql = "select count(*) as cnt from tblInsa where buseo = '영업부'";
//			
//			rs = stat.executeQuery(sql);
//			
//			//레코드가 1개라고 확신 = if문으로 커서를 전진시킨다 //레코드가 여러개일 것 가다 = while문
//			if (rs.next()) {
//				System.out.println("직원수: " + rs.getString("cnt"));
//			}
//			
//	
//			rs.close();
			stat.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("Ex04_select.m8");
			e.printStackTrace();
		}
		
	}

	private static void m7() {
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.open();
			stat = conn.createStatement();
			
			//회원명 + 대여한 비디오명
			String sql = "select m.name as mname, v.name as vname from tblVideo v inner join tblRent r on v.seq = r.video inner join tblMember m on m.seq = r.member";
			
			rs = stat.executeQuery(sql);
			
			while (rs.next()) {
				//System.out.println(rs.getString(1));
				//System.out.println(rs.getString(2));
				
				//System.out.println(rs.getString("m.name"));
				//System.out.println(rs.getString("v.name"));
				
				//System.out.println(rs.getString("name"));
				//System.out.println(rs.getString("name_1"));
				
				//System.out.println(rs.getString("name")); //m.name
				//System.out.println(rs.getString("name")); //m.name
				
				//as로 alias를 붙여 출력하는 게 가장 좋은 방법
				System.out.println(rs.getString("mname"));
				System.out.println(rs.getString("vname"));
				System.out.println();
			}
			
			rs.close();
			stat.close();
			conn.close();
			
			
		} catch (Exception e) {
			System.out.println("Ex04_select.m7");
			e.printStackTrace();
		}
		
	}

	private static void m6() { //TODO 필기 놓침, 선생님 파일 보고 따라 쓸 것

		//select > 오류 발생
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.open();
			stat = conn.createStatement();
			
			String sql = "select name, buseo, jikwi from tblInsa";
			
			//java.lang.NullPointerException
			//rs = stat.executeQuery(sql);
			
			while (rs.next()) {
				
				System.out.println(rs.getString("name"));
				System.out.println(rs.getString("buseo"));
				System.out.println(rs.getString("jikwi"));
			}
			
			rs.close();
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println("Ex04_select.m6");
			e.printStackTrace();
		}
		
		
		
	}

	private static void m5() {

		//tblInsa + tblBonus
		//요구사항] 특정 직원에게 보너스를 지급하는 프로그램 만들기
		//1. 모든 직원 명단을 출력(직원번호, 이름, 부서, 직위) > m4() 참조
		//2. 사용자 > 직원을 선택하도록 함 (직원번호 입력)
		//3. 사용자 > 보너스 금액 입력
		//4. 보너스 지급 > tblBonus에 insert
		//5. 지급된 내역을 명단 출력(직원번호, 이름, 부서, 직위, 보너스금액) > m4() 참조, join
		
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.open();
			stat = conn.createStatement();
			Scanner scan = new Scanner(System.in);
			
			String sql = "select num, name, buseo, jikwi from tblInsa order by num asc";
			
			rs = stat.executeQuery(sql);
			
			System.out.println("[번호]\t[이름]\t[부서]\t[직위]");
			
			while (rs.next()) {
				System.out.printf("%s\t%s\t%s\t%s\r\n", rs.getString("num")
												      , rs.getString("name")
												      , rs.getString("buseo")
												      , rs.getString("jikwi"));
			}
			
			
			System.out.print("\r\n번호 입력: ");
			String num = scan.nextLine();
			
			System.out.print("보너스 금액 입력: ");
			String bonus = scan.nextLine();
			
			sql = String.format("insert into tblBonus(seq, num, bonus) values (seqBonus.nextVal, %s, %s)", num, bonus);
			
			rs= stat.executeQuery(sql);
			
			System.out.println("보너스 지급을 완료했습니다.\r\n");
			
			
			
			
			sql = "select i.num, i.name, i.buseo, i.jikwi, b.bonus from tblInsa i inner join tblBonus b on i.num = b.num";
			
			rs = stat.executeQuery(sql);
			
			System.out.println("[번호]\t[이름]\t[부서]\t[직위]\t[보너스 금액]");
			
			while (rs.next()) {
				System.out.printf("%s\t%s\t%s\t%s\t%,d\r\n"
											, rs.getString("num")
											, rs.getString("name")
											, rs.getString("buseo")
											, rs.getString("jikwi")
											, rs.getInt("bonus"));
			}
			
			System.out.println("\r\n프로그램 종료");
			rs.close();
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println("Ex04_select.m5");
			e.printStackTrace();
		}
		
	}

	private static void m4() {

		//다중값 반환
		//- N행 N열
		//- 레코드 N줄 + 컬럼 N개

		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.open();
			stat = conn.createStatement();
			
			Scanner scan = new Scanner(System.in);
			System.out.print("부서를 입력하세요: ");
			String buseo = scan.nextLine();
			
			String sql = "select name, jikwi, city, basicpay from tblInsa where buseo = '" + buseo + "'";
			
			rs = stat.executeQuery(sql);
			
			System.out.println("[번호]\t[이름]\t[직위]\t[지역]\t[급여]");
			int index = 1;
			
			while (rs.next()) {
				System.out.printf("%d\t%s\t%s\t%s\t%,10d원\n"
									, index
									, rs.getString("name")
									, rs.getString("jikwi")
									, rs.getString("city")
									, rs.getInt("basicpay"));
				index++;
			}
			
			rs.close();
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println("Ex04_select.m4");
			e.printStackTrace();
		}
	}

	private static void m3() {

		//다중값 반환
		//- N행 1열
		//- 레코드 N줄 + 컬럼 1개
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.open();
			stat = conn.createStatement();
			
			String sql = "select name from tblInsa order by name";
			
			//59명
			rs = stat.executeQuery(sql);

			//전진 커서, 내려가는 것만 가능하고 거슬러 올라가는 것은 불가능
			rs.next();
			rs.next();
			rs.next();
			
			//56명
			int i = 1;
			while (rs.next()) {
				System.out.println(i + rs.getString("name"));
				i++;
			} //EOF(End Of File)을 만나야 while문에서 탈출
			
			//전진 커서, 에러 메시지: java.sql.SQLException: 결과 집합을 모두 소모했음
			//System.out.println(rs.getString("name"));
			
			
			//ResultSet을 다시 만들기: java.sql.SQLException: ResultSet.next가 호출되지 않았음
			//ResultSet의 커서는 만들어졌을 때 항상 BOF(Begin Of File)을 가리킨다 -> BOF는 데이터가 없음
			//무조건 rs.next()가 한 번 호출되어야 데이터를 가리키기 시작함
			rs = stat.executeQuery(sql);
			System.out.println(rs.getString("name"));
		
			
			rs.close();
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println("Ex04_select.m3");
			e.printStackTrace();
		}
	}

	private static void m2() {

		//다중값 반환
		//- 1행 N열
		//- 레코드 1줄 + 여러개 컬럼
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.open();
			stat = conn.createStatement();
			
			String sql = "select name, age, tel, address from tblAddress where seq = 3";
			
			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				System.out.printf("이름: %s\r\n나이: %s\r\n전화: %s\r\n주소: %s"
										, rs.getString("name")
										, rs.getString("age")
										, rs.getString("tel")
										, rs.getString("address"));
				
			} else {
				System.out.println("데이터가 없습니다.");
			}
			
			rs.close();
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println("Ex04_select.m2");
			e.printStackTrace();
		}
		
		
	}

	private static void m1() {

		//단일값 반환
		//- 1행 1열
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.open();
			stat = conn.createStatement();
			
			String sql = "select count(*) + 100 as cnt from tblInsa";
			
			//반환값 X 쿼리 > executeUpdate();
			//반환값 O 쿼리 > executeQuery(); 
			
			rs = stat.executeQuery(sql);
			
			//Result == 커서(Cursor) > 판독기 > 스트림, Iterator, 향상된 for
			
			rs.next(); //커서를 1줄 전진 > 레코드 위치
			//rs.getXXX(); //현재 커서가 가리키고 있는 레코드의 특정 컬럼값을 가져오기, XXX에는 자료형을 넣는다
			
			int cnt1 = rs.getInt(1); 			//컬럼 순서(Index)
			int cnt2 = rs.getInt("cnt"); 		//컬럼명 (************), alias 붙여두면 편하다
			String cnt3 = rs.getString("cnt");  //같은 자료를 '자바에서 필요한' 자료형으로 가져오기
			
			System.out.println(cnt1);
			System.out.println(cnt2);
			System.out.println(cnt3);
			
			stat.close();
			conn.close();
			rs.close();
			
		} catch (Exception e) {
			System.out.println("Ex04_select.m1");
			e.printStackTrace();
		}
		
	}
}
