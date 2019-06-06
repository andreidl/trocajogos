package br.com.duarte.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.duarte.model.Desejo;
import br.com.duarte.service.DesejoService;

@RestController
@RequestMapping("desejo")
public class DesejoController {

	@Autowired
	private DesejoService service;

	@GetMapping
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("/desejo");
		mv.addObject("desejos", service.findAll());

		return mv;
	}

	@GetMapping("/add")
	public ModelAndView add(Desejo desejo) {
		ModelAndView mv = new ModelAndView("/desejoAdd");
		mv.addObject("desejo/add", desejo);

		return mv;
	}

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		return add(service.findOne(id));
	}	

	@PostMapping("/save")
	public ModelAndView save(@Valid Desejo post, BindingResult result) {
		if (result.hasErrors()) {
			return add(post);
		}
		service.save(post);
		return findAll();
	}

	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		service.delete(id);
		return findAll();
	}

}
