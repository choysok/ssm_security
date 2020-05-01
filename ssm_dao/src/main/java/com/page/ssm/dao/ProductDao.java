package com.page.ssm.dao;

import com.page.ssm.domain.Orders;
import com.page.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductDao {
    //查询所有产品信息
    @Select("select * from product")
     List<Product> findAll() throws Exception;

    @Insert("insert into product(productNum,productName,cityName,pepartureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{pepartureTime},#{productPrice},#{productDesc},#{productStatus})")
    void saveProduct(Product product) throws Exception;

    @Select("select * from product where id=#{id}")
    Product findById(String id) throws Exception;

}
