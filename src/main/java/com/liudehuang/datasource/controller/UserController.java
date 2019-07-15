package com.liudehuang.datasource.controller;

import com.liudehuang.datasource.entity.UserDTO;
import com.liudehuang.datasource.entity.UserEntity;
import com.liudehuang.datasource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @BelongProject: ldh_multi_datasource
 * @BelongPackage: com.liudehuang.datasource.controller
 * @Author: liudehuang
 * @CreateTime: 2019-07-15 11:00:14
 * @Description: todo
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/queryUser")
    public UserEntity queryUser(UserDTO userDTO){
        return userService.queryUser(userDTO);
    }

    @PostMapping("/saveUser")
    public String saveUser(UserEntity userEntity){
        int row = userService.saveUser(userEntity);
        if(row==1){
            return "success";
        }
        return "fail";
    }
}
