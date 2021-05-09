package br.com.ficticiusclean.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
//Feito um controller para pagina home.
public class HomeController {

	@GetMapping("")
	public ModelAndView index() {
		return new ModelAndView("home/index");
	}
}