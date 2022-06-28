package com.test.memo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


// ******** DAO 업무 메소드 규칙! 하나의 업무 메소드에서는 하나의 업무만 진행한다
public class DAO {
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public DAO() {
		
		conn = DBUtil.open();
	}

	
	//AddOk라는 서블릿이 입력받은 데이터(dto)를 주면 insert 해 주는 역할
	public int add(DTO dto) {
		
		try {
			
			String sql = "insert into tblMemo (seq, subject, content, name, pw, regdate) values (seqMemo.nextVal, ?, ?, ?, ?, default)";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getSubject());
			pstat.setString(2, dto.getContent());
			pstat.setString(3, dto.getName());
			pstat.setString(4, dto.getPw());
			
			return pstat.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return 0;
	}


	//List라는 서블릿이 메모 목록을 요청, 메모 목록을 ArrayList로 반환
	public ArrayList<DTO> list() {
		
		try {
			
			String sql = "select * from tblMemo order by regdate desc";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			ArrayList<DTO> list = new ArrayList<DTO>();
			
			while (rs.next()) {
				
				//레코드 1줄 = DTO 1개
				DTO dto = new DTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setName(rs.getString("name"));
				dto.setRegdate(rs.getString("regdate"));

				list.add(dto);
			}
			
			return list;
			
			
		} catch (Exception e) {
			System.out.println("DAO.list");
			e.printStackTrace();
		}
		
		return null;
	}


	//Edit 서블릿이 메모 번호를 주면 레코드 전체를 반환하는 메소드
	public DTO get(String seq) {

		try {
			
			String sql = "select * from tblMemo where seq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			rs = pstat.executeQuery();
			
			
			DTO dto = new DTO();
			
			if (rs.next()) {
				
				dto.setSeq(rs.getString("seq"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setName(rs.getString("name"));
				dto.setRegdate(rs.getString("regdate"));		
			}
		
			return dto; 
			
		} catch (Exception e) {
			System.out.println("DAO.get");
			e.printStackTrace();
		}
		
		return null;
	}

	
	
	//EditOk 서블릿에서 수정할 DTO를 받아 수정 후 결과를 1 혹은 0으로 반환
	public int edit(DTO dto) {
		
		try {
			
			String sql = "update tblMemo set subject = ?, content = ?, name = ? where seq = ?";		
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getSubject());
			pstat.setString(2, dto.getContent());
			pstat.setString(3, dto.getName());
			pstat.setString(4, dto.getSeq());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("DAO.edit");
			e.printStackTrace();
		}
		
		return 0;
	}


	//EditOk, DelOk 서블릿이 메모 번호, 암호를 주면 해당 메모가 존재하는지(count(*) = 1)확인
	public boolean check(DTO dto) {
		
		try {
			
			String sql = "select count(*) as cnt from tblMemo where seq = ? and pw = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getSeq());
			pstat.setString(2, dto.getPw());
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				return rs.getInt("cnt") == 1 ? true : false;
			}
			
		} catch (Exception e) {
			System.out.println("DAO.check");
			e.printStackTrace();
		}
		
		return false;
	}


	//DelOk 서블릿이 seq를 주면 삭제!
	public int del(String seq) {
		
		try {
			
			String sql = "delete from tblMemo where seq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("DAO.del");
			e.printStackTrace();
		}
		
		return 0;
	}
}
