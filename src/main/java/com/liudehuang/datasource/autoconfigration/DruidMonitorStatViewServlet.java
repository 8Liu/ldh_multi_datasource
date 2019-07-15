package com.liudehuang.datasource.autoconfigration;

import lombok.Data;

/**
 * @BelongProject: ldh_multi_datasource
 * @BelongPackage: com.liudehuang.datasource.autoconfigration
 * @Author: liudehuang
 * @CreateTime: 2019-07-11 20:35:24
 * @Description: todo
 **/
@Data
public class DruidMonitorStatViewServlet {
    /**
     * 是否启用StatViewServlet默认值true
     */
    private String enabled = "true";

    /**
     * URL Mappings映射
     */
    private String urlPattern = "/druid/*";

    /**
     * 白名单
     */
    private String allow = "";
    /**
     * IP黑名单(存在共同时，deny优先于allow)
     */
    private String deny = "";
    /**
     * 登录查看信息的账号
     */
    private String loginUsername = "siss";

    /**
     * 登录查看信息的密码
     */
    private String loginPassword = "admin";

    /**
     * 是否能够重置数据
     */
    private String resetEnable = "false";
}
