package br.com.ficticiusclean.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(length = 20, nullable = false)
	private String name;

	@Column(length = 40, nullable = false)
	private String model;

	@Column(length = 20, nullable = false)
	private String brand;

	@Temporal(value = TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date manufacturingDate;

	@Column(nullable = false)
	private Double cityAverageConsumption;

	@Column(nullable = false)
	private Double streetAverageConsumption;

	@Column(nullable = true, columnDefinition = "double default 0")
	private Double usedFuel  = 0.0;

	@Column(nullable = true, columnDefinition = "double default 0")
	private Double spentFuel  = 0.0;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Date getManufacturingDate() {
		return manufacturingDate;
	}

	public void setManufacturingDate(Date manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}

	public Double getCityAverageConsumption() {
		return cityAverageConsumption;
	}

	public void setCityAverageConsumption(Double cityAverageConsumption) {
		this.cityAverageConsumption = cityAverageConsumption;
	}

	public Double getStreetAverageConsumption() {
		return streetAverageConsumption;
	}

	public void setStreetAverageConsumption(Double streetAverageConsumption) {
		this.streetAverageConsumption = streetAverageConsumption;
	}

	public Double getUsedFuel() {
		return usedFuel;
	}

	public void setUsedFuel(Double usedFuel) {
		this.usedFuel = usedFuel;
	}

	public Double getSpentFuel() {
		return spentFuel;
	}

	public void setSpentFuel(Double spentFuel) {
		this.spentFuel = spentFuel;
	}
}