package com.jeff_code.jpatest.quickstart.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name="JPA_ITEMS")
@Entity
@Component
public class Item {

	private Integer id;
	private String itemName;
	
	private Set<Category> categories = new HashSet<>();

	@GeneratedValue
	@Id
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="ITEM_NAME")
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	//ʹ�� @ManyToMany ע����ӳ���Զ������ϵ
	//ʹ�� @JoinTable ��ӳ���м��
	//1. name ָ���м�������
	//2. joinColumns ӳ�䵱ǰ�����ڵı����м���е����
	//2.1 name ָ������е�����
	//2.2 referencedColumnName ָ������й�����ǰ�����һ��
	//3. inverseJoinColumns ӳ��������������м������
	@JoinTable(name="ITEM_CATEGORY",
			joinColumns={@JoinColumn(name="ITEM_ID", referencedColumnName="ID")},
			inverseJoinColumns={@JoinColumn(name="CATEGORY_ID", referencedColumnName="ID")})
	@ManyToMany
	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
}
