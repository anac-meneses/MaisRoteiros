package com.recode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.recode.model.Funcionario;
import com.recode.repository.FuncionarioRepositorio;
import com.recode.repository.LoginRepositorio;
import com.recode.utils.SenhaUtils;

@Controller
@RequestMapping("/funcionario")
public class FuncionarioController {
	
		 @Autowired
		    private FuncionarioRepositorio funcionarioRepositorio;
		 @Autowired
		 private LoginRepositorio loginRepositorio;

		    @GetMapping
		    public ModelAndView home() {
		        ModelAndView modelAndView = new ModelAndView("Views/funcionario/funcionarioLista");
		        modelAndView.addObject("funcionario", funcionarioRepositorio.findAll());
		        return modelAndView;
		    }
		    
		    @GetMapping("/cadastrar")
		    public ModelAndView cadastrar() {
		        ModelAndView modelAndView = new ModelAndView("Views/funcionario/funcionario");
		        modelAndView.addObject("funcionario", new Funcionario());
		        modelAndView.addObject("login", loginRepositorio.findAll());
		        return modelAndView;
		    }
		    
		    
			@SuppressWarnings("deprecation")
			@GetMapping("/{id}/editar")
		    public ModelAndView editar(@PathVariable Long id) {
		        ModelAndView modelAndView = new ModelAndView("Views/funcionario/funcionarioUpdate");
		        modelAndView.addObject("funcionario", funcionarioRepositorio.getOne(id));
		        modelAndView.addObject("login", loginRepositorio.findAll());
		        return modelAndView;
		    }
		    
			@PostMapping({"/cadastrar","/{id}/editar"})
			public String cadastrar(Funcionario funcionario) {
				String senhaEncriptada = SenhaUtils.encode(funcionario.getSenha());
				
				funcionario.setSenha(senhaEncriptada);
				funcionarioRepositorio.save(funcionario);
				
				return "redirect:/funcionario";
			}
			
		    
		   
		    
		    @GetMapping("/{id}/excluir")
		    public String excluir(@PathVariable Long id) {
		    	funcionarioRepositorio.deleteById(id);

		        return "redirect:/funcionario";
		    }
	}


