package com.test.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientController {

	@GetMapping(value="/m1")
	public String m1() {
		
		return "m1";
	}
	
	@GetMapping(value="/m2")
	public String m2() {
		
		return "m2";
	}
	
	
}
