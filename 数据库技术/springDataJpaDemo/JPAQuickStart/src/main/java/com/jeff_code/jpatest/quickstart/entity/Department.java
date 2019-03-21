package com.jeff_code.jpatest.quickstart.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Table(name="JPA_DEPARTMENTS")
@Entity
@Component
public class Department {

	private Integer id;
	private String deptName;
	
	private Manager mgr;

	@GeneratedValue
	@Id
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="DEPT_NAME")
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	//ʹ�� @OneToOne ��ӳ�� 1-1 ������ϵ��
	//����Ҫ�ڵ�ǰ���ݱ��������������Ҫʹ�� @JoinColumn ������ӳ��. ע��, 1-1 ������ϵ, ������Ҫ��� unique=true
	@JoinColumn(name="MGR_ID", unique=true)
	@OneToOne(fetch=FetchType.LAZY)
	public Manager getMgr() {
		return mgr;
	}

	public void setMgr(Manager mgr) {
		this.mgr = mgr;
	}
}
