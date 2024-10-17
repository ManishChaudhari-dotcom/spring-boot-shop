package com.example.shop.DaoImpl;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.shop.response.ProductModel;

@Repository
public interface ProductDao extends JpaRepository<ProductModel, Integer> {

	@Query("SELECT p FROM ProductModel p")
	public List<ProductModel> getAll();

}
