package com.quiz.indexer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuizIndexerController {

	private static final String VIEW_INDEX = "index";
	private final static Logger logger = LoggerFactory.getLogger(QuizIndexerController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(ModelMap model) {
		return VIEW_INDEX;

	}

	@RequestMapping(value = "/name", method = RequestMethod.GET)
	public String welcomeName(@RequestParam("name") String name, ModelMap model) {
		return VIEW_INDEX;

	}

}