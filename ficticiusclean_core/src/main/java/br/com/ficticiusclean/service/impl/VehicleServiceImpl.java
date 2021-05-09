package br.com.ficticiusclean.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ficticiusclean.model.Rule;
import br.com.ficticiusclean.model.Vehicle;
import br.com.ficticiusclean.repository.VehicleRepository;
import br.com.ficticiusclean.service.RuleService;
import br.com.ficticiusclean.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService {

	// Chamando repositorio do carro.
	@Autowired
	private VehicleRepository vehicleRepository;

	// Chamando o servico das regras.
	@Autowired
	private RuleService ruleService;

	// Metodo para salvar o carro
	@Override
	public void save(Vehicle vehicle) {

		// Busca as regras
		List<Rule> ruleList = ruleService.getAll();

		// Verifica se existe as regras
		if (!ruleList.isEmpty()) {

			// Pega a regra cadastrada
			Rule rule = ruleList.get(0);

			// Calcula os dados de uso e gasto com gasolina
			vehicle = this.computationFuelData(vehicle, rule);
		}

		// Salva o carro
		vehicleRepository.save(vehicle);
	}

	// Pega todos os carros
	@Override
	public List<Vehicle> getAll() {
		return vehicleRepository.findAll();
	}

	// Pega todos os dados ordenando por gasto com gasolina, do menor para o maior
	@Override
	public List<Vehicle> findAllByOrderBySpentFuelAsc() {
		return vehicleRepository.findAllByOrderBySpentFuelAsc();
	}

	// Deleta o registro do carro
	@Override
	public void delete(Vehicle vehicle) {
		vehicleRepository.delete(vehicle);
	}

	// Atualiza os dados do carro
	@Override
	public void updateVehicleData(Rule rule) {

		// Pega todos os carros
		List<Vehicle> vehicleList = vehicleRepository.findAll();

		// Cria uma lista para colocar os carros atualizados
		List<Vehicle> newestVehicleList = new ArrayList<Vehicle>();

		// Para cada carro ele calula o gasto baseado na regra
		for (Vehicle vehicle : vehicleList) {

			// Chama o metodo que calcula os gastos
			vehicle = this.computationFuelData(vehicle, rule);

			// Adiciona na lista de carros atualizados
			newestVehicleList.add(vehicle);
		}

		// Atualiza todos os carros
		vehicleRepository.saveAll(vehicleList);
	}

	// Calcula os dados e retorna o carro atualizado
	private Vehicle computationFuelData(Vehicle vehicle, Rule rule) {

		// Calcula quanto combustivel foi utilizado na cidade
		Double totalFuelCity = rule.getCityAverageConsumption() / vehicle.getCityAverageConsumption();

		// Calcula quanto combustivel foi utilizado na rodovia
		Double totalFuelStreet = rule.getStreetAverageConsumption() / vehicle.getStreetAverageConsumption();

		// Calcula o combustivel total.
		Double usedFuel = totalFuelCity + totalFuelStreet;

		// Converte a gasolina gasta em dinheiro
		Double spentFuel = usedFuel * rule.getGasPrice();

		// Atualiza o carro
		vehicle.setUsedFuel(usedFuel);
		vehicle.setSpentFuel(spentFuel);

		// Volta o carro atualizado
		return vehicle;
	}
}