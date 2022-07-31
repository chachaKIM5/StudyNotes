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
			
			String sql = "select h.name as info1, r.name as info2, hb.startdate as date1, hb.enddate as date2, p.finalprice as price from tblHomeBook hb inner join tblRoom r on hb.rseq = r.seq inner join tblHome h on r.hseq = h.seq inner join tblBookList bl on hb.bseq = bl.seq inner join tblPayment p on bl.seq = p.blseq where h.pid = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, map.get("id"));
			
			
			
		} catch (Exception e) {
			System.out.println("PartnerDAO.getRoomList");
			e.printStackTrace();
		}
		
		return null;
	}

	
	
}