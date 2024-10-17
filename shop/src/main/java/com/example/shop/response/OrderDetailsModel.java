package com.example.shop.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "order_details")
public class OrderDetailsModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty(value = "order_id")
	private int order_id;

	@JsonProperty(value = "quantity")
	private int quantity;

	@JsonProperty(value = "totalPrice")
	private double totalPrice;

	@JsonProperty(value = "productID")
	private Integer product_id;
}
