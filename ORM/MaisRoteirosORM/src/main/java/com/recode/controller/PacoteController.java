package com.recode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.recode.model.Destinos;
import com.recode.model.Pacotes;
import com.recode.repository.DestinoRepositorio;
import com.recode.repository.PacotesRepositorio;

@Controller
@RequestMapping("/pacote")
public class PacoteController {

	@Autowired
    private PacotesRepositorio pacoteRepositorio;
	
	@Autowired
	private DestinoRepositorio destinoRepositorio;

    @GetMapping
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("Views/pacote/pacoteLista");

        modelAndView.addObject("pacote", pacoteRepositorio.findAll());

        return modelAndView;
    }
    
    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        ModelAndView modelAndView = new ModelAndView("Views/pacote/pacote");
        modelAndView.addObject("pacote", new Pacotes());
        modelAndView.addObject("destino", new Destinos());
        
        return modelAndView;
    }
      	    	    
    
	@SuppressWarnings("deprecation")
	@GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("Views/pacote/pacoteUpdate");
        modelAndView.addObject("pacote", pacoteRepositorio.getOne(id));
        modelAndView.addObject("destino", destinoRepositorio.findAll());
        return modelAndView;
    }
    
   
    @PostMapping({"/cadastrar", "/{id}/editar"})
    public String salvar(Pacotes pacote) {
        pacoteRepositorio.save(pacote);
        return "redirect:/pacote";
    }
    
    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id) {
        pacoteRepositorio.deleteById(id);

        return "redirect:/pacote";
    }
	
}
