package com.test.toy.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

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
			
			String sql = "insert into tblBoard(seq, subject, content, id, regdate, readcount, thread, depth) values (seqBoard.nextVal, ?, ?, ?, default, default, ?, ?)";
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getSubject());
			pstat.setString(2, dto.getContent());
			pstat.setString(3, dto.getId());
			pstat.setInt(4, dto.getThread());
			pstat.setInt(5, dto.getDepth());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("BoardDAO.add");
			e.printStackTrace();
		}
		
		return 0;
		
	}

	//List 서블릿 > 목록을 ArrayList<DTO>로 반환
	public ArrayList<BoardDTO> list(HashMap<String, String> map) {
		
		try {
			
			
			String where = "";
			
			if (map.get("isSearch").equals("y")) {
				where = String.format("where %s like '%%%s%%'", map.get("column"), map.get("word"));
			}
			
			String sql = String.format("select * from (select a.*, rownum as rnum from vwBoard a %s) where rnum between %s and %s", where, map.get("begin"), map.get("end"));
			
			stat = conn.createStatement();
			
			rs = stat.executeQuery(sql);
			
			ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
			
			while (rs.next()) {
				
				BoardDTO dto = new BoardDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setSubject(rs.getString("subject"));
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setReadcount(rs.getString("readcount"));
				dto.setCommentcount(rs.getString("commentcount"));
				dto.setDepth(rs.getInt("depth"));
				
				list.add(dto);
				
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println("BoardDAO.list");
			e.printStackTrace();
		}
		
		return null;
	}
	



	//View 서블릿 > 글번호 받아서 글 전체 정보를 가진 dto를 반환
	public BoardDTO get(String seq) {
		
		try {
			
			String sql = "select tblBoard.*, (select name from tblUser where id = tblBoard.id) as name from tblBoard where seq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			rs = pstat.executeQuery();
			
			BoardDTO dto = new BoardDTO();
			
			if (rs.next()) {
				
				dto.setSeq(rs.getString("seq"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setReadcount(rs.getString("readcount"));
				
				dto.setThread(rs.getInt("thread"));
				dto.setDepth(rs.getInt("depth"));
			}
			
			return dto;

		} catch (Exception e) {
			System.out.println("BoardDAO.get");
			e.printStackTrace();
		}
		
		
		
		return null;
	}

	//View 서블릿 > seq > 조회수 증가
	public void updateReadcound(String seq) {
		
		try {
			
			String sql = "update tblBoard set readcount = readcount + 1 where seq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("BoardDAO.updateReadcound");
			e.printStackTrace();
		}
		
	}

	//EditOk 서블릿 > 제목, 내용, seq > update 후 result 반환
	public int edit(BoardDTO dto) {

		try {
			
			String sql = "update tblBoard set subject = ?, content = ? where seq = ?";
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getSubject());
			pstat.setString(2, dto.getContent());
			pstat.setString(3, dto.getSeq());
			
			return pstat.executeUpdate();			
			
			
		} catch (Exception e) {
			System.out.println("BoardDAO.edit");
			e.printStackTrace();
		}
		
		return 0;
		
	}

	
	//DelOk 서블릿 > seq > 삭제
	public int del(String seq) {

		try {
			
			String sql = "delete from tblBoard where seq = ?";
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, seq);
			
			return pstat.executeUpdate();			
			
		} catch (Exception e) {
			System.out.println("BoardDAO.del");
			e.printStackTrace();
		}
		
		return 0;
	}

	
	//AddCommentOk 서블릿 > dto > 댓글 추가!
	public int addComment(CommentDTO dto) {
		
		try {

			String sql = "insert into tblComment(seq, content, id, regdate, pseq) values (seqComment.nextVal, ?, ?, default, ?)";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getContent());
			pstat.setString(2, dto.getId());
			pstat.setString(3, dto.getPseq());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("BoardDAO.addComment");
			e.printStackTrace();
		}
		
		return 0;
	}


	public ArrayList<CommentDTO> listComment(String seq) {

		try {
			
			String sql = "select tblComment.*, (select name from tblUser where id = tblComment.id) as name from tblComment where pseq = ? order by regdate desc";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			rs = pstat.executeQuery();

			ArrayList<CommentDTO> clist = new ArrayList<CommentDTO>();
			
			while (rs.next()) {
				
				CommentDTO dto = new CommentDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setContent(rs.getString("content"));
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setRegdate(rs.getString("regdate"));
				
				clist.add(dto);
			}

			return clist;
			
		} catch (Exception e) {
			System.out.println("BoardDAO.listComment");
			e.printStackTrace();
		}
		
		return null;
	}


	//DelCommentOk > seq > 댓글 삭제
	public int delcomment(String seq) {
		
		try {
			
			String sql = "delete from tblComment where seq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			return pstat.executeUpdate();

		} catch (Exception e) {
			System.out.println("BoardDAO.delcomment");
			e.printStackTrace();
		}
		
		
		return 0;
	}


	//EditCommentOk > dto(seq, content) > 댓글 수정
	public int editComment(CommentDTO dto) {
		
		try {

			String sql = "update tblComment set content = ? where seq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getContent());
			pstat.setString(2, dto.getSeq());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("BoardDAO.editComment");
			e.printStackTrace();
		}
		
		return 0;
	}


	//DelOk > seq > 딸린 댓글들 모두 지우기
	public void delCommentAll(String seq) {
		
		try {
			
			String sql = "delete from tblComment where pseq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("BoardDAO.delCommentAll");
			e.printStackTrace();
		}
	}


	//List 서블릿 > 총 게시물 수 구하기
	public int getTotalCount(HashMap<String, String> map) {
		
		try {
			
			String where = "";
			
			if (map.get("isSearch").equals("y")) {
				where = String.format("where %s like '%%%s%%'", map.get("column"), map.get("word"));
			}
			
			
			String sql = "select count(*) as cnt from tblBoard " + where;
			
			pstat = conn.prepareStatement(sql);
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				return rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			System.out.println("BoardDAO.getTotalCount");
			e.printStackTrace();
		}
		
		return 0;
	}

	
	
	//AddOk 서블릿 > Thread 최대값 반환
	public int getMaxThread() {

		try {
			
			String sql = "select nvl(max(thread), 0) as thread from tblBoard";
			
			stat = conn.createStatement();
			
			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				return rs.getInt("thread");
			}
			
		} catch (Exception e) {
			System.out.println("BoardDAO.getMaxThread");
			e.printStackTrace();
		}
		
		return 0;
	}


	
	//AddOk > map(부모 thread, 이전 새글 thread) > thread 업데이트
	public void updateThread(HashMap<String, Integer> map) {

		try {
			
			String sql = "update tblBoard set thread = thread - 1 where thread > ? and thread < ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setInt(1, map.get("previousThread"));
			pstat.setInt(2, map.get("parentThread"));
			
			pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("BoardDAO.updateThread");
			e.printStackTrace();
		}
		
	}
}
