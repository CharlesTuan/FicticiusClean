package br.com.ficticiusclean.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ficticiusclean.model.Rule;
import br.com.ficticiusclean.model.Vehicle;

@Service
public interface VehicleService {

	// Salva o registro carro.
    public void save(Vehicle vehicle);

    // Busca todos os carros.
    public List<Vehicle> getAll();
    
    // Busca todos os carros ordenando por gasto com combustivel.
    public List<Vehicle> findAllByOrderBySpentFuelAsc();

    // Deleta um carro.
    public void delete(Vehicle vehicle);
    
    // Atualiza os registros do carro.
    public void updateVehicleData(Rule rule);
}
