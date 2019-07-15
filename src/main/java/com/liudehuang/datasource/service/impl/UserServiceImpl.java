package com.liudehuang.datasource.service.impl;

import com.liudehuang.datasource.annotation.MchDataSource;
import com.liudehuang.datasource.constant.MchDataSourceConstant;
import com.liudehuang.datasource.entity.UserDTO;
import com.liudehuang.datasource.entity.UserEntity;
import com.liudehuang.datasource.mapper.UserMapper;
import com.liudehuang.datasource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @BelongProject: ldh_multi_datasource
 * @BelongPackage: com.liudehuang.datasource.service.impl
 * @Author: liudehuang
 * @CreateTime: 2019-07-15 10:59:42
 * @Description: todo
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @MchDataSource(MchDataSourceConstant.WRITE_DATASOURCE)
    @Override
    public int saveUser(UserEntity entity) {
        int i = userMapper.saveUser(entity);
        return i;
    }

    @MchDataSource(MchDataSourceConstant.READ_DATASOURCE)
    @Override
    public UserEntity queryUser(UserDTO userDTO) {

        return userMapper.queryUser(userDTO);
    }
}
