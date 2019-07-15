package com.liudehuang.datasource.service;

import com.liudehuang.datasource.entity.UserDTO;
import com.liudehuang.datasource.entity.UserEntity;

/**
 * @BelongProject: ldh_multi_datasource
 * @BelongPackage: com.liudehuang.datasource.service
 * @Author: liudehuang
 * @CreateTime: 2019-07-15 10:59:29
 * @Description:
 **/
public interface UserService {
    /**
     * 保存用户
     * @param entity
     * @return
     */
    int saveUser(UserEntity entity);

    /**
     * 查询用户信息
     * @param userDTO
     * @return
     */
    UserEntity queryUser(UserDTO userDTO);
}
