package com.xlhl.publicapiclientsdk;

import com.xlhl.publicapiclientsdk.clint.PublicApiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * PublicApiConfig
 *
 * @author xlhl
 * @version 1.0
 * @description 配置文件
 */
@Configuration
@ConfigurationProperties(prefix = "xlhl.client")
@Data
@ComponentScan
public class PublicApiConfig {
    private String secretKey;

    private String accessKey;

    @Bean
    public PublicApiClient publicApiClient() {
        return new PublicApiClient(accessKey, secretKey);
    }
}
