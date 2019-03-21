package com.jeff_code.scdemo.providerdept8001.service;


import com.jeff_code.scdemo.beans.Dept;

import java.util.List;

public interface DeptService
{
	public boolean add(Dept dept);

	public Dept get(Long id);

	public List<Dept> list();
}
