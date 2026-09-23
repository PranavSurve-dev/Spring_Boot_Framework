package com.example.__controllertoview;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	@GetMapping("/send")
	public String sendData(Model model) {
		model.addAttribute("id", 102);
		model.addAttribute("name", "Pranav Surve");
		model.addAttribute("age", 22);
		return "display";
	}
	
	@GetMapping("/send2")
	public String sendData2(ModelMap map) {
		map.addAttribute("id", 105);
		map.addAttribute("name", "Surve");
		map.addAttribute("age", 40);
		return "display";
	}
	
	@GetMapping("/send3")
	public ModelAndView sendData3() {
		
		ModelAndView mav = new ModelAndView("display");
		mav.addObject("id", 106);
		mav.addObject("name", "ppp");
		mav.addObject("age", 30);
		return  mav;
	}
	
	
}
