package br.com.ficticiusclean.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private Double gasPrice;

	@Column(nullable = false)
	private Double cityAverageConsumption;

	@Column(nullable = false)
	private Double streetAverageConsumption;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Double getGasPrice() {
		return gasPrice;
	}

	public void setGasPrice(Double gasPrice) {
		this.gasPrice = gasPrice;
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
}
