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

	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private RuleService ruleService;

	@Override
	public void save(Vehicle vehicle) {
		
		List<Rule> ruleList = ruleService.getAll();
		
		if(!ruleList.isEmpty()) {
			
			Rule rule = ruleList.get(0);
			
			vehicle = this.computationFuelData(vehicle, rule);
		}
		
		vehicleRepository.save(vehicle);
	}

	@Override
	public List<Vehicle> getAll() {
		return vehicleRepository.findAll();
	}

	@Override
	public List<Vehicle> findAllByOrderBySpentFuelAsc() {
		return vehicleRepository.findAllByOrderBySpentFuelAsc();
	}

	@Override
	public void delete(Vehicle vehicle) {
		vehicleRepository.delete(vehicle);
	}

	@Override
	public void updateVehicleData(Rule rule) {

		List<Vehicle> vehicleList = vehicleRepository.findAll();

		List<Vehicle> newestVehicleList = new ArrayList<Vehicle>();

		for (Vehicle vehicle : vehicleList) {

			vehicle = this.computationFuelData(vehicle, rule);

			newestVehicleList.add(vehicle);
		}

		vehicleRepository.saveAll(vehicleList);
		vehicleRepository.flush();
	}

	private Vehicle computationFuelData(Vehicle vehicle, Rule rule) {

		Double totalFuelCity = rule.getCityAverageConsumption() / vehicle.getCityAverageConsumption();

		Double totalFuelStreet = rule.getStreetAverageConsumption() / vehicle.getStreetAverageConsumption();

		Double usedFuel = totalFuelCity + totalFuelStreet;

		Double spentFuel = usedFuel * rule.getGasPrice();

		vehicle.setUsedFuel(usedFuel);
		vehicle.setSpentFuel(spentFuel);

		return vehicle;
	}
}