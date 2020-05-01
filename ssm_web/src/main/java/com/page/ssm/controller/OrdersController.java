package com.page.ssm.controller;

import com.page.ssm.domain.Orders;
import com.page.ssm.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    OrdersService ordersService;


    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true) String orderId) throws Exception {
        ModelAndView mv = new ModelAndView();
        Orders orders = ordersService.findById(orderId);
        return mv;
    }
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Orders> ordersList = ordersService.findAll();
        mv.addObject("ordersList",ordersList);
        mv.setViewName("orders-list");
        return mv;
    }



}
