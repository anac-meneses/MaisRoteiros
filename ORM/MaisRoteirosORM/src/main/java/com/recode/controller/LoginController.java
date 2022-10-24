package com.recode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.recode.model.Login;
import com.recode.repository.LoginRepositorio;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private LoginRepositorio loginRep;

	@GetMapping
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("Views/loginADM");
		return modelAndView;
	}

	@GetMapping("/cadastro")
	public ModelAndView cadastrar(Login login) {
		ModelAndView modelAndView = new ModelAndView("Views/login/cadastro");
		modelAndView.addObject("login", new Login());
		loginRep.save(login);

		return modelAndView;

	}
}
