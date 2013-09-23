package com.xiaocui.cms.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 角色对象
 * 
 * @author Administrator
 * 
 */
@Entity
@Table(name = "t_role")
public class Role {
	/**
	 * 角色编号
	 */
	private int id;
	/**
	 * 角色名称
	 */
	private String name;
	/**
	 * 角色类型
	 */
	private RoleType roleType;
	/**
	 * 角色描述
	 */
	//private String description;

	public Role() {
	}

	public Role(int id, String name, RoleType roleType) {
		this.id = id;
		this.name = name;
		this.roleType = roleType;
	}

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

	@Column(name = "role_type")
	@Enumerated(EnumType.ORDINAL)
	public RoleType getRoleType() {
		return roleType;
	}

	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}

//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}

}
