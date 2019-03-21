package com.jeff_code.jpatest.quickstart.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Table(name="JPA_MANAGERS")
@Entity
@Component
public class Manager {

	private Integer id;
	private String mgrName;
	
	private Department dept;

	@GeneratedValue
	@Id
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="MGR_NAME")
	public String getMgrName() {
		return mgrName;
	}

	public void setMgrName(String mgrName) {
		this.mgrName = mgrName;
	}

	//���ڲ�ά��������ϵ, û�������һ��, ʹ�� @OneToOne ������ӳ��, �������� mappedBy=true
	@OneToOne(mappedBy="mgr")
	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}
}
