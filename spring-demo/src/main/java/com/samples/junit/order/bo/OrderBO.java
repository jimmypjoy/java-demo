package com.samples.junit.order.bo;

import com.samples.junit.bo.exception.BOException;
import com.samples.junit.order.dto.Order;

public interface OrderBO {

	boolean placeOrder(Order order) throws BOException;

	boolean cancelOrder(int id) throws BOException;

	boolean deleteOrder(int id) throws BOException;

}
