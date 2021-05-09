package br.com.ficticiusclean.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ficticiusclean.model.Rule;
import br.com.ficticiusclean.model.Vehicle;

@Service
public interface VehicleService {

    public void save(Vehicle vehicle);

    public List<Vehicle> getAll();
    
    public List<Vehicle> findAllByOrderBySpentFuelAsc();

    public void delete(Vehicle vehicle);
    
    public void updateVehicleData(Rule rule);
}
