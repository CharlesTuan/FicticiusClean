package br.com.ficticiusclean.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ficticiusclean.model.Rule;

@Service
public interface RuleService {

	public void save(Rule rule);

	public List<Rule> getAll();

	public void delete(Rule rule);

}
