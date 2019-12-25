package com.hao.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hao.springcloud.entities.Dept;
import com.hao.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class DeptController {

	@Autowired
	private DeptService service = null;

	// 一但调用服务方法失败并抛出了错误信息后,会自动调用@HystrixCommand标注好的fallbackMethod调用类中指定方法
	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "processHystrixGet")
	public Dept get(@PathVariable("id") Long id) {
		Dept dept = service.get(id);
		if (null == dept) {
			throw new RuntimeException("该ID" + id + "没有对应的信息");
		}
		return dept;
	}

	public Dept processHystrixGet(@PathVariable("id") Long id) {
		return new Dept().setDeptno(id).setDname("该ID" + id + "没有对应的信息,null--@HystrixCommand").setDb_source("no this database in Mysql");
	}

}
