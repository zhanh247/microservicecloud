package com.hao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.hao.springcloud.cfgbeans.MySelfRule;

@SpringBootApplication
@EnableEurekaClient
//@RibbonClient 自定义负载均衡规则时才需要开启，使用默认规则时无需使用该规则
@RibbonClient(name = "MICROSERVICECLOUD-DEPT", configuration = MySelfRule.class)
public class DeptConsumer80_App {
	public static void main(String[] args) {
		SpringApplication.run(DeptConsumer80_App.class, args);
	}
}
