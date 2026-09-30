package com.atguigu.product.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix = "product") //配置批量绑定在nacos下，可以无需@RefreshScope就能实现自动刷新
@Data
public class ProductProperties {
    String timeout;
    String autoConfirm;
    String dbUrl;

    // timeoutTest or exceptionTest
    private long timeoutTest;
    private String exceptionTest;
}
