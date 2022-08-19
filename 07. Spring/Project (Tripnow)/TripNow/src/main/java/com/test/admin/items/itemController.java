package com.test.admin.items;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.dto.ActDTO;
import com.test.dto.ActOptionDTO;
import com.test.dto.CarDTO;
import com.test.dto.CarOptionDTO;
import com.test.dto.HomeDTO;
import com.test.dto.HomeOptionDTO;
import com.test.service.AdminService;

@Controller
public class itemController {
		
		private AdminService service;

		@Autowired 
		public itemController(AdminService service) {
			this.service = service;
		}
		
		@GetMapping("/admin/registration")
		public String registration(Model model, HttpServletRequest req) {
			
			List<CarDTO> clist = service.clist();
			List<HomeDTO> hlist = service.hlist();
			List<ActDTO> alist = service.alist();
			
			model.addAttribute("clist", clist);
			model.addAttribute("homeList", hlist);
			model.addAttribute("actList", alist);
			
			return "admin.registration.registration";
		}

		@PostMapping("/admin/car")
		public String car(Model model, HttpServletRequest req, CarDTO dto) {
			
			CarOptionDTO coption = service.coption(dto);
			model.addAttribute("caroption", coption);
			
			return "admin.registration.car";
		}
		
		@PostMapping("/admin/act")
		public String act(Model model, HttpServletRequest req, ActDTO dto) {
			
			ActOptionDTO aoption = service.aoption(dto);
			List<String> apath = service.apath(dto);
			aoption.setPeriod(aoption.getPeriod().replace(" 00:00:00", ""));

			model.addAttribute("actoption", aoption);
			model.addAttribute("apath", apath);
			
			return "admin.registration.act";
		}
		
		@PostMapping("/admin/home")
		public String home(Model model, HttpServletRequest req, HomeDTO dto) {
			
			HomeOptionDTO hoption = service.hoption(dto);
			List<String> fpath = service.fpath(dto);

			model.addAttribute("homeoption", hoption);
			model.addAttribute("apath", fpath);
			
			return "admin.registration.home";
		}
		
		@PostMapping("/admin/carrefusal")
		public void carrefusal(HttpServletResponse resp, HttpServletRequest req, String seq) {
			
			int result = service.carrefusal(seq);
			
			try {
				
				if (result == 1) {
					resp.sendRedirect("/tripnow/admin/registration");
				} else {
					resp.sendRedirect("/tripnow/admin/car");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		@PostMapping("/admin/actrefusal")
		public void actrefusal(HttpServletResponse resp, HttpServletRequest req, String seq) {
			
			int result = service.actrefusal(seq);
			
			try {
				
				if (result == 1) {
					resp.sendRedirect("/tripnow/admin/registration");
				} else {
					resp.sendRedirect("/tripnow/admin/act");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		@PostMapping("/admin/homerefusal")
		public void homerefusal(HttpServletResponse resp, HttpServletRequest req, String seq) {
			
			int result = service.homerefusal(seq);
			
			try {
				
				if (result == 1) {
					resp.sendRedirect("/tripnow/admin/registration");
				} else {
					resp.sendRedirect("/tripnow/admin/home");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		@PostMapping("/admin/carcheck")
		public void carcheck(HttpServletResponse resp, HttpServletRequest req, String seq) {
			
			int result = service.carcheck(seq);
			
			try {
				
				if (result == 1) {
					resp.sendRedirect("/tripnow/admin/registration");
				} else {
					resp.sendRedirect("/tripnow/admin/act");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		@PostMapping("/admin/actcheck")
		public void actcheck(HttpServletResponse resp, HttpServletRequest req, String seq) {
			
			int result = service.actcheck(seq);
			
			try {
				
				if (result == 1) {
					resp.sendRedirect("/tripnow/admin/registration");
				} else {
					resp.sendRedirect("/tripnow/admin/act");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		@PostMapping("/admin/homecheck")
		public void homecheck(HttpServletResponse resp, HttpServletRequest req, String seq) {
			
			int result = service.homecheck(seq);
			
			try {
				
				if (result == 1) {
					resp.sendRedirect("/tripnow/admin/registration");
				} else {
					resp.sendRedirect("/tripnow/admin/home");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}