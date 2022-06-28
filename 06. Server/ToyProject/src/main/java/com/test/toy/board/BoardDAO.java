package com.test.toy.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpSession;

import com.test.toy.DBUtil;

public class BoardDAO {

	private Connection conn;
	private PreparedStatement pstat;
	private Statement stat;
	private ResultSet rs;
	
	public BoardDAO() {
		conn = DBUtil.open();
	}

	
	//AddOk 서블릿 > dto > 글쓰기
	public int add(BoardDTO dto) {

		try {
			
			String sql = "insert into tblBoard(seq, subject, content, id, regdate, readcount) values (seqBoard.nextVal, ?, ?, ?, default, default)";
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getSubject());
			pstat.setString(2, dto.getContent());
			pstat.setString(3, dto.getId());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("BoardDAO.add");
			e.printStackTrace();
		}
		
		return 0;
		
	}
}
