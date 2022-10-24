package com.recode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RotasFrontController {

	@GetMapping("/")
	public String Home() {
		return "Views/Home";
	}
	
	@GetMapping("/destino")
	public String Destino() {
		return "Views/destino";
	}
	
	@GetMapping("/promocoes")
	public String Promo() {
		return "Views/promocoes";
	}
	
	@GetMapping("/adm")
	public String Adm() {
		return "Views/homeADM";
	}
	
	
}
