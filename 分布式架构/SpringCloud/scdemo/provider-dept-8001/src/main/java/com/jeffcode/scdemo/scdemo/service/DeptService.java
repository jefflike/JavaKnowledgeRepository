package com.jeffcode.scdemo.scdemo.service;


import com.jeffcode.scdemo.entities.Dept;

import java.util.List;

public interface DeptService
{
	public boolean add(Dept dept);

	public Dept get(Long id);

	public List<Dept> list();
}
