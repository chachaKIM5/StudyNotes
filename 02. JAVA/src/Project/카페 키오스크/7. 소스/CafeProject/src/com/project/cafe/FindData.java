package com.project.cafe;

import com.project.cafe.dataClass.Category;
import com.project.cafe.dataClass.Menu;
import com.project.cafe.dataClass.Option;

public class FindData {
	
	/**
	 * 카테고리 번호를 매개변수로 받아서 해당하는 카테고리명(String)을 반환하는 메소드입니다.
	 * @param seq 카테고리 번호
	 * @return 카테고리 번호에 해당하는 카테고리명 반환
	 */
	public static String findCategoryName(String seq) {
		for(Category c : Data.catelist) {
			if(c.getSeq().equals(seq)) { return c.getName(); }
		}
		return null;
	}
	
	/**
	 * 메뉴 번호를 매개변수로 받아서 해당하는 Menu 객체를 반환하는 메소드입니다.
	 * @param seq 메뉴 번호
	 * @return 메뉴 번호에 해당하는 Menu객체(메뉴번호, 메뉴명, 가격, 카테고리번호) 반환
	 */
	public static Menu findMenu(String seq) {
		
		for(Menu m : Data.mlist) {
			if(m.getSeq().equals(seq)) { return m; }
		}
		return null;
	}

	/**
	 * 얼음량 번호를 매개변수로 받아서 해당하는 Option 객체를 반환하는 메소드입니다.
	 * @param seq 얼음량 번호
	 * @return 얼음량 번호에 해당하는 Option객체(옵션번호, 옵션명, 가격) 반환
	 */
	public static Option findIce(String seq) {
		
		for(Option o : Data.icelist) {
			if(o.getSeq().equals(seq)) { return o; }
		}
		return null;
	}
	
	/**
	 * 시럽 번호를 매개변수로 받아서 해당하는 Option 객체를 반환하는 메소드입니다.
	 * @param seq 시럽 번호
	 * @return 시럽 번호에 해당하는 Option객체(옵션번호, 옵션명, 가격) 반환
	 */
	public static Option findSyrup(String seq) {
		
		for(Option o : Data.srlist) {
			if(o.getSeq().equals(seq)) { return o; }
		}
		return null;
	}
	
	/**
	 * 샷추가 번호를 매개변수로 받아서 해당하는 Option 객체를 반환하는 메소드입니다.
	 * @param seq 샷추가 번호
	 * @return 샷추가 번호에 해당하는 Option객체(옵션번호, 옵션명, 가격) 반환
	 */
	public static Option findShot(String seq) {
		
		for(Option o : Data.shotlist) {
			if(o.getSeq().equals(seq)) { return o; }
		}
		return null;
	}
	
	/**
	 * 휘핑크림 옵션 번호를 매개변수로 받아서 해당하는 Option 객체를 반환하는 메소드입니다.
	 * @param seq 휘핑크림 옵션 번호
	 * @return 휘핑크림 옵션 번호에 해당하는 Option객체(옵션번호, 옵션명, 가격) 반환
	 */
	public static Option findWhipping(String seq) {
		
		for(Option o : Data.wlist) {
			if(o.getSeq().equals(seq)) { return o; }
		}
		return null;
	}
	
	/**
	 * 토핑추가 옵션 번호를 매개변수로 받아서 해당하는 Option 객체를 반환하는 메소드입니다.
	 * @param seq 토핑추가 옵션 번호
	 * @return 토핑추가 옵션 번호에 해당하는 Option객체(옵션번호, 옵션명, 가격) 반환
	 */
	public static Option findTopping(String seq) {
		
		for(Option o : Data.tlist) {
			if(o.getSeq().equals(seq)) { return o; }
		}
		return null;
	}
	
	
	
}











