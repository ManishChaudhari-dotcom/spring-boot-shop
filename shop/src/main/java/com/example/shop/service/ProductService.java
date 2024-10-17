package com.example.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shop.DaoImpl.ProductDao;
import com.example.shop.response.ProductModel;

@Service
public class ProductService{

	@Autowired
	ProductDao productDao;

	public ProductModel saveProduct(ProductModel product) {
		// TODO Auto-generated method stub
		return productDao.save(product);
	}

	public ProductModel getProduct(Integer id) {
		// TODO Auto-generated method stub
		ProductModel data = productDao.findById(id).orElse(null);
		return data;
	}

	public List<ProductModel> getAllProduct() {
		// TODO Auto-generated method stub
		return productDao.getAll();
	}

}
