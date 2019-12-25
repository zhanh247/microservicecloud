package com.hao.springcloud.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hao.springcloud.entities.Dept;

import feign.hystrix.FallbackFactory;

@Component // 不要忘记添加,不要忘记添加
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
	@Override
	public DeptClientService create(Throwable cause) {
		return new DeptClientService() {

			@Override
			public Dept get(Long id) {
				return new Dept().setDeptno(id).setDname("该ID" + id + "没有对应的信息,Consumer客户端提供的降级信息,此服务Provider已经关闭")
						.setDb_source("no this database in Mysql");
			}

			@Override
			public List<Dept> list() {
				return null;
			}

			@Override
			public boolean add(Dept dept) {
				return false;
			}
		};
	}
}