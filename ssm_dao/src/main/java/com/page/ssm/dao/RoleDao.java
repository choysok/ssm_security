package com.page.ssm.dao;

import com.page.ssm.domain.Role;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao {

    //根基用户ID查询出所有用户的角色
    @Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
    @Results({  //省略了其他 字段 封装。。。many 表示多对多关系
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "com.page.ssm.dao.PermissionDao.findPermissionByRoleId")),

    })
     List<Role> findRoleByUserId(String UserId) throws Exception;
}
