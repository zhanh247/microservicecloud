package com.hao.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;

@Configuration
public class ConfigBean {
	// boot --->spring applicationContext.xml ---@Configuration ConfigBean ==
	// applicationContext.xml

	@Bean
	@LoadBalanced // Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端 负载均衡工具
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	// 没有自定义规则时，采用的事默认的轮询方式，有自定义，则采用的是自定义的方式
	@Bean
	public IRule myRule() {
		// return new RoundRobinRule();//轮休
		return new RetryRule();// 重试
		// return new RandomRule();//随机
	}
}
