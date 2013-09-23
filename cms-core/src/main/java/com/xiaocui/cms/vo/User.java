package com.xiaocui.cms.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "t_user")
public class User {
	/**
	 * 用户编号
	 */
	private int id;
	/**
	 * 用户姓名
	 */
	private String name;
	/**
	 * 用户昵称
	 */
	private String nickname;
	/**
	 * 用户名称
	 */
	private String username;
	/**
	 * 用户密码
	 */
	private String password;
	/**
	 * 用户邮箱
	 */
	private String email;
	/**
	 * 手机号码
	 */
	private String phone;
	/**
	 * 电话号码
	 */
	private String telephone;
	/**
	 * 用户状态,0,禁用，1启用
	 */
	private int status;

	/**
	 * 创建时间
	 */
	private Date createDate;

	public User() {
	}

	public User(int id, String name, String nickname, String username,
			String password, String email, String phone, String telephone,
			int status) {
		super();
		this.id = id;
		this.name = name;
		this.nickname = nickname;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.telephone = telephone;
		this.status = status;
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	// JSR303，服务器端验证
	@NotNull(message = "用户名称不能为空")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@NotNull(message = "用户密码不能为空")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Email(message = "邮箱格式不正确")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Column(name = "create_date")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
