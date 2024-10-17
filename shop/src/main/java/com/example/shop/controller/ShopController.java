package com.example.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.shop.Exception.ResourceNotFoundException;
import com.example.shop.response.OrderDetailsModel;
import com.example.shop.response.ProductModel;
import com.example.shop.service.OrderService;
import com.example.shop.service.ProductService;

@RestController
@RequestMapping("/shop")
public class ShopController {

	@Autowired
	ProductService productService;

	@Autowired
	OrderService orderService;

	@GetMapping("/getProduct")
	public ResponseEntity<ProductModel> getProduct(@RequestParam Integer id) {
		ProductModel data = productService.getProduct(id);
		return ResponseEntity.ok(data);

	}

	@PostMapping("/product")
	public ResponseEntity<String> saveProduct(@RequestBody List<ProductModel> productList) {
		for (ProductModel product : productList) {
			productService.saveProduct(product); // Save each product individually
		}

		return ResponseEntity.ok("Batch of product added successfully");

	}

	@GetMapping("/getAllProduct")
	public ResponseEntity<java.util.List<ProductModel>> getProduct() {
		java.util.List<ProductModel> data = productService.getAllProduct();
		return ResponseEntity.ok(data);

	}

	@PostMapping("/orders")
	public ResponseEntity<String> createOrder(@RequestBody List<OrderDetailsModel> orderDetailsModel) {
		for (OrderDetailsModel orderData : orderDetailsModel) {
			orderService.saveOrder(orderData);
		}

		return ResponseEntity.ok("Order is done successfully");
	}

	@GetMapping("/getOrderById")
	public ResponseEntity<OrderDetailsModel> getOrdersById(@RequestParam Integer id) {
		OrderDetailsModel orderData = orderService.getOrdersById(id);
		if (orderData == null) {
			throw new ResourceNotFoundException("User not found with id: " + id);
		}
		return ResponseEntity.ok(orderData);
	}

	@DeleteMapping("/deleteOrder")
	public ResponseEntity<String> deleteOrders(@RequestParam List<Integer> id) {
		orderService.deleteByIds(id);
		return ResponseEntity.ok("Order is deleted successfully");
	}

}
