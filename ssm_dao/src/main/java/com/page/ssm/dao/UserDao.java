package com.page.ssm.dao;

import com.page.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    @Select("select * from users")
    List<UserInfo> findAll();


    @Select("INSERT INTO users(email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo);

    @Select("select * from users where id=#{id}")
    @Results({ //省略了其他 字段 封装。。。many 表示多对多关系
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many=@Many(select = "com.page.ssm.dao.RoleDao.findRoleByUserId"))
    })
     UserInfo findById(String UserId) throws Exception;

}
