package com.zyj.autowired.dao;

import org.springframework.stereotype.Component;

@Component
public class UserDao {
	OrderDao orderDao;

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
}
