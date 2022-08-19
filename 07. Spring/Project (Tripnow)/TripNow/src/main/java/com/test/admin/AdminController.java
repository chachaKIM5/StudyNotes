package com.test.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.dto.ActivityListDTO;
import com.test.dto.CarListDTO;
import com.test.dto.HomeListDTO;
import com.test.service.GoodsManageService;

import lombok.Data;

@Controller
public class AdminController {

	@Autowired
	private GoodsManageService service;

	
	@GetMapping("/goodsmanage")
	public String homelist(Model model) {
		
		List<HomeListDTO> hlist = service.homelist();
		List<CarListDTO> clist = service.carlist();
		List<ActivityListDTO> alist = service.activitylist();
		
		model.addAttribute("hlist", hlist);
		model.addAttribute("clist", clist);
		model.addAttribute("alist", alist);
		
		return "admin.main.goodsmanage";
	}
	
	@ResponseBody
	@GetMapping("/goodsearch")
	public Object goodsearch(HttpServletRequest req, Model model) {
		
		String tagtest = req.getParameter("tag");
		if(tagtest.equals("all")) {
			List<HomeListDTO> hlistt = service.homelist();
			List<CarListDTO> clistt = service.carlist();
			List<ActivityListDTO> alistt = service.activitylist();
			
			model.addAttribute("hlist", hlistt);
			model.addAttribute("clist", clistt);
			model.addAttribute("alist", alistt);
			
			AllList list = new AllList();
			list.setHsearch(hlistt);
			list.setCsearch(clistt);
			list.setAsearch(alistt);
			
			return list;
			
		} else if (tagtest.equals("home")) {
			List<HomeListDTO> hlistt = service.homelist();
			model.addAttribute("hlistt", hlistt);
			return hlistt;
		} else if (tagtest.equals("car")) {
			List<CarListDTO> clistt = service.carlist();
			model.addAttribute("clistt", clistt);
			return clistt;
		} else if (tagtest.equals("activity")) {
			List<ActivityListDTO> alistt = service.activitylist();
			model.addAttribute("alistt", alistt);
			return alistt;
		}
		
		return null;
	}
	
	@ResponseBody
	@GetMapping("/homeshow")
	public String homeshow(String seq, String show) {
		
		int num = 0;
		String result = "";
		
		if (show.equals("y")) {
			num = service.homenoshow(seq);
		} else if (show.equals("n")) {
			num = service.homeshow(seq);
		}
		
		if (num == 1) {
			result = service.homeselect(seq);
		}
		
		return result;
		
	}
	
	@ResponseBody
	@GetMapping("/carshow")
	public String carshow(String seq, String show) {
		
		int num = 0;
		String result = "";
		
		if (show.equals("y")) {
			num = service.carnoshow(seq);
		} else if (show.equals("n")) {
			num = service.carshow(seq);
		}
		
		if (num == 1) {
			result = service.carselect(seq);
		}
		
		return result;
		
	}
	
	@ResponseBody
	@GetMapping("/activityshow")
	public String activityshow(String seq, String show) {
		
		int num = 0;
		String result = "";
		
		if (show.equals("y")) {
			num = service.activitynoshow(seq);
		} else if (show.equals("n")) {
			num = service.activityshow(seq);
		}
		
		if (num == 1) {
			result = service.activityselect(seq);
		}
		
		return result;
		
	}
	
	@ResponseBody
	@GetMapping("/idsearch")
	public Object idsearch(String searchword, String selectword, Model model) {
		
		if(selectword.equals("all")) {
			List<HomeListDTO> hsearch = service.homesearch(searchword);
			List<CarListDTO> csearch = service.carsearch(searchword);
			List<ActivityListDTO> asearch = service.activitysearch(searchword);
			
			model.addAttribute("hsearch", hsearch);
			model.addAttribute("csearch", csearch);
			model.addAttribute("asearch", asearch);
			
			AllList list = new AllList();
			list.setHsearch(hsearch);
			list.setCsearch(csearch);
			list.setAsearch(asearch);
			
			return list;			
			
		} else if (selectword.equals("home")) {
			List<HomeListDTO> hsearch = service.homesearch(searchword);
			model.addAttribute("hsearch", hsearch);
			return hsearch;
		} else if (selectword.equals("car")) {
			List<CarListDTO> csearch = service.carsearch(searchword);
			model.addAttribute("csearch", csearch);
			return csearch;
		} else if (selectword.equals("activity")) {
			List<ActivityListDTO> asearch = service.activitysearch(searchword);
			model.addAttribute("asearch", asearch);
			return asearch;
		}
		
		
		
		return null;
		
	}
	
}


@Data
class AllList {
	
	private List<HomeListDTO> hsearch;
	private List<CarListDTO> csearch;
	private List<ActivityListDTO> asearch;
	
}














