package com.liudehuang.datasource.autoconfigration;

import lombok.Data;

/**
 * @BelongProject: ldh_multi_datasource
 * @BelongPackage: com.liudehuang.datasource.autoconfigration
 * @Author: liudehuang
 * @CreateTime: 2019-07-11 20:34:33
 * @Description: todo
 **/
@Data
public class DruidMonitorWebStatFilter {
    /**
     * 是否启用StatFilter默认值true
     */
    private String enabled = "true";

    /**
     * URL过滤规则
     */
    private String urlPattern = "/*";

    /**
     * 不需要忽略的格式信息
     */
    private String exclusions = "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid2/*";

    private String sessionStatEnable = "";

    private String sessionStatMaxCount = "";

    private String principalSessionName = "";

    private String principalCookieName = "";

    private String profileEnable = "";
}
