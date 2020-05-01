package com.page.ssm.dao;


import com.page.ssm.domain.Permission;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PermissionDao {

            @Select("select * from permission where id  in (select permissionId from role_permission where roleId = #{id})")
            List<Permission> findPermissionByRoleId(String id)throws Exception;

}
