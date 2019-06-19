package br.com.duarte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.duarte.model.Usuario;
import br.com.duarte.service.UsuarioService;

@RestController
@RequestMapping("/")
public class Controller {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("/index");

		return mv;
	}

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public ModelAndView dashboard() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Usuario Usuario = usuarioService.findUsuarioByLogin(auth.getName());
		modelAndView.addObject("UsuarioName", "Welcome " + Usuario.getNome() + " (" + Usuario.getLogin() + ")");
		modelAndView.addObject("adminMessage", "Content Available Only for Usuarios with Admin Role");
		modelAndView.setViewName("dashboard");
		return modelAndView;
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
