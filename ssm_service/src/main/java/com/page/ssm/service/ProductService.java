package com.page.ssm.service;

import com.page.ssm.domain.Product;

import java.util.List;

public interface ProductService {
    //查询所有产品信息
    List<Product> findAll() throws Exception;


    void saveProduct(Product product) throws Exception;

    Product findById(String id)throws Exception;

    List<Product> testPage(int page, int size) throws Exception;
}
