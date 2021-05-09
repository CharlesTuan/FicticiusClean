package br.com.ficticiusclean.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ficticiusclean.model.Rule;

@Service
public interface RuleService {

	// Servico para salvar a entidade.
	public void save(Rule rule);

	// Servico para listar todas as regras
	public List<Rule> getAll();
}
