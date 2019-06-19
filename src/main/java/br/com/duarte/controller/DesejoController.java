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
import br.com.duarte.model.Usuario;
import br.com.duarte.service.DesejoService;
import br.com.duarte.service.UsuarioService;

@RestController
@RequestMapping("desejo")
public class DesejoController {

	@Autowired
	private DesejoService service;
	
	//private UsuarioService usuarioService;

	@GetMapping
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("/desejo");
		mv.addObject("desejo", service.findAll());

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

//	@GetMapping("/usuario/{id}")
//	public ModelAndView findByUsuario(Desejo desejo){
//		ModelAndView mv = new ModelAndView("/desejo");
//		Usuario user = usuarioService.findOne(desejo.getDsjIdUsuario());
//		Desejo usuDesejo = service.findByUsuario(user.getId());
//		mv.addObject("usuario", usuDesejo);
//		return mv;
//	}
}
