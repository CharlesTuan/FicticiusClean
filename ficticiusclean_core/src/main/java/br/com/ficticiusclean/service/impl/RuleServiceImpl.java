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

	// Carrega o repositorio de regra.
	@Autowired
	private RuleRepository ruleRepository;

	// Carrega o repositório do carro.
	@Autowired
	private VehicleService vehicleService;

	// Salva ou atualiza o registro de regra.
	@Override
	public void save(Rule rule) {
		// Pega as regras cadastradas
		List<Rule> ruleList = ruleRepository.findAll();

		// Verifica se a lista está nula.
		if (!ruleList.isEmpty()) {
			
			// Se a lista não estive nula, ele pega o id do registro do banco.
			long ruleId = ruleList.get(0).getId();
			
			// Configura para atualizar o registro do banco com os dados do formulario.
			rule.setId(ruleId);
		}

		// Salva a regra.
		ruleRepository.save(rule);

		// Atualiza os dados de todos os carro baseado na nova regra.
		vehicleService.updateVehicleData(rule);
	}

	// Serviço que busca todas as regras.
	@Override
	public List<Rule> getAll() {
		return ruleRepository.findAll();
	}

}
