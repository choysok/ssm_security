package com.page.ssm.service.impl;

import com.page.ssm.dao.UserDao;
import com.page.ssm.domain.UserInfo;
import com.page.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    UserDao userDao;

    @Override
    public List<UserInfo> findAll() throws Exception{
        System.out.println("业务层————————查询所有用户");
        return userDao.findAll();
    }

    @Override
    public void save(UserInfo userInfo) throws Exception{
        //对密码进行加密
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        userDao.save(userInfo);
        System.out.println("业务层————————保存用户");
    }

    @Override
    public UserInfo findById(String userId) throws Exception {

        return userDao.findById(userId);
    }


}
