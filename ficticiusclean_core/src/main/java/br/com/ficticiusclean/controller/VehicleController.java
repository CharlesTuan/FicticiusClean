package br.com.ficticiusclean.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.ficticiusclean.model.Vehicle;
import br.com.ficticiusclean.service.VehicleService;

@Controller
@RequestMapping("/vehicle")
public class VehicleController {

	// chama o servico dos carros.
	@Autowired
	private VehicleService vehicleService;

	// Controller que retorna o template inicial da página dos carros.
	@GetMapping
	public ModelAndView index() {

		// Retorna todos os carros.
		List<Vehicle> vehicleList = vehicleService.getAll();

		// Retorna o template com a lista de carros.
		return new ModelAndView("vehicle/index", "vehicleList", vehicleList);
	}

	// Retorna o template do formulario.
	@GetMapping("/new")
	public ModelAndView createForm(@ModelAttribute Vehicle vehicle) {
		return new ModelAndView("vehicle/form");
	}

	// Salva o resultado do formulario de cadastro de carro.
	@PostMapping(params = "form")
	public ModelAndView save(Vehicle vehicle) {
		
		// Chama o servico do carro para salvar os dados.
		vehicleService.save(vehicle);
		
		// Redireciona para pagina inicial dos carros.
		return new ModelAndView("redirect:/vehicle");
	}

	// Controler para edicao de um carro.
	@GetMapping(value = "/change/{id}")
	public ModelAndView edit(@PathVariable("id") Vehicle vehicle) {
		// Retorna o template do formulario e o carro que sera editado.
		return new ModelAndView("vehicle/form", "vehicle", vehicle);
	}

	// Controller para deletar o carro.
	@GetMapping(value = "/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Vehicle vehicle) {
		
		// Chama o serviço do carro pra deletar o carro.
		vehicleService.delete(vehicle);
		
		// Retorna para tela inicial do carro.
		return new ModelAndView("redirect:/vehicle");
	}
}