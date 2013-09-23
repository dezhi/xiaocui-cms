package com.xiaocui.cms.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 组对象
 * 
 * @author Administrator
 * 
 */
@Entity
@Table(name = "t_group")
public class Group {
	/**
	 * 组编号
	 */
	private int id;
	/**
	 * 组名称
	 */
	private String name;
	/**
	 * 组描述
	 */
	private String description;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
