package com.example.shop.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class ProductModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@JsonProperty(value = "laptop")
	private String laptop;

	@JsonProperty(value = "mobile")
	private String mobile;

	@JsonProperty(value = "ipad")
	private String ipad;

}
