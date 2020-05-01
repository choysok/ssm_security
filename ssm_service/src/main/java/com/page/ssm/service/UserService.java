package com.page.ssm.service;


import com.page.ssm.domain.UserInfo;

import java.util.List;

public interface UserService {

     List<UserInfo>  findAll() throws Exception;

     void save(UserInfo userInfo)throws  Exception;

     UserInfo findById(String userId) throws Exception;
}
