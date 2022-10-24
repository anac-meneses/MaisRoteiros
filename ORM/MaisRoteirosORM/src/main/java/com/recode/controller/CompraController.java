package com.recode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.recode.model.Compra;
import com.recode.repository.ClienteRepositorio;
import com.recode.repository.CompraRepositorio;
import com.recode.repository.PacotesRepositorio;


@Controller
@RequestMapping("/compra")
public class CompraController {
	@Autowired
	private CompraRepositorio compraRepositorio;

	@Autowired
	private ClienteRepositorio clienteRepositorio;

	@Autowired
	private PacotesRepositorio pacoteRepositorio;

	@GetMapping
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("Views/compra/compraLista");
		modelAndView.addObject("compra", compraRepositorio.findAll());
		return modelAndView;
	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("Views/compra/compra");
		modelAndView.addObject("compra", new Compra());
		modelAndView.addObject("clientes", clienteRepositorio.findAll());
		modelAndView.addObject("pacote", pacoteRepositorio.findAll());
		return modelAndView;
	}

	@SuppressWarnings("deprecation")
	@GetMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("Views/compra/compraUpdate");
		modelAndView.addObject("compra", compraRepositorio.getOne(id));
		modelAndView.addObject("clientes", clienteRepositorio.findAll());
		modelAndView.addObject("pacote", pacoteRepositorio.findAll());
		return modelAndView;
	}
	
	@PostMapping({"/cadastrar", "/{id}/editar"})
	public String salvar(Compra compra) {
		double total = compra.valorTotal();
		
		compra.setValor(total);
		compraRepositorio.save(compra);
		
		return "redirect:/compra";
	}


	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable Long id) {
		compraRepositorio.deleteById(id);

		return "redirect:/compra";
	}
}
