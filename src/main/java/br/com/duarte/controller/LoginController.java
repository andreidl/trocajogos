package br.com.duarte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.duarte.model.Usuario;
import br.com.duarte.service.UsuarioService;

@RestController
public class LoginController {

	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView registration() {
		ModelAndView modelAndView = new ModelAndView();
		Usuario Usuario = new Usuario();
		modelAndView.addObject("Usuario", Usuario);
		modelAndView.setViewName("cadastro");
		return modelAndView;
	}


	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Usuario Usuario = usuarioService.findUsuarioByLogin(auth.getName());
		modelAndView.addObject("UsuarioName",
				"Welcome " + Usuario.getNome() + " (" + Usuario.getLogin() + ")");
		modelAndView.addObject("adminMessage", "Content Available Only for Usuarios with Admin Role");
		modelAndView.setViewName("admin/home");
		return modelAndView;
	}
}
