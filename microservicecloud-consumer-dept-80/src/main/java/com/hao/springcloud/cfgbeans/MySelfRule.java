package com.hao.springcloud.cfgbeans;

import com.hao.myrule.RandomRuleCustom;
import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySelfRule {
	@Bean
	public IRule myRule() {
//        return new RandomRule();//Ribbon默认是轮询,我自定义为随机
		return new RandomRuleCustom();// 自定义每台机器5次
	}
}
