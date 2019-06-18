package br.com.duarte.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.duarte.model.Usuario;

@RestController
@RequestMapping("/")
public class Controller {

	@GetMapping
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("/index");

		return mv;
	}

//	@GetMapping("/cadastro")
//	public ModelAndView cadastro() {
//		ModelAndView mv = new ModelAndView("/cadastro");
//		return mv;
//	}
//
//	@PostMapping("/cadastrar")
//	public ModelAndView cadastrar(Usuario usuario) {
//		ModelAndView mv = new ModelAndView("/login");
//		mv.addObject("usuario/add", usuario);
//
//		return mv;
//	}

}
