package com.example.__controllertoview;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping("/send")
	public String sendData(Model model) {
		model.addAttribute("id", 102);
		model.addAttribute("name", "Pranav Surve");
		model.addAttribute("age", 22);
		return "display";
	}
}
