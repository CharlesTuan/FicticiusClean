package br.com.ficticiusclean.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ficticiusclean.model.Vehicle;

// Repositório de querry dos carros
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

	// Querry moldada pelo nome do metodo.
	public List<Vehicle> findAllByOrderBySpentFuelAsc();
}