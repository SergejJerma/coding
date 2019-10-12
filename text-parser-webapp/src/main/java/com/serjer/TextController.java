package com.serjer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TextController {
	@RequestMapping(value = "/input", method = RequestMethod.GET)
	public String showLoginPage() {
		return "input";
	}

	@RequestMapping(value = "/input", method = RequestMethod.POST)
	public String handleUserLogin(ModelMap model, @RequestParam String text) {
		TextParser textParser = new TextParser();
		textParser.start();
		textParser.setText(textParser.countWordsByLastLetter(text));
		model.put("text", textParser.getText());
		return "output";
	}
}
