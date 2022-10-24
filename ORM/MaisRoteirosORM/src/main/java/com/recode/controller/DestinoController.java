package com.recode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.recode.model.Destinos;
import com.recode.repository.DestinoRepositorio;



@Controller
@RequestMapping("/destinos")
public class DestinoController {
	 @Autowired
	    private DestinoRepositorio destinoRepositorio;

	    @GetMapping
	    public ModelAndView home() {
	        ModelAndView modelAndView = new ModelAndView("Views/destino/destinoLista");

	        modelAndView.addObject("destino", destinoRepositorio.findAll());

	        return modelAndView;
	    }
	    
	    @GetMapping("/cadastrar")
	    public ModelAndView cadastrar() {
	        ModelAndView modelAndView = new ModelAndView("Views/destino/destino");
	        modelAndView.addObject("destino", new Destinos());
	        
	        return modelAndView;
	    }
	      	    	    
	    
		@SuppressWarnings("deprecation")
		@GetMapping("/{id}/editar")
	    public ModelAndView editar(@PathVariable Long id) {
	        ModelAndView modelAndView = new ModelAndView("Views/destino/destinoUpdate");
	        modelAndView.addObject("destino", destinoRepositorio.getOne(id));
	        return modelAndView;
	    }
	    
	    
	    @PostMapping({"/cadastrar", "/{id}/editar"})
	    public String salvar(Destinos destino) {
	        destinoRepositorio.save(destino);
	        return "redirect:/destinos";
	    }
	    
	    @GetMapping("/{id}/excluir")
	    public String excluir(@PathVariable Long id) {
	        destinoRepositorio.deleteById(id);

	        return "redirect:/destinos";
	    }
}
