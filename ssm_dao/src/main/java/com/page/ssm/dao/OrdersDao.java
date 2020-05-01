package com.page.ssm.dao;

import com.page.ssm.domain.Orders;
import com.page.ssm.domain.Product;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersDao {


    Orders findById(String orderId) throws Exception;

    @Select("select * from orders")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(id=true,property = "orderNum",column = "orderNum"),
            @Result(id=true,property = "orderTime",column = "orderTime"),
            @Result(id=true,property = "peopleCount",column = "peopleCount"),
            @Result(id=true,property = "orderStatus",column = "orderStatus"),
            @Result(id=true,property = "orderDesc",column = "orderDesc"),
            @Result(id=true,property = "payType",column = "payType"),
            @Result(id=true,property = "product",column = "productId",javaType = Product.class,one = @One(select = "com.page.ssm.dao.ProductDao.findById")),
    })
    List<Orders> findAll() throws Exception;
}
