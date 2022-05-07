package com.wowoohr.calculators.family.contribution;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author wowo archetype
 * <p>
 * 项目启动类
 */

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class CalculatorsFamilyApplication {
    public static void main(String[] args) {
        SpringApplication.run(CalculatorsFamilyApplication.class, args);
    }
}
