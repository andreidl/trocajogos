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

import br.com.duarte.model.Usuario;
import br.com.duarte.service.JogoService;
import br.com.duarte.service.UsuarioService;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	@Autowired
	private JogoService jogoService;

	@GetMapping
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("/usuario");
		mv.addObject("usuarios", service.findAll());

		return mv;
	}

	@GetMapping("/add")
	public ModelAndView add(Usuario usuario) {
		ModelAndView mv = new ModelAndView("/usuarioAdd");
		mv.addObject("usuario/add", usuario);

		return mv;
	}

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		return add(service.findOne(id));
	}

	@PostMapping("/save")
	public ModelAndView save(@Valid Usuario post, BindingResult result) {
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
	
	@GetMapping("/jogos/{id}")
	public ModelAndView jogos(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("/jogo");
		mv.addObject("jogo", jogoService.findByUsuario(id));
		return mv;
	}

}
