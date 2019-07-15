package com.liudehuang.datasource.autoconfigration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "druid.wiki")
public class DruidMonitorProperties {
    /**
     * WebStatFilter配置，说明请参考Druid Wiki，配置_配置WebStatFilter
     */
    private DruidMonitorWebStatFilter webStatFilter = new DruidMonitorWebStatFilter();

    /**
     * StatViewServlet配置，说明请参考Druid Wiki，配置_StatViewServlet配置
     */
    private DruidMonitorStatViewServlet statViewServlet = new DruidMonitorStatViewServlet();

}