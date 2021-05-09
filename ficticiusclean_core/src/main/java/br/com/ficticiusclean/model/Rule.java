package br.com.ficticiusclean.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// Entidade da regra.
@Entity
public class Rule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	// Preço da gasolina.
	@Column(nullable = false)
	private Double gasPrice;

	// Distância rodada na cidade.
	@Column(nullable = false)
	private Double cityAverageConsumption;

	// Distancia rodada na rodovia(chamada de "street" por questoes de complexidade de nome,
	// pois highway ficaria um pouco estranho a leitura.
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
