package com.xk.xkapiclientsdk;

import com.xk.xkapiclientsdk.client.XkapiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("xk.clinet")
@Data
@ComponentScan
public class XkClinetConfig {
    private String accessKey;
    private String secretKey;

    @Bean
    public XkapiClient xkapiClient(){
        return new XkapiClient(accessKey,secretKey);
    }

}
