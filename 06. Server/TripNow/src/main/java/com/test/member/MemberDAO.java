package com.test.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.test.tripnow.DBUtil;

public class MemberDAO {

	private Connection conn;
	private PreparedStatement pstat;
	private Statement stat;
	private ResultSet rs;
	
	public MemberDAO() {
		conn = DBUtil.open();
	}

	public int idcheck(String id) {

		
		try {
			
			String sql = "select count(*) as cnt from tblUser where id = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, id);
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				return rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			System.out.println("MemberDAO.idcheck");
			e.printStackTrace();
		}
		
		
		return 0;
	}

	public int memberadd(MemberDTO dto) {
		
		try {

			String sql = "insert into tblUser values (?, 3, ?, ?, ?, ?, ?, ?)";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getPw());
			pstat.setString(3, dto.getName());
			pstat.setString(4, dto.getTel());
			pstat.setString(5, dto.getBirth());
			pstat.setString(6, dto.getGender());
			pstat.setString(7, dto.getEmail());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("MemberDAO.memberadd");
			e.printStackTrace();
		}
		
		return 0;
	}
	
	
	
	
	
	
	
	
	
}