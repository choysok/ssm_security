package com.page.ssm.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.page.ssm.dao.ProductDao;
import com.page.ssm.domain.Product;
import com.page.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDao productDao;
    @Override
    public List<Product> findAll() throws Exception {
        System.out.println("业务层：查找所有产品---------------------------");
        return productDao.findAll();
    }

    @Override
    public void   saveProduct(Product product) throws Exception {
        System.out.println("业务层：保存产品---------------------------");
        productDao.saveProduct(product);
    }

    @Override
    public Product findById(String id) throws Exception {
        System.out.println("业务层：通过ID查找产品---------------------------");
        return productDao.findById(id);
    }

    @Override
    public List<Product> testPage(int page, int size) throws Exception{
        System.out.println("业务层：分页测试---------------------------");
        return productDao.findAll();
    }
}
