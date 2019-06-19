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

import br.com.duarte.model.Emprestimo;
import br.com.duarte.service.EmprestimoService;

@RestController
@RequestMapping("emprestimo")
public class EmprestimoController {

	@Autowired
	private EmprestimoService service;

	@GetMapping
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("/emprestimo");
		mv.addObject("emprestimo", service.findAll());

		return mv;
	}

	@GetMapping("/add")
	public ModelAndView add(Emprestimo emprestimo) {
		ModelAndView mv = new ModelAndView("/emprestimoAdd");
		mv.addObject("emprestimo/add", emprestimo);

		return mv;
	}

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		return add(service.findOne(id));
	}	

	@PostMapping("/save")
	public ModelAndView save(@Valid Emprestimo post, BindingResult result) {
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
