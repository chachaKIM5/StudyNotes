package com.test.toy.etc;

import java.util.Arrays;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Ex03 {

	public static void main(String[] args) throws Exception {
		
		String url = "https://movie.naver.com/movie/running/current.naver";
		
		Document doc = Jsoup.connect(url).get();
		
		Elements list = doc.select("#content .lst_detail_t1 > li");
		
		
		EtcDAO dao = new EtcDAO();
		
		for (Element item : list) {
			
			//item == <li> 태그 1개!
			
			//영화 제목
			String title = item.select(".tit > a").text(); //item.select -> item=<li>태그 이하에서만 검색
			//System.out.println(title);
			
			//개요
			String category = item.select(".info_txt1 dd:nth-child(2) .link_txt").text();
			System.out.println(category);
			
			String dd = item.select(".info_txt1 dd:nth-child(2)").text();
			
			String[] temp = dd.split(" \\| ");
			
			
			//상영 시간
			String time = "";
			
			//개봉일
			String rdate = "";
			if (temp.length == 3) {
				
				time = temp[1].replace("분", "");
				rdate = temp[2].replace(" 개봉", "");

			} else if (temp.length == 2) {
				
				time = temp[0].replace("분", "");
				rdate = temp[1].replace(" 개봉", "");

			}
			
			System.out.println(time);
			System.out.println(rdate);
			
			//감독
			String director = item.select(".info_txt1 dd:nth-child(4) span").text();
			
			System.out.println(director);
			
			//출연
			String actor = item.select(".info_txt1 dd:last-child span").text();
			if (director.equals(actor)) {
				actor = null;
			}
			System.out.println(actor);
			
			//포스터
			String poster = item.select(".thumb img").attr("src");
			System.out.println(poster);
			
			
			MovieDTO dto = new MovieDTO();
			
			dto.setTitle(title);
			dto.setCategory(category);
			dto.setTime(time);
			dto.setRdate(rdate);
			dto.setDirector(director);
			dto.setActor(actor);
			dto.setPoster(poster);
			
			System.out.println(dao.addMovie(dto));
		}
		
	}
}
