package br.com.duarte.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class IndexController {


	@GetMapping
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("/index");

		return mv;
	}

}
