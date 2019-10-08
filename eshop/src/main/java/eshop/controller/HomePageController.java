package eshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {
	
	@RequestMapping("/")
	public String sveikiAtvyke(Model model) {
		model.addAttribute("pasisveikinimas", "Sveiki atvykę į mano e-shop'ą!!");
		model.addAttribute("sloganas", "Vienintelis ir nuostabiausias e-shop'as Lietuvoje (ir ne tik...)");
		return "SveikiAtvyke";
	}
	
	
}