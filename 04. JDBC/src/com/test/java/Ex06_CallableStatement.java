package com.test.java;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;
import mylibrary.db.DBUtil;
import oracle.jdbc.OracleTypes;

public class Ex06_CallableStatement {

	public static void main(String[] args) {
		
		//Ex06_CallableStatement.java
		//JDBC는 기본적으로 모든 SQL 실행을 자동 커밋(executeXXX() 호출할 때마다)
		
		//m1();
		//m2();
		//m3();
		//m4();
		//m5();
		m6();
	}

	private static void m6() {

		//문제] 부서명 입력 > 부서 직원들의 보너스 지급 내역 출력
		Connection conn = null;
		CallableStatement cstat = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.open();
			Scanner scan = new Scanner(System.in);
			
			System.out.print("부서명: ");
			String buseo = scan.nextLine();
			System.out.println();
			
			String sql = "{ call procM6(?, ?) }";
			cstat = conn.prepareCall(sql);
			
			cstat.setString(1, buseo);
			cstat.registerOutParameter(2, OracleTypes.CURSOR);
			
			cstat.executeQuery();
			
			rs = (ResultSet)cstat.getObject(2);
			
			System.out.println("========== 보너스 지급 내역 ==========");
			System.out.println("[이름]\t[직원번호]\t[보너스 금액]");
			while (rs.next()) {
				//rs(ResultSet)은 cursor를 참조한다
				//rs.getString("변수이름")은 프로시저의 open cursor 밑 컬럼 이름
				System.out.printf("%s\t%s\t\t%,9d원\r\n"
										, rs.getString("name")
										, rs.getString("num")
										//the column value; if the value is SQL NULL, thevalue returned is 0
										, rs.getInt("bonus"));
			}
			
			rs.close();
			cstat.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println("Ex06_CallableStatement.m6");
			e.printStackTrace();
		}
	}

	private static void m5() {

		Connection conn = null;
		CallableStatement cstat = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.open();
			
			String sql = "{ call procM5(?, ?) }";
			cstat = conn.prepareCall(sql);
			
			
			cstat.setString(1, "개발부");
			cstat.registerOutParameter(2, OracleTypes.CURSOR);
			
			
			//실행
			cstat.executeQuery();
			
			//오라클 커서 == 자바 ResultSet ********** 
			rs = (ResultSet)cstat.getObject(2);
			
			while (rs.next()) {
				System.out.println(rs.getString("name"));
				System.out.println(rs.getString("jikwi"));
				System.out.println(rs.getString("basicpay"));
				System.out.println();
			}
			
			rs.close();
			cstat.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println("Ex06_CallableStatement.m5");
			e.printStackTrace();
		}
		
		
	}

	private static void m4() {

		
		//문제] 직원 번호를 입력하면 이름, 부서, 직위, 지역을 반환하고 출력
		//procM4 (in 직원번호, out 이름, 부서, 직위, 지역)
		Connection conn = null;
		CallableStatement cstat = null;
		Scanner scan = new Scanner(System.in);
		
		try {
		
			System.out.print("직원 번호를 입력하세요.: ");
			String num = scan.nextLine();
			
			conn = DBUtil.open();
			
			String sql = "{ call procM4(?, ?, ?, ?, ?) }";
			
			cstat = conn.prepareCall(sql);
			
			cstat.setString(1, num);
			cstat.registerOutParameter(2, OracleTypes.VARCHAR);
			cstat.registerOutParameter(3, OracleTypes.VARCHAR);
			cstat.registerOutParameter(4, OracleTypes.VARCHAR);
			cstat.registerOutParameter(5, OracleTypes.VARCHAR);
			
			cstat.executeQuery();
			
			String name = cstat.getString(2);
			String buseo = cstat.getString(3);
			String jikwi = cstat.getString(4);
			String city = cstat.getString(5);
			
			System.out.printf("\r\n입력하신 %s번 직원의 정보입니다.\r\n", num);
			System.out.printf("[이름] %s\r\n", name);
			System.out.printf("[부서] %s\r\n", buseo);
			System.out.printf("[직위] %s\r\n", jikwi);
			System.out.printf("[지역] %s", city);
			
			cstat.close();
			conn.close();
		
			
		} catch (Exception e) {
			System.out.println("Ex06_CallableStatement.m4");
			e.printStackTrace();
		}
		
	}

	private static void m3() {

		Connection conn = null;
		CallableStatement cstat = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.open();
			
			String sql = "{ call procM3(?) }";
			
			cstat = conn.prepareCall(sql);
			
			//in 매개변수  -> stat.setString(인덱스, 값)
			//out 매개변수 -> stat.registerOutParameter(인덱스, OracleTypes.오라클자료형);
			
			cstat.registerOutParameter(1, OracleTypes.NUMBER);
			
			//PLSQL 문에서 인출을 수행할 수 없습니다.: next
			//rs = cstat.executeQuery();
			//System.out.println(rs.next());
			
			cstat.executeQuery(); //rs X
			int count = cstat.getInt(1); //Out Parameter를 가져오는 역할
			
			System.out.println(count);
			
			cstat.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println("Ex06_CallableStatement.m3");
			e.printStackTrace();
		}
		
	}

	private static void m2() {

		Connection conn = null;
		CallableStatement cstat = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.open();
			//String sql = "{ call procM2('상수', 22, 'm', '010-2222-2222', '주소') }";
			String sql = "{ call procM2(?, ?, ?, ?, ?) }";
			
			cstat = conn.prepareCall(sql);
			
			cstat.setString(1, "홍길동");
			cstat.setString(2, "25");
			cstat.setString(3, "m");
			cstat.setString(4, "010-1234-5432");
			cstat.setString(5, "서울시 용산구 효창동");
			
			
			int result = cstat.executeUpdate();
			
			System.out.println(result);
			
			cstat.close();
			conn.close();
			
			
		} catch (Exception e) {
			System.out.println("Ex06_CallableStatement.m2");
			e.printStackTrace();
		}
		
	}

	private static void m1() {

		//Statement > 정적 쿼리
		//PreparedStatement > 동적 쿼리
		//CallableStatement > 프로시저 호출
		
		
		Connection conn = null;
		CallableStatement cstat = null;
		ResultSet rs = null;
		
		
		try {
			
			conn = DBUtil.open();
			//프로시저 호출 구문
			String sql = "{ call procM1 }";
			
			cstat = conn.prepareCall(sql); //매개변수 처리 능력 보유 > ? 지원
			
			int result = cstat.executeUpdate();
			System.out.println(result);
			
			cstat.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println("Ex06_CallableStatement.m1");
			e.printStackTrace();
		}
		
		
	}
}
