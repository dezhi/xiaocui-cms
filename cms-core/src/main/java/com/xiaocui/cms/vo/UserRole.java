package com.xiaocui.cms.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.xiaocui.cms.vo.User;

/**
 * 用户角色对象，存储用户与角色之间的关联
 * 
 * @author Administrator
 * 
 */
@Entity
@Table(name = "t_user_role")
public class UserRole {
	/**
	 * 用户角色对象 编号
	 */
	private int id;
	/**
	 * 用户对象
	 */
	private User user;
	/**
	 * 角色对象
	 */
	private Role role;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne
	@JoinColumn(name = "role_id")
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}