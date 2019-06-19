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

import br.com.duarte.model.Amigo;
import br.com.duarte.service.AmigoService;

@RestController
@RequestMapping("amigo")
public class AmigoController {

	@Autowired
	private AmigoService service;

	/** chama tela de listagem jogo
	 * 
	 * @return
	 */
	@GetMapping
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("/amigo");
		mv.addObject("amigo", service.findAll());

		return mv;
	}

	/** chama tela de adicao de jogo
	 * 
	 * @param jogo
	 * @return
	 */
	@GetMapping("/add")
	public ModelAndView add(Amigo amigo) {
		ModelAndView mv = new ModelAndView("/amigoAdd");
		mv.addObject("amigo/add", amigo);

		return mv;
	}

	@PostMapping("/save")
	public ModelAndView save(@Valid Amigo post, BindingResult result) {
		if (result.hasErrors()) {
			return add(post);
		}
		service.save(post);
		return findAll();
	}

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		return add(service.findOne(id));
	}

	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		service.delete(id);
		return findAll();
	}

}
