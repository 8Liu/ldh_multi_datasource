package com.liudehuang.datasource.entity;

import lombok.Data;

/**
 * @BelongProject: ldh_multi_datasource
 * @BelongPackage: com.liudehuang.datasource.entity
 * @Author: liudehuang
 * @CreateTime: 2019-07-15 14:23:33
 * @Description: todo
 **/
@Data
public class MchEntity {

    private Integer id;

    private Long mchId;

    private String mchName;

    private Integer dataSource;
}
