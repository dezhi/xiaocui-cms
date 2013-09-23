package com.xiaocui.cms.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_keyword")
public class Keyword {
	/**
	 * 关键词 编号
	 */
	private int id;
	/**
	 * 关键词 名称
	 */
	private String name;
	/**
	 * 关键词 引用次数
	 */
	private int times;
	/**
	 * 关键词 完整拼音
	 */
	private String nameFullPy;
	/**
	 * 关键词 简短拼音 Py
	 */
	private String nameShortPy;

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

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}

	public String getNameFullPy() {
		return nameFullPy;
	}

	public void setNameFullPy(String nameFullPy) {
		this.nameFullPy = nameFullPy;
	}

	@Column(name = "name_full_py")
	public String getNameShortPy() {
		return nameShortPy;
	}

	@Column(name = "name_short_py")
	public void setNameShortPy(String nameShortPy) {
		this.nameShortPy = nameShortPy;
	}

}
