package com.recode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.recode.model.Cliente;
import com.recode.repository.ClienteRepositorio;
import com.recode.repository.LoginRepositorio;



@Controller
@RequestMapping("/cliente")
public class ClienteController {
	 @Autowired
	    private ClienteRepositorio clienteRepositorio;
	 @Autowired
	 private LoginRepositorio loginRepositorio;
	
	    @GetMapping
	    public ModelAndView home() {
	        ModelAndView modelAndView = new ModelAndView("Views/cliente/clienteLista");
	        modelAndView.addObject("cliente", clienteRepositorio.findAll());
	        

	        return modelAndView;
	    }
	    
	    @GetMapping("/cadastro")
	    public ModelAndView cadastrar() {
	        ModelAndView modelAndView = new ModelAndView("Views/login/cadastro");
	        modelAndView.addObject("cliente", new Cliente());
	        modelAndView.addObject("login", loginRepositorio.findAll());
	        
	        return modelAndView;
	    }
	    
	    @GetMapping("/cadastrar")
	    public ModelAndView cadastro() {
	        ModelAndView modelAndView = new ModelAndView("Views/cliente/cliente");
	        modelAndView.addObject("cliente", new Cliente());
	        modelAndView.addObject("login", loginRepositorio.findAll());
	        
	        return modelAndView;
	    }
	      	    	    
	    
		@SuppressWarnings("deprecation")
		@GetMapping("/{id}/editar")
	    public ModelAndView editar(@PathVariable Long id) {
	        ModelAndView modelAndView = new ModelAndView("Views/cliente/clienteUpdate");
	        modelAndView.addObject("cliente", clienteRepositorio.getOne(id));
	        modelAndView.addObject("login", loginRepositorio.findAll());
	        return modelAndView;
	    }
	    
	    
	    @PostMapping({"/cadastrar", "/{id}/editar", "/cadastro"})
	    public String salvar(Cliente cliente) {
	        clienteRepositorio.save(cliente);
	        return "redirect:/cliente";
	    }
	    
	    @GetMapping("/{id}/excluir")
	    public String excluir(@PathVariable Long id) {
	        clienteRepositorio.deleteById(id);

	        return "redirect:/cliente";
	    }
}
