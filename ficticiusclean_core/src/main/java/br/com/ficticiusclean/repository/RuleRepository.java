package br.com.ficticiusclean.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ficticiusclean.model.Rule;

// Repositorio de querry das regras.
@Repository
public interface RuleRepository extends JpaRepository<Rule, Long> {
	// Deixado vazio, pois so utilizei as querrys que o jpa disponibiliza por padrao
}
