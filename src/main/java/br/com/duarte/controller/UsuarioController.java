package br.com.duarte.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.duarte.model.Usuario;
import br.com.duarte.service.UsuarioService;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

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
	
	
	
	@RequestMapping(value = "/cadastro", method = RequestMethod.GET)
	public ModelAndView registration() {
		ModelAndView modelAndView = new ModelAndView();
		Usuario Usuario = new Usuario();
		modelAndView.addObject("Usuario", Usuario);
		modelAndView.setViewName("cadastro");
		return modelAndView;
	}

	@RequestMapping(value = "/cadastro", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid Usuario usuario, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
//		Usuario usuarioExists = usuarioService.findUsuarioByLogin(usuario.getLogin());
//        if (usuarioExists != null) {
//            bindingResult
//                    .rejectValue("email", "error.user",
//                            "There is already a user registered with the email provided");
//        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("cadastro");
        } else {
        	service.saveUsuario(usuario);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new Usuario());
            modelAndView.setViewName("cadastro");

        }
        return modelAndView;
    }

}
