package com.xiaocui.cms.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.xiaocui.cms.vo.User;

/**
 * 用户组对象，存储用户与组之间的关联
 * 
 * @author Administrator
 * 
 */
@Entity
@Table(name = "t_user_group")
public class UserGroup {
	/**
	 * 用户组对象 编号
	 */

	private int id;
	/**
	 * 用户对象
	 */

	private User user;
	/**
	 * 组对象
	 */
	private Group group;

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
	@JoinColumn(name = "group_id")
	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

}
