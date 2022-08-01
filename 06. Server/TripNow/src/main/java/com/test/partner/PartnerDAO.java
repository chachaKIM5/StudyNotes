package com.test.partner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.tripnow.DBUtil;

public class PartnerDAO {

	private Connection conn;
	private PreparedStatement pstat;
	private Statement stat;
	private ResultSet rs;
	
	public PartnerDAO() {
		conn = DBUtil.open();
	}

	public ArrayList<PartnerDTO> getRoomList(HashMap<String, String> map) {
		
		try {
			
			String sql = "select h.name as info1, r.name as info2, hb.startdate as date1, hb.enddate as date2, p.finalprice as price from tblHomeBook hb inner join tblRoom r on hb.rseq = r.seq inner join tblHome h on r.hseq = h.seq inner join tblBookList bl on hb.bseq = bl.seq inner join tblPayment p on bl.seq = p.blseq where h.pid = ? and hb.bsseq in (2, 3) and substr(hb.startdate, 1, 2) = ? and substr(hb.startdate, 4, 2) = ?";
					
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, map.get("id"));
			pstat.setString(2, map.get("syear"));
			pstat.setString(3, map.get("smonth"));
			
			rs = pstat.executeQuery();
			ArrayList<PartnerDTO> list = new ArrayList<PartnerDTO>();
			
			while (rs.next()) {
				
				PartnerDTO dto = new PartnerDTO();
				
				dto.setInfo(rs.getString("info1") + " " + rs.getString("info2"));
				dto.setDate(rs.getString("date1").substring(0, 10) + " ~ " + rs.getString("date2").substring(0, 10));
				dto.setPrice(rs.getString("price"));
				
				list.add(dto);
				
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println("PartnerDAO.getRoomList");
			e.printStackTrace();
		}
		
		return null;
	}

	public ArrayList<PartnerDTO> getCarList(HashMap<String, String> map) {
		
		try {
			
			String sql = "select c.carname as info1, f.value as info2, cb.startdate as date1, cb.enddate as date2, p.finalprice as price from tblCarBook cb inner join tblCar c on cb.cseq = c.seq inner join tblCarName cn on c.carname = cn.seq inner join tblFuel f on c.fseq = f.seq inner join tblBookList bl on cb.bseq = bl.seq inner join tblPayment p on bl.seq = p.blseq where c.pid = ? and cb.bsseq in (2, 3) and substr(cb.startdate, 1, 2) = ? and substr(cb.startdate, 4, 2) = ?";
			
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, map.get("id"));			
			pstat.setString(2, map.get("syear"));
			pstat.setString(3, map.get("smonth"));
			
			rs = pstat.executeQuery();
			ArrayList<PartnerDTO> list = new ArrayList<PartnerDTO>();
			
			while (rs.next()) {
				
				
				PartnerDTO dto = new PartnerDTO();
				
				dto.setInfo(rs.getString("info1") + "(" + rs.getString("info2") + ")");
				dto.setDate(rs.getString("date1").substring(0, 10) + " ~ " + rs.getString("date2").substring(0, 10));
				dto.setPrice(rs.getString("price"));
				
				list.add(dto);
				
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println("PartnerDAO.getCarList");
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<PartnerDTO> getActList(HashMap<String, String> map) {
		try {
			
			String sql = "select a.name as info, ab.regdate as bookdate, p.finalprice as price from tblActivityBook ab inner join tblActivity a on ab.aseq = a.seq inner join tblBookList bl on ab.blseq = bl.seq inner join tblPayment p on p.blseq = bl.seq where a.pid = ? and ab.bsseq in (2, 3) and substr(ab.regdate, 1, 2) = ? and substr(ab.regdate, 4, 2) = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, map.get("id"));			
			pstat.setString(2, map.get("syear"));
			pstat.setString(3, map.get("smonth"));
			
			rs = pstat.executeQuery();
			
			ArrayList<PartnerDTO> list = new ArrayList<PartnerDTO>();
			
			while (rs.next()) {
				
				PartnerDTO dto = new PartnerDTO();
				
				dto.setInfo(rs.getString("info"));
				dto.setDate(rs.getString("bookdate").substring(0, 10));
				dto.setPrice(rs.getString("price"));
				
				list.add(dto);
				
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println("PartnerDAO.getCarList");
			e.printStackTrace();
		}
		return null;
		
	}

	
	
}