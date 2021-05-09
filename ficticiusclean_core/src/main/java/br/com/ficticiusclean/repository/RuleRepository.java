package br.com.ficticiusclean.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ficticiusclean.model.Rule;

@Repository
public interface RuleRepository extends JpaRepository<Rule, Long>{
}
