package com.quiz.admin.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuizMakerIndexerController {

	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(QuizMakerIndexerController.class);

	@RequestMapping(value = "/questionPanel", method = RequestMethod.GET)
	public String welcome(ModelMap model) {

		model.addAttribute("message", "Welcome");
		return "questionPanel";

	}

	// e.g url : http://localhost:8087/QuizAdmin/questionPanel/your_name?name=Sandeep
	@RequestMapping(value = "/questionPanel/your_name", method = RequestMethod.GET)
	public String welcomeName(@RequestParam("name") String name, ModelMap model) {

		model.addAttribute("message", "Welcome " + name);
		return "questionPanel";

	}
}