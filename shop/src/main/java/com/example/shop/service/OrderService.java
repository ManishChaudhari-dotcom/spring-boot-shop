package com.example.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shop.DaoImpl.OrderDetailsDao;
import com.example.shop.response.OrderDetailsModel;

@Service
public class OrderService {

	@Autowired
	OrderDetailsDao orderDetailsDao;

	public OrderDetailsModel saveOrder(OrderDetailsModel orderDetailsModel) {
		// TODO Auto-generated method stub
		return orderDetailsDao.save(orderDetailsModel);
	}

	public void deleteByIds(List<Integer> id) {
		// TODO Auto-generated method stub

		//orderDetailsDao.deleteByIds(id);

	}

	public OrderDetailsModel getOrdersById(Integer id) {
		// TODO Auto-generated method stub
		return orderDetailsDao.findByIds(id);
	}
}
