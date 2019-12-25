package com.hao.springcloud.service;

import java.util.List;

import com.hao.springcloud.entities.Dept;

public interface DeptService {
	boolean add(Dept dept);

	Dept get(Long id);

	List<Dept> list();
}
