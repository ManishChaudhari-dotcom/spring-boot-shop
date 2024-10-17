package com.example.shop.DaoImpl;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.shop.response.OrderDetailsModel;

import jakarta.transaction.Transactional;

@Repository
public interface OrderDetailsDao extends JpaRepository<OrderDetailsModel, Integer>{
	
	@Modifying
	@Transactional
	@Query("DELETE FROM OrderDetailsModel o WHERE o.id IN :id")
	void deleteByIds(List<Integer> id);

	@Query("SELECT o FROM OrderDetailsModel  o WHERE o.order_id = :id")
	OrderDetailsModel findByIds(Integer id);

}
