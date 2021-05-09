package br.com.ficticiusclean.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.ficticiusclean.model.Rule;
import br.com.ficticiusclean.model.Vehicle;
import br.com.ficticiusclean.service.RuleService;
import br.com.ficticiusclean.service.VehicleService;

@Controller
@RequestMapping("/rule")
public class RuleController {

	@Autowired
	private RuleService ruleService;
	
	@Autowired
	private VehicleService vehicleService;

	@GetMapping
	public ModelAndView index() {
		List<Vehicle> vehicleList = vehicleService.findAllByOrderBySpentFuelAsc();
		return new ModelAndView("rule/index", "vehicleList", vehicleList);
	}

	@GetMapping("/new")
	public ModelAndView createForm(@ModelAttribute Rule rule) {
		List<Rule> ruleList = ruleService.getAll();
		
		if(!ruleList.isEmpty()) {
			rule = ruleList.get(0);
		}
		
		return new ModelAndView("rule/form", "rule", rule);
	}

	@PostMapping(params = "form")
	public ModelAndView save(Rule rule) {
		ruleService.save(rule);
		return new ModelAndView("redirect:/rule");
	}
}
