package br.com.ficticiusclean.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.ficticiusclean.model.Vehicle;
import br.com.ficticiusclean.service.VehicleService;

@Controller
@RequestMapping("/vehicle")
public class VehicleController {
    
    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public ModelAndView index(){
        List<Vehicle> vehicleList = vehicleService.getAll();
        return new ModelAndView("vehicle/index", "vehicleList", vehicleList);
    }

    @GetMapping("/new")
    public ModelAndView createForm(@ModelAttribute Vehicle vehicle) {
        return new ModelAndView("vehicle/form");
    }

    @PostMapping(params="form")
    public ModelAndView save(Vehicle vehicle){
        vehicleService.save(vehicle);
        return new ModelAndView("redirect:/vehicle");
    }
    
    @GetMapping(value = "/change/{id}")
    public ModelAndView edit(@PathVariable("id") Vehicle vehicle){
        return new ModelAndView("vehicle/form", "vehicle", vehicle);
    }
    
    @GetMapping(value="/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Vehicle vehicle){
        vehicleService.delete(vehicle);
        return new ModelAndView("redirect:/vehicle");
    }
}