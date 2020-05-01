package com.page.ssm.service;

import com.page.ssm.domain.Orders;
import org.springframework.core.annotation.Order;

import java.util.List;

public interface OrdersService {

      List<Orders> findAll() throws Exception;

      Orders findById(String orderId) throws Exception;
}
