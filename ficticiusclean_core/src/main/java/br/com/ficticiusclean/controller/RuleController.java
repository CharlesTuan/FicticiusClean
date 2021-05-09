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
//Controller de implementacao das regras inseridas pelo usuario.
public class RuleController {

	// chama o servico das regras.
	@Autowired
	private RuleService ruleService;

	// chama o servico dos carros.
	@Autowired
	private VehicleService vehicleService;

	// Chama a pagina index das regras, que seria o analitico
	@GetMapping
	public ModelAndView index() {

		// Tras a lista ordenada pelo gasto com gasolina do menor para o maior.
		List<Vehicle> vehicleList = vehicleService.findAllByOrderBySpentFuelAsc();

		// Retorna o template com a lista dos carros ordenada.
		return new ModelAndView("rule/index", "vehicleList", vehicleList);
	}

	// Chama o formulário para cadastro de regra
	@GetMapping("/new")
	public ModelAndView createForm(@ModelAttribute Rule rule) {

		// Busca as regras cadastradas, feito dessa forma para ser possivel cadastrar
		// varias regras
		// o que não acontece no estado atual por questoes de tempo.
		List<Rule> ruleList = ruleService.getAll();

		// Valida se a lista não está vazia
		if (!ruleList.isEmpty()) {
			// Insere a regra encontrada.
			rule = ruleList.get(0);
		}

		// Retorna o template com a regra encontrada ou uma regra nula.
		return new ModelAndView("rule/form", "rule", rule);
	}

	// Grava o restultado do formulário
	@PostMapping(params = "form")
	public ModelAndView save(Rule rule) {

		// Chama o servico para gravar o que vier do formulário
		ruleService.save(rule);

		// Retorna para o index da regra.
		return new ModelAndView("redirect:/rule");
	}
}
