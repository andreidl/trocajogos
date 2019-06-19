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

import br.com.duarte.model.Troca;
import br.com.duarte.service.TrocaService;

@RestController
@RequestMapping("troca")
public class TrocaController {

	@Autowired
	private TrocaService service;

	@GetMapping
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("/troca");
		mv.addObject("troca", service.findAll());

		return mv;
	}

	@GetMapping("/add")
	public ModelAndView add(Troca troca) {
		ModelAndView mv = new ModelAndView("/trocaAdd");
		mv.addObject("troca/add", troca);

		return mv;
	}

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("/trocaAdd");
		mv.addObject("troca", service.findOne(id));
		return mv;
	}	

	@PostMapping("/save")
	public ModelAndView save(@Valid Troca post, BindingResult result) {
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
