package com.liudehuang.datasource.entity;

import lombok.Data;

/**
 * @BelongProject: ldh_multi_datasource
 * @BelongPackage: com.liudehuang.datasource.entity
 * @Author: liudehuang
 * @CreateTime: 2019-07-15 11:01:14
 * @Description: todo
 **/
@Data
public class UserEntity {
    /**
     * 序号
     */
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 商户ID
     */
    private String mchId;
}
