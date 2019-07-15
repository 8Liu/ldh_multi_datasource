package com.liudehuang.datasource.mapper;

import com.liudehuang.datasource.entity.UserDTO;
import com.liudehuang.datasource.entity.UserEntity;

/**
 * @BelongProject: ldh_multi_datasource
 * @BelongPackage: com.liudehuang.datasource.mapper
 * @Author: liudehuang
 * @CreateTime: 2019-07-15 10:59:01
 * @Description: todo
 **/
public interface UserMapper {
    /**
     * 保存用户
     * @param userEntity
     * @return
     */
    int saveUser(UserEntity userEntity);

    /**
     * 根据用户ID查询用户信息
     * @param userDTO
     * @return
     */
    UserEntity queryUser(UserDTO userDTO);
}
