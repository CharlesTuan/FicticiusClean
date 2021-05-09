package br.com.ficticiusclean.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ficticiusclean.model.Rule;
import br.com.ficticiusclean.repository.RuleRepository;
import br.com.ficticiusclean.service.RuleService;
import br.com.ficticiusclean.service.VehicleService;

@Service
public class RuleServiceImpl implements RuleService {

	@Autowired
	private RuleRepository ruleRepository;
	
	@Autowired
	private VehicleService vehicleService;

	@Override
	public void save(Rule rule) {
		List<Rule> ruleList = ruleRepository.findAll();
		
		if(!ruleList.isEmpty()) {
			long ruleId = ruleList.get(0).getId();
			rule.setId(ruleId);
		}

		ruleRepository.save(rule);
		
		vehicleService.updateVehicleData(rule);
	}
	
	@Override
	public List<Rule> getAll() {
		return ruleRepository.findAll();
	}

	@Override
	public void delete(Rule rule) {
		ruleRepository.delete(rule);
	}

}
