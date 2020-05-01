package com.page.ssm.service.impl;


import com.github.pagehelper.PageHelper;
import com.page.ssm.dao.OrdersDao;
import com.page.ssm.domain.Orders;
import com.page.ssm.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class OrdersServiceImpl  implements OrdersService {
     @Autowired
    OrdersDao ordersDao;

    @Override
    public List<Orders> findAll() throws Exception {
        PageHelper.startPage(1,1);
        return ordersDao.findAll();
    }

    @Override
    public Orders findById(String orderId) throws Exception{
        return ordersDao.findById(orderId);
    }
}
