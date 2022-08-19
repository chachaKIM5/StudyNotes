package com.test.activity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.test.member.MemberDTO;
import com.test.tripnow.DBUtil;

public class ActivityDAO {
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	
	public ActivityDAO() {
		conn = DBUtil.open();
	}


	public ArrayList<ActivityDTO> list(ActivityDTO dto) {
		try {
			
			if(dto.getCounty() == null) {
				

				
				String sql = "select * from tblActivity where location like  ?||'%%' and period >= ? and rseq like '2' and show like 'y'";
				
				pstat = conn.prepareStatement(sql);
				
				pstat.setString(1, dto.getRegion());
				pstat.setString(2, dto.getDate());
				
				rs = pstat.executeQuery();
				
				ArrayList<ActivityDTO> list = new ArrayList<ActivityDTO>();
				
				
				
				
				while(rs.next()) {
					
					ActivityDTO listDto = new ActivityDTO();
										
					listDto.setSeq(rs.getString("seq"));
					listDto.setPid(rs.getString("pid"));
					listDto.setName(rs.getString("name"));
					listDto.setLocation(rs.getString("location"));
					listDto.setPeriod(rs.getString("period"));
					listDto.setPrice(rs.getInt("price"));
					listDto.setContent(rs.getString("content"));
					listDto.setPath(rs.getString("path"));
					listDto.setFpath(rs.getString("fpath"));
					listDto.setShow(rs.getString("show"));
					listDto.setRegion(dto.getRegion());
					
					
					
					sql = "select avg(star) as avgstar from tblActivityReview ar inner join tblActivitybook ab on ab.seq = ar.rseq where ab.aseq like ?";
					
					pstat = conn.prepareStatement(sql);
					
					pstat.setString(1,rs.getString("seq"));
					
					ResultSet rs1;
					rs1 = pstat.executeQuery();
					
					while(rs1.next()) {
						
						
						int avgstar = (int)rs1.getDouble("avgstar");
						
							listDto.setAvgstar(avgstar);
						
					}
					
					
					
					
					
				
					list.add(listDto);
					
				}
				
				
				
				
				return list;
				
				
				
			}else {
				
				String [] county = dto.getCounty().split("/");
				
				String sql = "select * from tblActivity where (";
				
				String location = "";
				
				
				for(int i =0 ; i < county.length ; i++) {

					 location += String.format("location like '%s%%%s%%'",dto.getCity(),county[i]);
					
					if(i < county.length-1) {
						location += " or ";
					}
					
				}
				
				String date = String.format(")and period >= '%s' and rseq like '2' and show like 'y' ",dto.getDate());
				
				sql = sql + location + date;
				
				
				stat = conn.createStatement();
				
				rs = stat.executeQuery(sql);
				
				ArrayList<ActivityDTO> list = new ArrayList<ActivityDTO>();
				
				while(rs.next()) {
					
					ActivityDTO listDto = new ActivityDTO();
					
					listDto.setSeq(rs.getString("seq"));
					listDto.setPid(rs.getString("pid"));
					listDto.setName(rs.getString("name"));
					listDto.setLocation(rs.getString("location"));
					listDto.setPeriod(rs.getString("period"));
					listDto.setPrice(rs.getInt("price"));
					listDto.setContent(rs.getString("content"));
					listDto.setPath(rs.getString("path"));
					listDto.setFpath(rs.getString("fpath"));
					listDto.setShow(rs.getString("show"));
					listDto.setRegion(dto.getRegion());
					
					sql = "select avg(star) as avgstar from tblActivityReview ar inner join tblActivitybook ab on ab.seq = ar.rseq where ab.aseq like ?";
					
					pstat = conn.prepareStatement(sql);
					
					pstat.setString(1,rs.getString("seq"));
					
					ResultSet rs1;
					rs1 = pstat.executeQuery();
					
					while(rs1.next()) {
						
						
						int avgstar = (int)rs1.getDouble("avgstar");
						
							listDto.setAvgstar(avgstar);
						
					}
					
					
					list.add(listDto);
					
				}
				return list;
				
			}
			
			
			
		} catch (Exception e) {
			System.out.println("ActivityDAO.list");
			e.printStackTrace();
		}
		return null;
	}

	// ActivityView.do에서 전달한 seq값을 바탕으로 상품 정보 조회 
	public ActivityDTO view(ActivityDTO dto) {
		
		try {
			
			String sql = "select * from tblActivity where seq = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getSeq());
			
			rs = pstat.executeQuery();
			
			
			while(rs.next()) {
				
				dto.setSeq(rs.getString("seq"));
				dto.setPid(rs.getString("pid"));
				dto.setName(rs.getString("name"));
				dto.setLocation(rs.getString("location"));
				dto.setPeriod(rs.getString("period"));
				dto.setPrice(rs.getInt("price"));
				dto.setContent(rs.getString("content"));
				dto.setPath(rs.getString("path"));
				dto.setShow(rs.getString("show"));
				
				if(dto.getCount() != null) {
				
				int totalPrice = dto.getPrice() * Integer.parseInt(dto.getCount());
				
				String totalPrice1 = String.format("%,d", totalPrice);
				
				dto.setTotalPrice(totalPrice1);
				}
								
			}
			
			//이미지 몇개인지 ? view 사진 넘기기에 필요
			sql = "select count(*) as count from tblActphoto where aseq = ?";
					
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getSeq());
			
			rs = pstat.executeQuery();
			
			
			while(rs.next()) {
				dto.setImagecount(rs.getInt("count"));
			}
			
			
			sql = "select avg(star) as avgstar from tblActivityReview ar inner join tblActivitybook ab on ab.seq = ar.rseq where ab.aseq like ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getSeq());
			
			rs = pstat.executeQuery();
			
			while(rs.next()) {
				
				int avgstar = (int)rs.getDouble("avgstar");
				
					
				dto.setAvgstar(avgstar);
				
			}
			
			
			
			
			return dto;
			
			
		} catch (Exception e) {
			System.out.println("ActivityDAO.view");
			e.printStackTrace();
		}
		
		return null;
	}


	public ArrayList<ActivityDTO> getImages(ActivityDTO dto) {
		try {
			
			// 선택한 상품의 사진들 가져오기
			String sql = "select * from tblActPhoto where aseq = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getSeq());
			
			rs = pstat.executeQuery();
			
			ArrayList<ActivityDTO> imagelist = new ArrayList<ActivityDTO>();
			
			int imagecount = 0;
			
			while(rs.next()) {
				
				ActivityDTO imageDto = new ActivityDTO();
				
				imageDto.setPath(rs.getString("path"));

				
				imagelist.add(imageDto);
				
			}
			
			return imagelist;
			
			
			
			
		} catch (Exception e) {
			System.out.println("ActivityDAO.getImages");
			e.printStackTrace();
		}
		return null;
	}

	


	public ArrayList<ActReviewDTO> review(String seq) {
		
		try {
			
			
			
			String sql = "select q.*, a.content as acontent from tblActivityReview q left outer join tblActivityReply a on q.seq = a.rseq inner join tblActivityBook ab on ab.seq = q.rseq  where ab.aseq = ?";
			
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, seq);
			
			rs = pstat.executeQuery();	
			
			ArrayList<ActReviewDTO> reviewlist = new ArrayList<ActReviewDTO>();
			
			while (rs.next()) {
				
				ActReviewDTO dto =  new ActReviewDTO();
				
				//작성자 id,별점,등록일,내용
				dto.setSeq(rs.getString("seq"));
				dto.setId(rs.getString("ID"));
				dto.setStar(rs.getString("star"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setContent(rs.getString("content"));
				
				if(rs.getString("acontent") != null) {
					dto.setAcontent(rs.getString("acontent"));
				}
				reviewlist.add(dto);
				
				
			}
			
			return reviewlist;
			
			
		} catch (Exception e) {
			System.out.println("ActivityDAO.review");
			e.printStackTrace();
		}	
		
		return null;
	}


	public MemberDTO getInfo(String id) {
		try {
			
			String sql = "select * from tbluser where id like ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, id);
			
			rs = pstat.executeQuery();	
			
			MemberDTO dto = new MemberDTO();
			
			while(rs.next()) {
				
				dto.setName(rs.getString("name"));
				dto.setTel(rs.getString("tel"));
				dto.setEmail(rs.getString("email"));
				dto.setId(rs.getString("id"));
	
				
			}
			
			return dto;
			
			
		} catch (Exception e) {
			System.out.println("ActivityDAO.getInfo");
			e.printStackTrace();
		}
		return null;
	}


	public ActBookDTO actBook(ActBookDTO dto) {
		
		try {
			
			// 예약 리스트에 추가
			String sql ="insert into tblbooklist values((select max(seq)+1 from tblbooklist),?)";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getId());
			
			pstat.executeUpdate();
						
			//예약리스트 seq 받아오기 >결제, 예약 테이블 추가에 필요함;
			sql = "select MAX(seq) as blseq from tblbooklist where id like ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getId());
			
			rs = pstat.executeQuery();
			
			while(rs.next()) {
				
				// 예약리스트 번호
				dto.setBlseq(rs.getString("blseq"));
				
			}
			
			
			
			//결제 테이블 추가
			sql ="insert into tblPayment values ((select max(seq)+1 from tblPayment),?,'N',?)";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getBlseq());
			pstat.setString(2, dto.getTotalprice());
			
			pstat.executeUpdate();
			
			//엑티비티 예약에 추가
			
			sql="insert into tblActivityBook (seq,pseq,aseq,id,blseq,bsseq,regdate,count) values ((select max(seq)+1 from tblActivityBook),1,?,?,?,1,default,?)";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getAseq());
			pstat.setString(2, dto.getId());
			pstat.setString(3, dto.getBlseq());
			pstat.setString(4, dto.getCount());
			
			
			pstat.executeUpdate();
			
			
			
			//주문한 날짜 dto로 가져오기
			sql = "select regdate from tblActivityBook where blseq like ? ";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getBlseq());
			
			rs = pstat.executeQuery();
			
			while(rs.next()) {
				
				// 예약리스트 번호
				dto.setRegdate(rs.getString("regdate"));
				
			}	
			
			
			
			
			
			return dto;
		
			
			
			
		} catch (Exception e) {
			System.out.println("ActivityDAO.actBook");
			e.printStackTrace();
		}
		
		
		return null;
	}


	public ActivityDTO getAccountNum(String partnerId) {
		try {
			
			String sql = "select * from tblAccount where id like ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, partnerId);
			
			rs = pstat.executeQuery();
			
			ActivityDTO Sdto = new ActivityDTO();
			
			while(rs.next()) {
				
				Sdto.setBank(rs.getString("bank"));
				Sdto.setAccountnum(rs.getString("acnumber"));

			}	
			
			
			
			
			
			return Sdto;
			
			
			
		} catch (Exception e) {
			System.out.println("ActivityDAO.getAccountNum");
			e.printStackTrace();
		}
		return null;
	}



	public ActReviewDTO addReviewCheck(ActReviewDTO rdto) {
			try {
			

				
			String sql ="select ab.id from tblActivityBook ab left outer join tblActivityReview ar on ab.seq = ar.rseq inner join tblActivity a on ab.aseq = a.seq where ab.regdate +7 > sysdate and a.seq = ? and ab.id = ? and ab.pseq = 2 and ar.content is null";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, rdto.getAseq());
			pstat.setString(2, rdto.getId());
			
			rs = pstat.executeQuery();
			
			while(rs.next()) {
				
				if(rs.getString("id") == null) {
					return null;
				}
				
				rdto.setBookid(rs.getString("id"));

			}	
			
			
			 //예약번호 있으면 보내주기
			
			sql = "select * from tblActivityBook where id= ? ";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, rdto.getBookid());
			
			rs = pstat.executeQuery();
			
			while(rs.next()) {
				
				rdto.setRseq(rs.getString("seq"));
				
			}
			
			return rdto;
			
		} catch (Exception e) {
			System.out.println("ActivityDAO.addReviewCheck");
			e.printStackTrace();
		}
		return null;
	}


	public ActReviewDTO getReview(ActReviewDTO dto) {

		try {
			
			String sql="select * from tblActivityReview where seq = (select max(seq) from tblActivityReview where id like ?)";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getId());
			
			rs = pstat.executeQuery();
			
			
			
			if (rs.next()) {
				
				dto.setSeq(rs.getString("seq"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setId(rs.getString("id"));
				dto.setStar(rs.getString("star"));
				
			}
			
			return dto;
			
		} catch (Exception e) {
			System.out.println("ActivityDAO.getReview");
			e.printStackTrace();
		}
		
		return null;
	}


	public int addReview(ActReviewDTO dto) {
			try {
			
			String sql = "insert into tblActivityReview values ((select max(seq) + 1 from tblActivityReview), ? , ?, ? ,?,default)";

			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getRseq());
			pstat.setString(2, dto.getId());
			pstat.setString(3, dto.getStar());
			pstat.setString(4, dto.getContent());
			
			return pstat.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println("ActivityDAO.addReview");
			e.printStackTrace();
		}
		return 0;
	}


	public int delActReviewOk(String seq) {
		
		try {
			
			String sql = "delete from tblActivityReview where seq = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, seq);
			
			
			
			return pstat.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println("ActivityDAO.delActReviewOk");
			e.printStackTrace();
		}		
		return 0;
	}


	public int editReview(ActReviewDTO dto) {
		try {
			
			String sql = "update tblActivityReview set content = ? where seq = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getContent());
			pstat.setString(2, dto.getSeq());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("ActivityDAO.editReview");
			e.printStackTrace();
		}
		return 0;
	}
	
	public int delact(String seq) {

		
		try {
			String sql = "delete from tblactivity where seq = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, seq);
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("ActivityDAO.delact");
			e.printStackTrace();
		}
		
		
		return 0;
	}


	
}















































