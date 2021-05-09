package br.com.ficticiusclean.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ficticiusclean.model.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long>{
	
	public List<Vehicle> findAllByOrderBySpentFuelAsc();
}